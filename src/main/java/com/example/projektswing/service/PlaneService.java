package com.example.projektswing.service;

import com.example.projektswing.model.Plane;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlaneService {
     List<Plane> getAllPlanes();

     Plane getPlaneById(long id);

     void deletePlaneById(long id);

     void savePlane(Plane plane);
}
