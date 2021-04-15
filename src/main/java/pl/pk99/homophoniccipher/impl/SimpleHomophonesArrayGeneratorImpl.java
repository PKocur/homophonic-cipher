package pl.pk99.homophoniccipher.impl;

import pl.pk99.homophoniccipher.HomophonesArray;
import pl.pk99.homophoniccipher.SimpleHomophonesArrayGenerator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SimpleHomophonesArrayGeneratorImpl implements SimpleHomophonesArrayGenerator {

    private final int NUMBER_OF_ALPHABET_LETTERS;
    private final int MAX_HOMOPHONE_VALUE;
    private final int MIN_HOMOPHONE_VALUE;

    public SimpleHomophonesArrayGeneratorImpl(int numberOfAlphabetLetters, int minHomophoneValue, int maxHomophoneValue) {
        NUMBER_OF_ALPHABET_LETTERS = numberOfAlphabetLetters;
        MAX_HOMOPHONE_VALUE = maxHomophoneValue;
        MIN_HOMOPHONE_VALUE = minHomophoneValue;
    }

    @Override
    public HomophonesArray generate(int numberOfHomophones) {
        HomophonesArray homophonesArray = new SimpleHomophonesArrayImpl(NUMBER_OF_ALPHABET_LETTERS, numberOfHomophones);
        Set<Integer> uniqueNumbers = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < homophonesArray.getNumberOfLetters(); i++) {
            for (int j = 0; j < homophonesArray.getNumberOfHomophones()[i]; j++) {
                homophonesArray.add(getRandomUniqueNumber(random, uniqueNumbers), i, j);
            }
        }
        return homophonesArray;
    }

    private int getRandomUniqueNumber(Random random, Set<Integer> uniqueNumbers) {
        int randomUniqueNumber = random.nextInt((MAX_HOMOPHONE_VALUE + 1) - MIN_HOMOPHONE_VALUE) + MIN_HOMOPHONE_VALUE;
        if (!uniqueNumbers.add(randomUniqueNumber)) {
            return getRandomUniqueNumber(random, uniqueNumbers);
        }
        return randomUniqueNumber;
    }
}
