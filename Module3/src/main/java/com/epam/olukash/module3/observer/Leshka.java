package com.epam.olukash.module3.observer;

/**
 * @author oleksii.lukash
 */
public class Leshka implements Observer
{
    public void update(String currentWord, int wordCounter, int numberCounter, String longestWord, String reverseWord)
    {
        System.out.println("Leshka confirm: current word - " + currentWord + ", wordCounter - " + wordCounter +
                            ", numberCounter - " + numberCounter + ", longestWord - " + longestWord +
                            ", reverseWord - " + reverseWord + ".");
    }
}
