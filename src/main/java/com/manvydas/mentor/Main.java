package com.manvydas.mentor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);

    }
    public static void disableWarning() {
        System.err.close();
        System.setErr(System.out);
    }
}
