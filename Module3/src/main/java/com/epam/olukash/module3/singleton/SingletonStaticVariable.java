package com.epam.olukash.module3.singleton;

/**
 * @author oleksii.lukash
 */
public class SingletonStaticVariable
{
    private static SingletonStaticVariable singleton;

    private SingletonStaticVariable(){}

    public static SingletonStaticVariable getInstance()
    {
        if(singleton == null)
        {
            singleton = new SingletonStaticVariable();
        }
        return singleton;
    }
}
