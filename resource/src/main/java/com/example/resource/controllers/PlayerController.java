package com.example.resource.controllers;


import com.example.resource.model.Player;
import com.example.resource.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Slf4j
@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public Collection<Player> getPlayers() {
        log.info("Get all tournaments!");
        return playerService.findAll();
    }
}