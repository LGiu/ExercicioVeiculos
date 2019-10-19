package br.com.neogrid;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class NeogridApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeogridApplication.class, args);
    }

    /*@Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
        }
    }*/
}
