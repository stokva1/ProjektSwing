package com.example.projektswing.service;

import com.example.projektswing.model.Pilot;
import com.example.projektswing.repository.PilotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PilotServiceImpl implements PilotService {

    private PilotRepository pilotRepository;

    @Autowired
    public PilotServiceImpl(PilotRepository pilotRepository) {
        this.pilotRepository = pilotRepository;
    }

    @Override
    public List<Pilot> getAllPilots() {
        return pilotRepository.findAll();
    }

    @Override
    public Pilot getPilotById(long id) {
        Optional<Pilot> pilot = pilotRepository.findById(id);
        return pilot.orElse(null);
    }

    @Override
    public void deletePilotById(long id) {
        pilotRepository.deleteById(id);
    }

    @Override
    public void savePilot(Pilot pilot) {
        pilotRepository.save(pilot);
    }
}
