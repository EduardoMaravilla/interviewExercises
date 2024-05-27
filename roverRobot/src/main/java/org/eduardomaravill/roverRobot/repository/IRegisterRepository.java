package org.eduardomaravill.roverRobot.repository;

import org.eduardomaravill.roverRobot.models.RegisterMoveRover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegisterRepository extends JpaRepository<RegisterMoveRover,Long> {
}
