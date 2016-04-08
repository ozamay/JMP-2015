package com.epam.olukash.manager;

import java.util.List;

import com.epam.olukash.dto.Seat;

/**
 * @author Oleksii.Lukash
 */
public interface SeatManager extends BeanManager<Seat>
{
	List<Seat> getSeats(List<Long> seatsIDs);
}
