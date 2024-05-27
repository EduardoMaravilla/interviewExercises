package org.eduardomaravill.roverRobot.services;

import org.eduardomaravill.roverRobot.models.RegisterMoveRover;

import java.util.List;

public interface IRegisterService {
    RegisterMoveRover getRegisterMoveRover(Long id);
    void createRegisterMoveRover(RegisterMoveRover registerMoveRover);
    void updateRegisterMoveRover(Long id, RegisterMoveRover registerMoveRover);
    void deleteRegisterMoveRover(Long id);
    List<RegisterMoveRover> getAllRegisterMoveRover();
}
