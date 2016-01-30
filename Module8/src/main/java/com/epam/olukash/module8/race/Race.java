package com.epam.olukash.module8.race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;

import com.epam.olukash.module8.car.Referee;
import com.epam.olukash.module8.car.Car;
import com.epam.olukash.module8.car.NotifyingThread;

/**
 * @author Oleksii_Lukash
 * @date 1/30/2016
 */
public class Race implements ThreadCompleteListener
{
	private static final Logger log = Logger.getLogger(Race.class);
	private int place = 0;

	public void run()
	{
		CountDownLatch latch = new CountDownLatch(1);
		List<Car> threads = new ArrayList<>();

		for (int i = 0; i < 10; i++)
		{
			Random random = new Random();
			Car car = new Car("Car#" + i, random.nextInt(100), latch);
			car.start();
			car.addListener(this);
			threads.add(car);
		}

		// Create thread daemon that will interrupt random car after 5 sec from start (disqualification)
		Thread daemon = new Thread(new Referee(threads, latch));
		daemon.setDaemon(true);
		daemon.start();
		latch.countDown();
	}

	@Override
	public void notifyOfThreadComplete(NotifyingThread car)
	{
		place++;
		if (place == 1)
		{
			log.info("WINNER!!!" + ((Car) car).getCarName());
		}
		else
		{
			log.info(place + " place: " + ((Car) car).getCarName());
		}
	}

}
