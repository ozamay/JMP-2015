package com.epam.olukash.module3.observer;

/**
 * @author oleksii.lukash
 */
public interface Observer {
    void update(String currentWord, int wordCounter, int numberCounter, String longestWord, String reverseWord);
}
