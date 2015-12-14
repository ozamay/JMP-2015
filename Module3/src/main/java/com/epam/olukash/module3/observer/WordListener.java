package com.epam.olukash.module3.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author oleksii.lukash
 */
public class WordListener implements Observable {
    private List<Observer> observers;
    private int wordCounter;
    private int numberCounter;
    private String currentWord;
    private String longestWord;
    private String reverseWord;

    public WordListener()
    {
        this.observers = new ArrayList<>();
    }

    public void registerObserver(Observer observer)
    {
        observers.add(observer);
    }

    public void removeObserver(Observer observer)
    {
        observers.remove(observer);
    }

    public void notifyObservers()
    {
        for(Observer observer : observers)
        {
            observer.update(currentWord, wordCounter, numberCounter, longestWord, reverseWord);
        }
    }

    public void setCurrentWord(String currentWord)
    {
        this.currentWord = currentWord;
        updateWordCounter();
        updateNumberCounter(currentWord);
        updateLongestWord(currentWord);
        updateReverseWord(currentWord);
        notifyObservers();
    }

    public void updateWordCounter()
    {
        this.wordCounter++;
    }

    public void updateNumberCounter(String currentWord)
    {
        try
        {
            Integer.parseInt(currentWord);
        } catch (Exception e)
        {
            //smth to do
            return;
        }
        this.numberCounter++;
    }

    public void updateLongestWord(String currentWord)
    {
        if(longestWord == null)
        {
            this.longestWord = currentWord;
        }

        if(currentWord.length() >= longestWord.length())
        {
            this.longestWord = currentWord;
        }
    }

    public void updateReverseWord(String currentWord) {
        this.reverseWord = new StringBuilder(currentWord).reverse().toString();
    }

}
