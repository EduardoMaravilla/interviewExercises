package org.eduardomaravill.roverRobot.services;

import org.eduardomaravill.roverRobot.models.Obstacle;

import java.util.List;

public interface IObstacleService {
    Obstacle getObstacle(Long id);
    void createObstacle(Obstacle obstacle);
    void updateObstacle(Long id, Obstacle obstacle);
    void deleteObstacle(Long id);
    List<Obstacle> getAllObstacles();
}
