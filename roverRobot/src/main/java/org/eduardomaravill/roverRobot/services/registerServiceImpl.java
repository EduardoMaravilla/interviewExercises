package org.eduardomaravill.roverRobot.services;

import org.eduardomaravill.roverRobot.models.RegisterMoveRover;
import org.eduardomaravill.roverRobot.repository.IRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class registerServiceImpl implements IRegisterService{

    @Autowired
    private IRegisterRepository registerRepository;

    @Override
    public RegisterMoveRover getRegisterMoveRover(Long id) {
        return registerRepository.findById(id).orElse(null);
    }

    @Override
    public void createRegisterMoveRover(RegisterMoveRover registerMoveRover) {
         registerRepository.save(registerMoveRover);
    }

    @Override
    public void updateRegisterMoveRover(Long id, RegisterMoveRover registerMoveRover) {
        registerMoveRover.setId(id);
        registerRepository.save(registerMoveRover);
    }

    @Override
    public void deleteRegisterMoveRover(Long id) {
         registerRepository.deleteById(id);
    }

    @Override
    public List<RegisterMoveRover> getAllRegisterMoveRover() {
        return new ArrayList<>(registerRepository.findAll());
    }
}
