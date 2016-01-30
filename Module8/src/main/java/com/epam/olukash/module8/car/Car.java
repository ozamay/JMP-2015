package com.epam.olukash.module8.car;

import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;

/**
 * @author Oleksii_Lukash
 * @date 1/30/2016
 */
public class Car extends NotifyingThread
{
	private static final long MAX_DISTANCE = 10000;
	private static final Logger log = Logger.getLogger(Car.class);

	private CountDownLatch latch;
	private long friction;
	private long distance;
	private String carName;

	public Car(String name, CountDownLatch latch) {
		this.latch = latch;
		this.carName = name;
		this.friction = 100;
	}

	public Car (String name, long friction, CountDownLatch latch) {
		this.latch = latch;
		this.carName = name;
		this.friction = friction;
	}

	@Override
	public boolean doRun()
	{
		try {
			latch.await();
			while (distance < MAX_DISTANCE) {
				Thread.sleep(friction);
				distance += 100;
				log.info(carName + " " + distance);
			}
		}
		catch (InterruptedException e)
		{
			log.error(e);
			return true;
		}
		return false;
	}

	public long getFriction()
	{
		return friction;
	}

	public void setFriction(long friction)
	{
		this.friction = friction;
	}

	public long getDistance()
	{
		return distance;
	}

	public void setDistance(long distance)
	{
		this.distance = distance;
	}

	public String getCarName()
	{
		return carName;
	}

	public void setCarName(String name)
	{
		this.carName = name;
	}

	public CountDownLatch getLatch()
	{
		return latch;
	}

	public void setLatch(CountDownLatch latch)
	{
		this.latch = latch;
	}
}
