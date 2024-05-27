package org.eduardomaravill.roverRobot.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "rover_robot")
public class Rover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Max(18)
    @Min(0)
    @Column(name = "posX")
    private Integer x;

    @Max(8)
    @Min(0)
    @Column(name = "posY")
    private Integer y;

    @Column(name = "position")
    @Enumerated(EnumType.STRING)
    private Direction direction;

    @OneToMany(mappedBy = "robot")
    private List<RegisterMoveRover> registerMoveRovers;

    public Rover() {
        registerMoveRovers = new ArrayList<>();
    }
}
