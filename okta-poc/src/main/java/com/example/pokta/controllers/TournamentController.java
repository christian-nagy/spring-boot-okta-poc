package com.example.pokta.controllers;

import com.example.pokta.model.Tournament;
import com.example.pokta.service.TournamentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public Collection<Tournament> getTournaments() {
        log.info("Get all tournaments!");
        return tournamentService.findAll();
    }

    @RequestMapping(value = "/{tournamentId}", method = RequestMethod.GET)
    public Tournament getTournament(@PathVariable(value = "tournamentId") Long tournamentId) {
        log.info("Get tournament id={}!", tournamentId);
        return tournamentService.findById(tournamentId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public boolean addTournament(@RequestBody Tournament name) {
        log.info("Add tournament name: {}", name.toString());
        return tournamentService.add(name);
    }
}
