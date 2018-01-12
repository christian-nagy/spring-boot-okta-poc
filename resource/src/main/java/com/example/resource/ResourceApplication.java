package com.example.resource;

import com.example.resource.model.Player;
import com.example.resource.model.PlayerRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@EnableDiscoveryClient
@SpringBootApplication
public class ResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }

    @Bean
    ApplicationRunner run(PlayerRepository repository) {
        return args -> Stream.of("Paul Casey", "Henrik Stenson", "Justin Rose", "Jon Rahm")
                .forEach(playerName -> repository.save(new Player(null,
                        playerName.substring(0, playerName.indexOf(" ")),
                        playerName.substring(playerName.indexOf(" ")))));
    }
}
