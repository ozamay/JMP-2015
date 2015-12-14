package com.epam.olukash.module3.observer;

/**
 * @author oleksii.lukash
 */
public interface Observable {
    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();
}
