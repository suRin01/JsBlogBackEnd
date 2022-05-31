package com.jsbird.jsblog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class JsblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsblogApplication.class, args);
        log.info("Start server");
    }

}
