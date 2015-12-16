package com.epam.olukash.module3.obsV2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleksii_Lukash
 * @date 12/16/2015
 */
public class WordListenerV2 implements ObservableV2
{
	private List<ObserverV2> observers;
	private String currentWord;

	public WordListenerV2()
	{
		this.observers = new ArrayList<>();
	}

	public void processWord(String word)
	{
		this.currentWord = word;
		notifyObservers();
	}

	@Override
	public void registerObserver(ObserverV2 observer)
	{
		observers.add(observer);
	}

	@Override
	public void removeObserver(ObserverV2 observer)
	{
		observers.remove(observer);
	}

	@Override
	public void notifyObservers()
	{
		for(ObserverV2 observer : observers)
		{
			observer.update(currentWord);
		}
	}








}
