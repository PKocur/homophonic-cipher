package pl.pk99.homophoniccipher;

public interface HomophonicEncoder {

    /**
     * Encodes plain text.
     *
     * @param text            text to encode
     * @param homophonesArray homophones to encode by
     * @return encoded text
     */
    String encode(String text, HomophonesArray homophonesArray);
}
