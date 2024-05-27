package org.eduardomaravill.roverRobot.services;

import org.eduardomaravill.roverRobot.models.Rover;

public interface IRoverService {
    Rover getRover();

    void registerRover(Rover rover);

    void deleteRover(Long id);

    void updateRover(Long id, Rover rover);

    void deleteAll();
}