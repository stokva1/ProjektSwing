package com.example.projektswing.repository;

import com.example.projektswing.model.Car;
import com.example.projektswing.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {

}
