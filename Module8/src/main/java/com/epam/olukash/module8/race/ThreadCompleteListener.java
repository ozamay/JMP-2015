package com.epam.olukash.module8.race;

import com.epam.olukash.module8.car.NotifyingThread;

/**
 * @author Oleksii_Lukash
 * @date 1/30/2016
 */
public interface ThreadCompleteListener
{
	void notifyOfThreadComplete(NotifyingThread car);
}
