package org.eduardomaravill.roverRobot.services;

import jakarta.transaction.Transactional;
import org.eduardomaravill.roverRobot.models.Rover;
import org.eduardomaravill.roverRobot.repository.IRoverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoverServiceImpl implements IRoverService{

    @Autowired
    private IRoverRepository roverRepository;

    @Override
    public Rover getRover() {
        List<Rover> roverList = new ArrayList<>(roverRepository.findAll());
        try{
            return roverList.getFirst();
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public void registerRover(Rover rover) {
       roverRepository.save(rover);
    }

    @Override
    public void deleteRover(Long id) {
       roverRepository.deleteById(id);
    }

    @Override
    public void updateRover(Long id,Rover rover) {
        rover.setId(id);
        roverRepository.save(rover);
    }

    @Override
    public void deleteAll() {
        roverRepository.deleteAll();
    }
}
