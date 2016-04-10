package com.epam.olukash.dto;

import java.util.List;

/**
 * @author Oleksii.Lukash
 */
public class Booking extends AbstractBean
{
	public static final long serialVersionUID = 1L;
	private long bookingID;
	private String bookingNumber;
	private int ticketPrice;
	private List<BookingDetail> bookingDetails;
	private long clientID;

	public long getBookingID()
	{
		return bookingID;
	}

	public void setBookingID(long bookingID)
	{
		this.bookingID = bookingID;
	}

	public String getBookingNumber()
	{
		return bookingNumber;
	}

	public void setBookingNumber(String bookingNumber)
	{
		this.bookingNumber = bookingNumber;
	}

	public int getTicketPrice()
	{
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice)
	{
		this.ticketPrice = ticketPrice;
	}

	public List<BookingDetail> getBookingDetails()
	{
		return bookingDetails;
	}

	public void setBookingDetails(List<BookingDetail> bookingDetails)
	{
		this.bookingDetails = bookingDetails;
	}

	public long getClientID()
	{
		return clientID;
	}

	public void setClientID(long clientID)
	{
		this.clientID = clientID;
	}

}
