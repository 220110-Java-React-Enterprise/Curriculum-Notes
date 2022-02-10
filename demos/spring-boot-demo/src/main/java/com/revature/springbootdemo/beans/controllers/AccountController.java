package com.revature.springbootdemo.beans.controllers;

import com.revature.springbootdemo.beans.entities.Account;
import com.revature.springbootdemo.beans.entities.User;
import com.revature.springbootdemo.beans.repositories.AccountRepo;
import com.revature.springbootdemo.beans.repositories.UserRepo;
import com.revature.springbootdemo.exceptions.AccountNotFoundException;
import com.revature.springbootdemo.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users/{userId}/accounts")
public class AccountController {
    private final AccountRepo accountRepo;
    private final UserRepo userRepo;

    @Autowired //spring provides our repos by autowiring them into this constructor
    public AccountController(AccountRepo accountRepo, UserRepo userRepo) {
        this.accountRepo = accountRepo;
        this.userRepo = userRepo;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void newAccountForUser(@RequestBody Account account, @PathVariable Integer userId) throws UserNotFoundException {
        Optional<User> optionalUser = userRepo.findById(userId);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.addAccount(account);
            accountRepo.save(account);
            userRepo.save(user);
        } else {
            throw new UserNotFoundException("User not found!");
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAllAccountsForUser(@PathVariable Integer userId) throws UserNotFoundException {
        Optional<User> optionalUser = userRepo.findById(userId);
        if(optionalUser.isPresent()) {
            return optionalUser.get().getAccounts();
        } else {
            throw new UserNotFoundException("User not found!");
        }
    }

    @RequestMapping(value = "/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public Account getAccountForUserById(@PathVariable Integer userId, @PathVariable Integer accountId) throws UserNotFoundException, AccountNotFoundException {
        Optional<User> optionalUser = userRepo.findById(userId);
        if(optionalUser.isPresent()) {
            for (Account account : optionalUser.get().getAccounts()) {
                if(account.getAccountId().equals(accountId)) {
                    return account;
                }
            }
        } else {
            throw new UserNotFoundException("User not found!");
        }

        throw new AccountNotFoundException("Account not found!");
    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateAccount(@RequestBody Account updatedAccount, @PathVariable Integer accountId) throws AccountNotFoundException {
        Optional<Account> optionalAccount = accountRepo.findById(accountId);
        if(optionalAccount.isPresent() && updatedAccount.getAccountId().equals(accountId)) {
            accountRepo.save(updatedAccount);
        } else {
            throw new AccountNotFoundException("Account not found!");
        }
    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccount(@PathVariable Integer userId, @PathVariable Integer accountId) throws UserNotFoundException {
        Optional<User> optionalUser = userRepo.findById(userId);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            for (Account account : user.getAccounts()) {
                if(account.getAccountId().equals(accountId)) {
                    user.removeAccount(account);
                    accountRepo.delete(account);
                    userRepo.save(user);
                    break;
                }
            }
        } else {
            throw new UserNotFoundException("User not found!");
        }
    }
}
