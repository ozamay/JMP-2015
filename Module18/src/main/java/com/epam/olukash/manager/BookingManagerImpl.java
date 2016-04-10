package com.epam.olukash.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.olukash.dao.BookingDAO;
import com.epam.olukash.dto.Booking;
import com.epam.olukash.dto.BookingDetail;
import com.epam.olukash.dto.CinemaSessionDetail;
import com.epam.olukash.dto.Client;
import com.epam.olukash.dto.Seat;

/**
 * @author Oleksii.Lukash
 */
@Component
public class BookingManagerImpl extends AbstractManager<Booking, BookingDAO> implements
		BookingManager
{
	@Autowired SeatManager seatManager;
	@Autowired ClientManager clientManager;
	@Autowired CinemaSessionDetailManager cinemaSessionDetailManager;
	@Autowired BookingDetailManager bookingDetailManager;

	@Override
	public Booking saveNew(Booking booking, Client client, Set<Long> detailListIDs)
	{
		Long bookingID = save(booking);
		booking.setBookingID(bookingID);

		List<BookingDetail> bookingDetails = new ArrayList<>();
		int ticketPrice = 0;
		for (Long detailID : detailListIDs)
		{
			CinemaSessionDetail cinemaSessionDetail = cinemaSessionDetailManager.find(detailID);

			BookingDetail bookingDetail = new BookingDetail();
			bookingDetail.setCinemaSessionDetailID(cinemaSessionDetail.getCinemaSessionDetailID());
			bookingDetail.setBookingID(bookingID);
			bookingDetail.setBookingID(bookingDetailManager.save(bookingDetail));
			bookingDetails.add(bookingDetail);

			ticketPrice += seatManager.find(cinemaSessionDetail.getSeatID()).getPrice();
			cinemaSessionDetail.setSeatBooked(true);
			cinemaSessionDetailManager.update(cinemaSessionDetail);
		}

		Long clientID = clientManager.save(client);
		booking.setClientID(clientID);
		booking.setTicketPrice(ticketPrice);
		booking.setBookingNumber(client.getName() + "-" + booking.getBookingID());

		update(booking);

		booking.setBookingDetails(bookingDetails);
		return booking;
	}

	@Override
	public Booking findByBookNumber(String bookNumber)
	{
		return beanDAO.findByBookNumber(bookNumber);
	}

	private long calculateTicketsPrice(List<Seat> seats)
	{
		long  ticketPrice = 0;
		for (Seat seat : seats)
		{
			ticketPrice += seat.getPrice();
		}
		return ticketPrice;
	}
}
