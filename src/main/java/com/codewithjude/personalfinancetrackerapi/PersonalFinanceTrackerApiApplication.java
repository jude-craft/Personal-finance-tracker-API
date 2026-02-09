package com.codewithjude.personalfinancetrackerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})  // Tells Spring to ignore database
public class PersonalFinanceTrackerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalFinanceTrackerApiApplication.class, args);
    }
}
