package org.eduardomaravill.guessrandomnumber.controllers;

import org.eduardomaravill.guessrandomnumber.dto.RandomNumberDto;
import org.eduardomaravill.guessrandomnumber.services.IGenerateRandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RandomNumberController {

    @Autowired
    private IGenerateRandomNumber generateRandomNumber;

    @RequestMapping("/randomNumber")
    public ResponseEntity<RandomNumberDto> randomNumber() {
        RandomNumberDto rnDto = new RandomNumberDto(generateRandomNumber.getRandomNumber());
        return  new ResponseEntity<>(rnDto, HttpStatus.OK);
    }
}
