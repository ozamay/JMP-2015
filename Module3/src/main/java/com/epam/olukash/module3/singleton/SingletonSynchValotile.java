package com.epam.olukash.module3.singleton;

/**
 * @author oleksii.lukash
 */
public class SingletonSynchValotile
{
    private static volatile SingletonSynchValotile singleton;

    private SingletonSynchValotile(){}

    public static SingletonSynchValotile getInstance()
    {
        if(singleton == null)
        {
            synchronized (SingletonSynchValotile.class)
            {
                if (singleton == null)
                {
                    singleton = new SingletonSynchValotile();
                }
            }
        }
        return singleton;
    }
}
