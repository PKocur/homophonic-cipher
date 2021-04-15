package pl.pk99.homophoniccipher;

public interface HomophonesArray {

    /**
     * Returns a homophone by the letter and homophone indexes.
     *
     * @param letterIndex    index of the letter
     * @param homophoneIndex index of the homophone
     * @return homophone from the provided indexes
     */
    int get(int letterIndex, int homophoneIndex);

    /**
     * Adds a homophone to the array at the provided indexes.
     *
     * @param homophone      new homophone to add
     * @param letterIndex    index of the letter
     * @param homophoneIndex index of the homophone
     */
    void add(int homophone, int letterIndex, int homophoneIndex);

    /**
     * Returns a letter with the provided homophone.
     *
     * @param homophone homophone of the letter
     * @return index of the letter with the homophone
     */
    int getLetterByHomophone(int homophone);

    /**
     * Returns a number of letters in array
     *
     * @return number of letters in array
     */
    int getNumberOfLetters();

    /**
     * Returns a number of homophones in array.
     *
     * @return number of homophones in array
     */
    int[] getNumberOfHomophones();

}
