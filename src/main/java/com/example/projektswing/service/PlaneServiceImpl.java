package com.example.projektswing.service;

import com.example.projektswing.model.Plane;
import com.example.projektswing.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneServiceImpl implements PlaneService {

    private PlaneRepository planeRepository;

    @Autowired
    public PlaneServiceImpl(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    @Override
    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }

    @Override
    public Plane getPlaneById(long id) {
        Optional<Plane> plane = planeRepository.findById(id);
        return plane.orElse(null);
    }

    @Override
    public void deletePlaneById(long id) {
        planeRepository.deleteById(id);
    }

    @Override
    public void savePlane(Plane plane) {
        planeRepository.save(plane);
    }
}
