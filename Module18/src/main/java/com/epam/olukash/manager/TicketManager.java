package com.epam.olukash.manager;

import java.util.List;
import java.util.Set;

import com.epam.olukash.dto.Booking;
import com.epam.olukash.dto.Seat;
import com.epam.olukash.dto.Ticket;

/**
 * @author Oleksii_Lukash
 */
public interface TicketManager extends BeanManager<Ticket>
{
	List<Ticket> findByCinemaSessionID(long cinemaSessionID);

	List<Ticket> findByIds(Set<Long> ids);

	List<Ticket> getTicketsByBookingID(Long bookingID);

}
