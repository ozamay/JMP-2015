package com.epam.olukash.module3.observer;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

/**
 * @author oleksii.lukash
 */
public class TextReader
{
    public static List<String> formatText(String pathToFile)
    {
        String everything = null;
        try(FileInputStream inputStream = new FileInputStream(pathToFile))
        {
            everything = IOUtils.toString(inputStream);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return getWords(everything);
    }

    private static List<String> getWords(String text)
    {
        List<String> words = new ArrayList<>();
        BreakIterator breakIterator = BreakIterator.getWordInstance();
        breakIterator.setText(text);
        int lastIndex = breakIterator.first();
        while (BreakIterator.DONE != lastIndex)
        {
            int firstIndex = lastIndex;
            lastIndex = breakIterator.next();
            if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(text.charAt(firstIndex)))
            {
                words.add(text.substring(firstIndex, lastIndex));
            }
        }

        return words;
    }
}
