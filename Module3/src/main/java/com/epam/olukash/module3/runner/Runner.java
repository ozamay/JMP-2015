package com.epam.olukash.module3.runner;

import com.epam.olukash.module3.facade.IQFacade;
import com.epam.olukash.module3.facade.Person;
import com.epam.olukash.module3.observer.Leshka;
import com.epam.olukash.module3.observer.Sashka;
import com.epam.olukash.module3.observer.TextReader;
import com.epam.olukash.module3.observer.WordInfo;
import com.epam.olukash.module3.observer.WordListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author oleksii.lukash
 */
public class Runner
{
    public static void main(String args[])
    {
        //////////////////////////////////////////
        //Observer pattern
        processObserver();

        //////////////////////////////////////////
        //Facade pattern
        processFacade();
    }

    private static void processObserver()
    {
        Leshka leshka = new Leshka();
        Sashka sashka = new Sashka();

        WordListener wordListener = new WordListener();
        wordListener.registerObserver(leshka);
        wordListener.registerObserver(sashka);

        TextReader reader = null;
        try
        {
            reader = new TextReader(new File("Module3/src/main/resources/test"));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        List<String> words = reader.read();

        for (String processWord : words)
        {
            WordInfo wordInfo = new WordInfo(processWord);
            wordListener.processWord(wordInfo);
        }
    }

    private static void processFacade()
    {
        Person lehan = new Person("leha", 27, 100);
        Person sasha = new Person("sasha", 31, 101);
        IQFacade iqFacade = new IQFacade();
        iqFacade.defineSmarter(lehan, sasha);
        iqFacade.moveIQ(lehan, sasha, 10);
        iqFacade.incrementOrReduceIQ(lehan, 15);
    }

}
