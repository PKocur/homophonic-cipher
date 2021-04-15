package pl.pk99.homophoniccipher.impl;

import pl.pk99.homophoniccipher.HomophonesArray;

import java.util.Arrays;

public class SimpleHomophonesArray implements HomophonesArray {

    private final int[][] homophones;

    private final int numberOfLetters;
    private final int numberOfHomophones;

    public SimpleHomophonesArray(int numberOfLetters, int numberOfHomophones) {
        this.numberOfLetters = numberOfLetters;
        this.numberOfHomophones = numberOfHomophones;
        this.homophones = new int[numberOfLetters][numberOfHomophones];
    }

    public int get(int letterIndex, int homophoneIndex) {
        return homophones[letterIndex][homophoneIndex];
    }

    public void add(int homophone, int letterIndex, int homophoneIndex) {
        homophones[letterIndex][homophoneIndex] = homophone;
    }

    public int getLetterByHomophone(int homophone) {
        for (int i = 0; i < homophones.length; i++) {
            for (int j = 0; j < homophones[i].length; j++) {
                if(homophones[i][j] == homophone) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public int[] getNumberOfHomophones() {
        int[] numberOfHomophones = new int[numberOfLetters];
        Arrays.fill(numberOfHomophones, this.numberOfHomophones);
        return numberOfHomophones;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(homophones);
    }
}
