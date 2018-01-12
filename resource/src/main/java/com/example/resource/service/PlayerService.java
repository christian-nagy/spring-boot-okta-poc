package com.example.resource.service;

import com.example.resource.model.Player;
import com.example.resource.model.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Slf4j
@Component
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Collection<Player> findAll() {
        return playerRepository.findAll();
    }

}
