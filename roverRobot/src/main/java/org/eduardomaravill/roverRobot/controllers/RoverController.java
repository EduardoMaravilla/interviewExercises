package org.eduardomaravill.roverRobot.controllers;

import jakarta.validation.Valid;
import org.eduardomaravill.roverRobot.dto.CommandDto;
import org.eduardomaravill.roverRobot.dto.RobertDto;
import org.eduardomaravill.roverRobot.models.Direction;
import org.eduardomaravill.roverRobot.models.Rover;
import org.eduardomaravill.roverRobot.services.IRoverService;
import org.eduardomaravill.roverRobot.solveProblem.MarsRover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Validated
public class RoverController {

    @Autowired
    private MarsRover marsRover;

    @Autowired
    private IRoverService roverService;

    @GetMapping("/rover")
    public ResponseEntity<RobertDto> getRover(){
        Rover rover = roverService.getRover();
        RobertDto robertDto = null;
        if (rover == null){
            robertDto = new RobertDto(0, 0, Direction.EAST);
            ResponseEntity<Void> re = create(robertDto);
            return new ResponseEntity<>(robertDto, re.getStatusCode());
        }else {
            robertDto = new RobertDto(rover.getX(), rover.getY(), rover.getDirection());
            return new ResponseEntity<>(robertDto, HttpStatus.OK);
        }
    }

    @PostMapping("/rover")
    public ResponseEntity<Void> create(@Valid @RequestBody RobertDto robot){
        roverService.deleteAll();
        Rover rover = new Rover();
        rover.setX(robot.getX());
        rover.setY(robot.getY());
        rover.setDirection(robot.getDirection());
        roverService.registerRover(rover);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/rover/commands")
    public ResponseEntity<CommandDto> getCommands(@RequestBody CommandDto commandsDto){
         CommandDto newCommandsDto = new CommandDto();
         newCommandsDto.setCommands(marsRover.execute(commandsDto.getCommands()));
         return new ResponseEntity<>(newCommandsDto, HttpStatus.OK);
    }

    @PutMapping("/rover")
    public ResponseEntity<Void> updateRover(@RequestBody RobertDto robertDto){
        Rover rover = roverService.getRover();
        rover.setX(robertDto.getX());
        rover.setY(robertDto.getY());
        rover.setDirection(robertDto.getDirection());
        roverService.updateRover(rover.getId(), rover);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
