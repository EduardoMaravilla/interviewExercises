package org.eduardomaravill.guessrandomnumber;

import org.eduardomaravill.guessrandomnumber.controllers.RandomNumberController;
import org.eduardomaravill.guessrandomnumber.dto.RandomNumberDto;
import org.eduardomaravill.guessrandomnumber.services.IGenerateRandomNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class GuessrandomnumberApplicationTests {

	@InjectMocks
	private RandomNumberController randomNumberController;

    @Mock
	private IGenerateRandomNumber generateRandomNumber;

    @BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("Random number")
	void contextLoads() {
		when(generateRandomNumber.getRandomNumber()).thenReturn(8);
		ResponseEntity<RandomNumberDto> response = randomNumberController.randomNumber();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(8, Objects.requireNonNull(response.getBody()).getRandomNumber());
	}

}
