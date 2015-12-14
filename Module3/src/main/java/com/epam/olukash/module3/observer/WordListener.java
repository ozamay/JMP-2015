package com.epam.olukash.module3.observer;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;

/**
 * @author oleksii.lukash
 */
public class WordListener implements Observable {
    private List<Observer> observers;
    private String currentWord;
    private String reverseWord;
    private TextInfo textInfo;
    private WordInfo wordInfo;

    public WordListener()
    {
        this.observers = new ArrayList<>();
        this.textInfo = new TextInfo();
    }

    public void processWord(WordInfo wordInfo)
    {
        this.currentWord = wordInfo.getCurrentWord();
        this.wordInfo = wordInfo;
        updateWordCounter();
        updateNumberCounter();
        updateLongestWord();
        notifyObservers();
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
            observer.update(wordInfo, textInfo);
        }
    }

    private void updateWordCounter()
    {
        int wordCounter = textInfo.getWordCounter();
        wordCounter++;
        textInfo.setWordCounter(wordCounter);
    }

    private void updateNumberCounter()
    {
        if(NumberUtils.isNumber(currentWord))
        {
            int numberCounter = textInfo.getNumberCounter();
            numberCounter++;
            textInfo.setNumberCounter(numberCounter);
        }
    }

    private void updateLongestWord()
    {
        String longestWord = textInfo.getLongestWord();
        if(longestWord == null || currentWord.length() >= longestWord.length())
        {
            textInfo.setLongestWord(currentWord);
        }
    }

}
