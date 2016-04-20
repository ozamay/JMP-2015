package com.epam.olukash.manager;

import java.util.Set;

import com.epam.olukash.dto.Booking;
import com.epam.olukash.dto.Client;

/**
 * @author Oleksii.Lukash
 */
public interface BookingManager extends BeanManager<Booking>
{
	Booking saveNew(Booking booking, Client client, Set<Long> detailListIDs);
	Booking findByBookNumber(String bookNumber);
}
