package com.example.pokta.service;

import com.example.pokta.model.Tournament;
import com.example.pokta.model.TournamentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Slf4j
@Component
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public Collection<Tournament> findAll() {
        return tournamentRepository.findAll();
    }

    public boolean add(Tournament entity) {
        try {
            tournamentRepository.save(entity);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    public Tournament findById(Long id) {
        return tournamentRepository.findOne(id);
    }
}
