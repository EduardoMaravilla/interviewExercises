package org.eduardomaravill.roverRobot.repository;

import org.eduardomaravill.roverRobot.models.Obstacle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IObstacleRepository extends JpaRepository<Obstacle,Long> {
}
