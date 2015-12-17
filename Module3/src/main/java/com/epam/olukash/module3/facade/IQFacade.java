package com.epam.olukash.module3.facade;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

/**
 * @author oleksii.lukash
 */
public class IQFacade
{
    public void defineSmarter(Person person, Person secondPerson)
    {
        List<String> persons;
        if(person.getIq() > secondPerson.getIq())
        {
            persons = Arrays.asList(person.getName() + " is smarter");
        }
        else if (person.getIq() < secondPerson.getIq())
        {
            persons = Arrays.asList(secondPerson.getName() + " is smarter");
        } else {
            persons = Arrays.asList("You are identical");
        }
        writeToFile(persons);
    }

    public void moveIQ(Person from, Person to, int amountIQ)
    {
        from.setIq(from.getIq() - amountIQ);
        to.setIq(to.getIq() + amountIQ);

        List<String> persons = Arrays.asList(amountIQ + " iq was moved from " + from.getName() + " to " + to.getName(), from.toString(), to.toString());
        writeToFile(persons);
    }

    public void incrementOrReduceIQ(Person person, int amountIQ)
    {
        person.setIq(person.getIq() + amountIQ);
        List<String> persons = Arrays.asList("Iq was changed on " + amountIQ, person.toString());
        writeToFile(persons);
    }

    private void writeToFile(List<String> personList)
    {
        try {
            Path file = Paths.get("src/main/resources/persons.txt");
            Files.write(file, personList, StandardOpenOption.APPEND);
        }catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }
}
