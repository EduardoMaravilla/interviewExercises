package org.eduardomaravill.roverRobot.solveProblem;

import jakarta.annotation.PostConstruct;
import org.eduardomaravill.roverRobot.models.Direction;
import org.eduardomaravill.roverRobot.models.Obstacle;
import org.eduardomaravill.roverRobot.models.Rover;
import org.eduardomaravill.roverRobot.services.IObstacleService;
import org.eduardomaravill.roverRobot.services.IRegisterService;
import org.eduardomaravill.roverRobot.services.IRoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MarsRover {

    private Character[][] grid;
    private Rover rover;
    private List<Obstacle> obstacleList;

    @Autowired
    private IObstacleService obstacleService;

    @Autowired
    private IRegisterService registerService;

    @Autowired
    private IRoverService roverService;

    public MarsRover() {
    }

    @PostConstruct
    public void init() {
        this.grid = new Character[8][18];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 18; j++) {
                this.grid[i][j] = '*';
            }
        }
        this.rover = roverService.getRover();
        this.obstacleList = obstacleService.getAllObstacles();
        for (Obstacle obstacle : obstacleList) {
            if (isValidCoordinate(obstacle.getY(), obstacle.getX())) {
                grid[obstacle.getY()][obstacle.getX()] = 'O';
            }
        }
        updateRoverPositionInGrid();
    }

    public String execute(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            switch (command.charAt(i)) {
                case 'M':
                    if (moveRover()) {
                        sb.append('M');
                    }
                    break;
                case 'L':
                    turnLeft();
                    sb.append('L');
                    break;
                case 'R':
                    turnRight();
                    sb.append('R');
                    break;
            }
        }
        return sb.toString();
    }

    public boolean isValidCoordinate(int row, int col) {
        return col >= 0 && col < 18 && row >= 0 && row < 8;
    }

    public boolean thereIsObstacle(int row, int col){
        for (Obstacle obstacle: obstacleList){
            if (obstacle.getX() == col && obstacle.getY() == row){
                return true;
            }
        }
        return false;
    }

    public boolean moveRover() {
        int col = rover.getX();
        int row = rover.getY();
        switch (rover.getDirection()) {
            case NORTH:
                row--;
                break;
            case SOUTH:
                row++;
                break;
            case EAST:
                col++;
                break;
            case WEST:
                col--;
                break;
        }
        if (isValidCoordinate(row, col) && !thereIsObstacle(row,col)) {
            grid[rover.getY()][rover.getX()] = '*'; // Clear old position
            rover.setX(col);
            rover.setY(row);
            updateRoverPositionInGrid();
            return true;
        }
        return false;
    }

    public void turnLeft() {
        switch (rover.getDirection()) {
            case NORTH:
                rover.setDirection(Direction.WEST);
                break;
            case SOUTH:
                rover.setDirection(Direction.EAST);
                break;
            case EAST:
                rover.setDirection(Direction.NORTH);
                break;
            case WEST:
                rover.setDirection(Direction.SOUTH);
                break;
        }
    }

    public void turnRight() {
        switch (rover.getDirection()) {
            case NORTH:
                rover.setDirection(Direction.EAST);
                break;
            case SOUTH:
                rover.setDirection(Direction.WEST);
                break;
            case EAST:
                rover.setDirection(Direction.SOUTH);
                break;
            case WEST:
                rover.setDirection(Direction.NORTH);
                break;
        }
    }

    private void updateRoverPositionInGrid() {
        if (isValidCoordinate(rover.getY(), rover.getX())) {
            grid[rover.getY()][rover.getX()] = 'R';
        }
    }

    /*public void printGrid() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 18; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------------");
    }*/

}
