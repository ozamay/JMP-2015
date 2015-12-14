package com.epam.olukash.module3.singleton;

/**
 * @author oleksii.lukash
 */
public class SingletonInnerClass
{
    private SingletonInnerClass(){}

    private static class SingletonHolder
    {
        private static SingletonInnerClass singleton = new SingletonInnerClass();
    }

    public static SingletonInnerClass getInstance()
    {
        return SingletonHolder.singleton;
    }
}
