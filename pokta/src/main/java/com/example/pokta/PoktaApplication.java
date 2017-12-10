package com.example.pokta;

import com.example.pokta.model.Tournament;
import com.example.pokta.model.TournamentRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@EnableDiscoveryClient
@SpringBootApplication
public class PoktaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoktaApplication.class, args);
    }

    @Bean
    ApplicationRunner run(TournamentRepository repository) {
        return args -> Stream.of("Portugal", "UK", "Paris", "Hong Kong")
                .forEach(tournamentName -> repository.save(new Tournament(null, tournamentName)));
    }
}
