package com.epam.olukash.module3.observer;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author oleksii.lukash
 */
public class TextReader
{
    private final InputStream inputStream;

    public TextReader(InputStream inputStream)
    {
        this.inputStream = inputStream;
    }

    public TextReader(File file) throws FileNotFoundException
    {
        this(new FileInputStream(file));
    }

    public List<String> read()
    {
        String everything = null;
        try
        {
            everything = IOUtils.toString(inputStream);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            IOUtils.closeQuietly(inputStream);
        }
        return getWords(everything);
    }

    private List<String> getWords(String text)
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
