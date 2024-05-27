package org.eduardomaravill.roverRobot.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name ="register_move_rover")
public class RegisterMoveRover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rover_id", nullable = false)
    private Rover robot;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "register_move_rover_id")
    private List<Obstacle> obstacleList;

    private String commandsInitial;
    private String commandsFinal;

    public RegisterMoveRover() {
        obstacleList = new ArrayList<>();
    }
}
