package pl.pk99.homophoniccipher;

public interface HomophonicDecoder {

    /**
     * Decodes encoded text.
     *
     * @param encodedText     text encoded by homophonic cipher
     * @param homophonesArray homophones used to encode the text
     * @return decoded text
     */
    String decode(String encodedText, HomophonesArray homophonesArray);
}
