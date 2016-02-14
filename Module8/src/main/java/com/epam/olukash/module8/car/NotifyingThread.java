package com.epam.olukash.module8.car;

import java.util.HashSet;
import java.util.Set;

import com.epam.olukash.module8.race.ThreadCompleteListener;

/**
 * @author Oleksii_Lukash
 * @date 1/30/2016
 */
public abstract class NotifyingThread extends Thread
{
	private Set<ThreadCompleteListener> listeners = new HashSet<>();

	public final void addListener(final ThreadCompleteListener listener)
	{
		listeners.add(listener);
	}

	public final void removeListener(final ThreadCompleteListener listener)
	{
		listeners.remove(listener);
	}

	public final void notifyListeners()
	{
		for (ThreadCompleteListener listener : listeners)
		{
			listener.notifyOfThreadComplete(this);
		}
	}

	@Override
	public final void run()
	{
		if(!doRun())
		{
			notifyListeners();
		}
	}

	public abstract boolean doRun();
}
