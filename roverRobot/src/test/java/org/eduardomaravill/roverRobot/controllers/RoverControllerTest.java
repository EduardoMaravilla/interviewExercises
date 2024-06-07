package org.eduardomaravill.roverRobot.controllers;

import org.eduardomaravill.roverRobot.dto.CommandDto;
import org.eduardomaravill.roverRobot.solveProblem.MarsRover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
class RoverControllerTest {

    @InjectMocks
    private RoverController controller;

    @Mock
    private MarsRover marsRover;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void callServiceWhenReceiveACommand() {
        // Arrange
        CommandDto commandDto = new CommandDto();
        commandDto.setCommands("L");

        when(marsRover.execute(anyString())).thenReturn("processedCommand");

        // Act
        ResponseEntity<CommandDto> responseEntity = controller.getCommands(commandDto);
        ResponseEntity<CommandDto> responseEntity1 = controller.getCommands(commandDto);
        ResponseEntity<CommandDto> responseEntity2 = controller.getCommands(commandDto);


        // Assert
        verify(marsRover, times(3)).execute(anyString());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("processedCommand", Objects.requireNonNull(responseEntity.getBody()).getCommands());
    }

}