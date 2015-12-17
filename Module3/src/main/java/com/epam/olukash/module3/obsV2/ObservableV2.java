package com.epam.olukash.module3.obsV2;

/**
 * @author Oleksii_Lukash
 * @date 12/16/2015
 */
public interface ObservableV2
{
	void registerObserver(ObserverV2 observer);

	void removeObserver(ObserverV2 observer);

	void notifyObservers();
}
