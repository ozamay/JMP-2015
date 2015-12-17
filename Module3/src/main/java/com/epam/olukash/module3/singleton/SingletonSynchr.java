package com.epam.olukash.module3.singleton;

/**
 * @author oleksii.lukash
 */
public class SingletonSynchr
{
    private static volatile SingletonSynchr singleton;

    private SingletonSynchr(){}

    public static synchronized SingletonSynchr getInstance()
    {
        if (singleton == null)
        {
            singleton = new SingletonSynchr();
        }
        return singleton;
    }
}
