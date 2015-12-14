package com.epam.olukash.module3.runner;

import com.epam.olukash.module3.facade.IQFacade;
import com.epam.olukash.module3.facade.Person;
import com.epam.olukash.module3.observer.Leshka;
import com.epam.olukash.module3.observer.Sashka;
import com.epam.olukash.module3.observer.TextReader;
import com.epam.olukash.module3.observer.WordListener;

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

        Leshka leshka = new Leshka();
        Sashka sashka = new Sashka();

        WordListener wordListener = new WordListener();
        wordListener.registerObserver(leshka);
        wordListener.registerObserver(sashka);

        List<String> words = TextReader.formatText("Module3/src/main/resources/test");

        for (String word : words)
        {
            wordListener.setCurrentWord(word);
        }

        //////////////////////////////////////////
        //Facade pattern

        Person lehan = new Person("leha", 27, 100);
        Person sasha = new Person("sasha", 31, 101);
        IQFacade iqFacade = new IQFacade();
        iqFacade.defineSmarter(lehan, sasha);
        iqFacade.moveIQ(lehan, sasha, 10);
        iqFacade.incrementOrReduceIQ(lehan, 15);
    }
}
