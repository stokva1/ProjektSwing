package com.example.projektswing.service;

import com.example.projektswing.model.Pilot;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PilotService {

     List<Pilot> getAllPilots();
     Pilot getPilotById(long id);
     void deletePilotById(long id);
     void savePilot(Pilot pilot);
}
