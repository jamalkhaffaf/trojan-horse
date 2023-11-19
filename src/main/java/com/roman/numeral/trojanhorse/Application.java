package com.roman.numeral.trojanhorse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    /**
     * Main method.
     * @param args main method args.
     */
    public static void main(final String... args) {
        new Application().run(args);
    }

    private void run(String... args) {
        SpringApplication.run(Application.class, args);
    }

}
