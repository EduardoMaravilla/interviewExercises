package org.eduardomaravill.roverRobot.controllers;

import org.eduardomaravill.roverRobot.dto.ObstacleDto;
import org.eduardomaravill.roverRobot.models.Obstacle;
import org.eduardomaravill.roverRobot.services.IObstacleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ObstacleController {

    @Autowired
    private IObstacleService obstacleService;

    @GetMapping("/obstacle/{id}")
    public ObstacleDto getObstacle(@PathVariable Long id){
        Obstacle obstacle =  obstacleService.getObstacle(id);
        return new ObstacleDto(obstacle.getX(),obstacle.getY());
    }

    @PostMapping("/obstacle")
    public void createObstacle(@RequestBody ObstacleDto obstacleDto){
        Obstacle obstacle = new Obstacle();
        obstacle.setX(obstacleDto.getX());
        obstacle.setY(obstacleDto.getY());
        obstacleService.createObstacle(obstacle);
    }

    @GetMapping("/obstacles")
    public List<ObstacleDto> getObstacles(){
        return obstacleService.getAllObstacles().stream().map(o-> new ObstacleDto(o.getX(),o.getY())).toList();
    }

    @DeleteMapping("/obstacle/{id}")
    public void deleteObstacle(@PathVariable Long id){
        obstacleService.deleteObstacle(id);
    }

    @PutMapping("/obstacle/{id}")
    public void updateObstacle(@RequestBody Obstacle obstacle,@PathVariable Long id){
        obstacleService.updateObstacle(id,obstacle);
    }

}
