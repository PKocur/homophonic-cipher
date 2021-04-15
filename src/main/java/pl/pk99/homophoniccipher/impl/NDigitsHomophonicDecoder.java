package pl.pk99.homophoniccipher.impl;

import pl.pk99.homophoniccipher.HomophonesArray;
import pl.pk99.homophoniccipher.HomophonicDecoder;

public class NDigitsHomophonicDecoder implements HomophonicDecoder {

    private final int FIRST_ALPHABET_LETTER_ASCII_POSITION;
    private final int NUMBER_OF_DIGITS;

    public NDigitsHomophonicDecoder(int firstAlphabetLetterAsciiPosition, int numberOfDigits) {
        FIRST_ALPHABET_LETTER_ASCII_POSITION = firstAlphabetLetterAsciiPosition;
        NUMBER_OF_DIGITS = numberOfDigits;
    }

    @Override
    public String decode(String encodedText, HomophonesArray homophonesArray) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < encodedText.length(); i += NUMBER_OF_DIGITS) {
            if (encodedText.charAt(i) == 32) {
                decryptedText.append(" ");
                i++;
            }
            int encodedChar = Integer.parseInt(encodedText.substring(i, i + NUMBER_OF_DIGITS));
            char decryptedChar = (char) (homophonesArray.getLetterByHomophone(encodedChar) + FIRST_ALPHABET_LETTER_ASCII_POSITION);
            decryptedText.append(decryptedChar);
        }
        return decryptedText.toString();
    }
}
