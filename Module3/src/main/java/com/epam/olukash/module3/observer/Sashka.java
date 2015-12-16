package com.epam.olukash.module3.observer;


/**
 * @author oleksii.lukash
 */
public class Sashka implements Observer
{
    private MessageBuilder messageBuilder;

    public Sashka()
    {
        this.messageBuilder = new MessageBuilder();
    }
    public void update(WordInfo wordInfo, TextInfo textInfo)
    {
        messageBuilder.appendOberver("Sashka");
        messageBuilder.appendTextInfo(wordInfo);
        messageBuilder.appendTextInfo(textInfo);
        messageBuilder.build();
        System.out.println(messageBuilder.build());
        messageBuilder.clear();
    }
}
