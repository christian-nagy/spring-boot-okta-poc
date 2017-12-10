package com.example.gateway.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@FeignClient("pokta")
public interface TournamentClient {

    @RequestMapping("/tournaments")
    Collection<Tournament> getTournaments();
}
