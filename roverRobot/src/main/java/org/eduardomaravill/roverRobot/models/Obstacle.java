package org.eduardomaravill.roverRobot.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "obstacles")
public class Obstacle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "posX")
    private int x;
    @Column(name = "posY")
    private int y;
    @ManyToOne
    @JoinColumn(name = "register_move_rover_id")
    private RegisterMoveRover registerMoveRover;

}
