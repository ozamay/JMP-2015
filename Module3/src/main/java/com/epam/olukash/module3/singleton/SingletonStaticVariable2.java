package com.epam.olukash.module3.singleton;

/**
 * @author oleksii.lukash
 */
public class SingletonStaticVariable2
{
    private static SingletonStaticVariable2 singleton = new SingletonStaticVariable2();

    private SingletonStaticVariable2(){}

    public static SingletonStaticVariable2 getInstance()
    {
        return singleton;
    }
}
