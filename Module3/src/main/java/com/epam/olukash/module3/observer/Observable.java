package com.epam.olukash.module3.observer;

/**
 * @author oleksii.lukash
 */
public interface Observable {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
