package com.sd22.dbproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2 TODO: fix bug where enabling this make the app crash
public class DbProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbProjectApplication.class, args);
    }

}
