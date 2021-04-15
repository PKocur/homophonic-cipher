package pl.pk99.homophoniccipher;

import pl.pk99.homophoniccipher.impl.NDigitsHomophonicDecoder;
import pl.pk99.homophoniccipher.impl.SimpleHomophonesArrayGeneratorImpl;
import pl.pk99.homophoniccipher.impl.SimpleHomophonicEncoder;

/**
 * Sample class showing sample library usage
 */
public class Main {
    private static final int HOMOPHONES_NUMBER = 3;
    private static final int NUMBER_OF_ALPHABET_LETTERS = 26;
    private static final int FIRST_ALPHABET_LETTER_ASCII_POSITION = 97;
    private static final int NUMBER_OF_DIGITS_TO_ENCODE_LETTER = 2;
    private static final int MIN_HOMOPHONE_VALUE = 10;
    private static final int MAX_HOMOPHONE_VALUE = 99;

    public static void main(String[] args) {
        // Plain text to encode
        String text = "sample text";

        // Generate a random array of homophones for 26 letters (with 3 homophones each with values from 10 to 99), to encode the text
        SimpleHomophonesArrayGenerator simpleHomophonesArrayGenerator = new SimpleHomophonesArrayGeneratorImpl(
                NUMBER_OF_ALPHABET_LETTERS, MIN_HOMOPHONE_VALUE, MAX_HOMOPHONE_VALUE);
        HomophonesArray homophonesArray = simpleHomophonesArrayGenerator.generate(HOMOPHONES_NUMBER);

        // Prepare simple encoder (which operates on ascii alphabet)
        HomophonicEncoder homophonicEncoder = new SimpleHomophonicEncoder(FIRST_ALPHABET_LETTER_ASCII_POSITION);

        // Prepare 2 digits cipher decoder (digits number depends on the MIN and MAX homophone values)
        HomophonicDecoder homophonicDecoder = new NDigitsHomophonicDecoder(FIRST_ALPHABET_LETTER_ASCII_POSITION, NUMBER_OF_DIGITS_TO_ENCODE_LETTER);

        String encodedText = homophonicEncoder.encode(text, homophonesArray);
        System.out.println("Homophones array:" + homophonesArray.toString());
        System.out.println("Encoded text: " + encodedText);
        System.out.println("Decoded text: " + homophonicDecoder.decode(encodedText, homophonesArray));
    }
}
