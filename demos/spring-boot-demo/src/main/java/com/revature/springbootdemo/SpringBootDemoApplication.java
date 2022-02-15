package com.revature.springbootdemo;

import com.revature.springbootdemo.beans.repositories.AccountRepo;
import com.revature.springbootdemo.beans.repositories.UserRepo;
import com.revature.springbootdemo.beans.utilities.ApplicationContextProvider;
import com.revature.springbootdemo.beans.entities.Account;
import com.revature.springbootdemo.beans.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "com.revature.springbootdemo.beans")
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);

		ApplicationContext context = ApplicationContextProvider.getApplicationContext();
		AccountRepo accountRepo = context.getBean(AccountRepo.class);
		UserRepo userRepo = context.getBean(UserRepo.class);

		Account account = new Account(50.0, "checking");
		accountRepo.save(account);
		User user = new User("kplummer", "password");
		user.addAccount(account);
		userRepo.save(user);

		

	}
}
