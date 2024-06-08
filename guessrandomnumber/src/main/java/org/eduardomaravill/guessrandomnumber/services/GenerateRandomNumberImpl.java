package org.eduardomaravill.guessrandomnumber.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GenerateRandomNumberImpl implements IGenerateRandomNumber{
    @Override
    public Integer getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10)+1;
    }
}
