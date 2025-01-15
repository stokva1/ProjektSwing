package com.example.projektswing.repository;

import com.example.projektswing.model.Driver;
import com.example.projektswing.model.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotRepository extends JpaRepository<Pilot, Long> {
}
