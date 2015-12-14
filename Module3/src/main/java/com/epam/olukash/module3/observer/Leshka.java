package com.epam.olukash.module3.observer;

/**
 * @author oleksii.lukash
 */
public class Leshka implements Observer
{
    private MessageBuilder messageBuilder;

    public Leshka()
    {
        this.messageBuilder = new MessageBuilder("Leshka");
    }

    public void update(WordInfo wordInfo, TextInfo textInfo)
    {
        messageBuilder.appendTextInfo(wordInfo);
        messageBuilder.appendTextInfo(textInfo);
        System.out.println(messageBuilder.build());
        messageBuilder.clear();
    }
}
