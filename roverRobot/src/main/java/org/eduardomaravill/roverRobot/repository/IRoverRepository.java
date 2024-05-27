package org.eduardomaravill.roverRobot.repository;

import org.eduardomaravill.roverRobot.models.Rover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoverRepository extends JpaRepository<Rover,Long> {
}
