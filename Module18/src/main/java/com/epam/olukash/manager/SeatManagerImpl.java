package com.epam.olukash.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.olukash.dao.SeatDAO;
import com.epam.olukash.dto.Booking;
import com.epam.olukash.dto.BookingDetail;
import com.epam.olukash.dto.CinemaSessionDetail;
import com.epam.olukash.dto.Seat;

/**
 * @author Oleksii.Lukash
 */
@Component
public class SeatManagerImpl extends AbstractManager<Seat, SeatDAO> implements
		SeatManager
{

	@Autowired private CinemaSessionDetailManager cinemaSessionDetailManager;

	@Override
	public List<Seat> getSeatsByBooking(Booking booking)
	{
		List<Seat> bookedSeats = new ArrayList<>();
		for(BookingDetail bookingDetail : booking.getBookingDetails())
		{
			CinemaSessionDetail cinemaSessionDetail = cinemaSessionDetailManager.find(bookingDetail.getCinemaSessionDetailID());
			bookedSeats.add(find(cinemaSessionDetail.getSeatID()));
		}
		return bookedSeats;
	}
}
