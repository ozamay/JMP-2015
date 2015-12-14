package com.epam.olukash.module3.observer;


/**
 * @author oleksii.lukash
 */
public class Sashka implements Observer
{
    private MessageBuilder messageBuilder;

    public Sashka()
    {
        this.messageBuilder = new MessageBuilder("Leshka");
    }
    public void update(WordInfo wordInfo, TextInfo textInfo)
    {
        messageBuilder.appendTextInfo(wordInfo);
        messageBuilder.appendTextInfo(textInfo);
        messageBuilder.build();
        messageBuilder.clear();
    }
}
