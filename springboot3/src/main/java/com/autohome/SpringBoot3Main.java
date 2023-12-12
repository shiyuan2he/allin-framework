package com.autohome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot3Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        new SpringApplication(SpringBoot3Main.class).run(args);
    }
}