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

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    public final UserRepo userRepo;
    public final AccountRepo accountRepo;

    @Autowired
    public UserController(UserRepo userRepo, AccountRepo accountRepo) {
        this.userRepo = userRepo;
        this.accountRepo = accountRepo;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void newUser(@RequestBody User user) {
        userRepo.save(user);
    }

    @RequestMapping(value = "/{userId}")
    public User getUserById(@PathVariable Integer userId) throws UserNotFoundException {
        Optional<User> optionalUser = userRepo.findById(userId);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new UserNotFoundException("User not found!");
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUser(@RequestBody User user) {
        userRepo.save(user);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@RequestBody User user) {
        Optional<User> optionalUser = userRepo.findById(user.getUserId());
        optionalUser.ifPresent(value -> accountRepo.deleteAll(value.getAccounts())); //hey look, a lambda!
        userRepo.delete(user);
    }

    @ExceptionHandler({ AccountNotFoundException.class, UserNotFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleException() {
        //log it?
    }
}
