package com.epam.olukash.module8.car;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;

/**
 * @author Oleksii_Lukash
 *
 * @date 1/30/2016
 */
public class Referee implements Runnable
{
	private static final Logger log = Logger.getLogger(Referee.class);
	private static final long TIME_FOR_DISQUALIFICATION = 5000;

	private List<Car> threads;
	private CountDownLatch latch;

	public Referee(List<Car> threads, CountDownLatch latch)
	{
		this.latch = latch;
		this.threads = threads;
	}

	@Override
	public void run()
	{
		try
		{
			latch.await();
			if(threads != null && !threads.isEmpty())
			{
				Thread.sleep(TIME_FOR_DISQUALIFICATION);
				Random generator = new Random();
				int i = generator.nextInt(threads.size()-1);
				threads.get(i).interrupt();
				log.info("DISQUALIFICATION!!! " + threads.get(i).getCarName());
			}
		}
		catch (InterruptedException e)
		{
			log.error(e);
		}
	}
}
