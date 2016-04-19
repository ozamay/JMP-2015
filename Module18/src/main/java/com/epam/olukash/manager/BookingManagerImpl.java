package com.epam.olukash.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.olukash.dao.BookingDAO;
import com.epam.olukash.dto.Booking;
import com.epam.olukash.dto.Ticket;
import com.epam.olukash.dto.Client;

/**
 * @author Oleksii.Lukash
 */
@Component
public class BookingManagerImpl extends AbstractManager<Booking, BookingDAO> implements
		BookingManager
{
	@Autowired SeatManager seatManager;
	@Autowired ClientManager clientManager;
	@Autowired TicketManager ticketManager;

	@Override
	public Booking saveNew(Booking booking, Client client, Set<Long> ticketsIDs)
	{
		Long bookingID = save(booking);
		booking.setBookingID(bookingID);

		List<Ticket> tickets = new ArrayList<>();
		int ticketPrice = 0;
		for (Long ticketID : ticketsIDs)
		{
			Ticket ticket = ticketManager.find(ticketID);
			tickets.add(ticket);
			ticketPrice += ticket.getTicketPrice();
			ticket.setBookingID(bookingID);
			ticketManager.update(ticket);
		}

		Long clientID = clientManager.save(client);
		booking.setClientID(clientID);
		booking.setTicketsPrice(ticketPrice);
		booking.setBookingNumber(client.getName() + "-" + booking.getBookingID());

		update(booking);

		return booking;
	}

	@Override
	public Booking findByBookNumber(String bookNumber)
	{
		return beanDAO.findByBookNumber(bookNumber);
	}

}
