package pl.pk99.homophoniccipher.impl;

import pl.pk99.homophoniccipher.HomophonesArray;
import pl.pk99.homophoniccipher.HomophonicEncoder;

import java.util.Random;

public class SimpleHomophonicEncoder implements HomophonicEncoder {

    private final int FIRST_ALPHABET_LETTER_ASCII_POSITION;

    public SimpleHomophonicEncoder(int firstAlphabetLetterAsciiPosition) {
        FIRST_ALPHABET_LETTER_ASCII_POSITION = firstAlphabetLetterAsciiPosition;
    }

    @Override
    public String encode(String text, HomophonesArray homophonesArray) {
        StringBuilder encryptedText = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 32) {
                encryptedText.append(" ");
                continue;
            }
            encryptedText.append(
                    homophonesArray.get(text.charAt(i) - FIRST_ALPHABET_LETTER_ASCII_POSITION, random.nextInt(3)));
        }
        return encryptedText.toString();
    }
}
