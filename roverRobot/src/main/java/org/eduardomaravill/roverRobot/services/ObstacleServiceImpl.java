package org.eduardomaravill.roverRobot.services;

import jakarta.transaction.Transactional;
import org.eduardomaravill.roverRobot.models.Obstacle;
import org.eduardomaravill.roverRobot.repository.IObstacleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ObstacleServiceImpl implements IObstacleService{

    @Autowired
    private IObstacleRepository obstacleRepository;

    @Override
    public Obstacle getObstacle(Long id) {
        return obstacleRepository.findById(id).orElse(null);
    }

    @Override
    public void createObstacle(Obstacle obstacle) {
        obstacleRepository.save(obstacle);
    }

    @Override
    public void updateObstacle(Long id, Obstacle obstacle) {
        obstacle.setId(id);
        obstacleRepository.save(obstacle);
    }

    @Override
    public void deleteObstacle(Long id) {
        obstacleRepository.deleteById(id);
    }

    @Override
    public List<Obstacle> getAllObstacles() {
        return new ArrayList<>(obstacleRepository.findAll());
    }
}
