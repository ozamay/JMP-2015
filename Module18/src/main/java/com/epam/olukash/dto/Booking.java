package com.epam.olukash.dto;

import java.util.List;

/**
 * @author Oleksii.Lukash
 */
public class Booking extends AbstractBean
{
	public static final long serialVersionUID = 1123412L;

	private long bookingID;
	private String bookingNumber;
	private int ticketsPrice;
	private List<Ticket> tickets;
	private long clientID;

	public List<Ticket> getTickets()
	{
		return tickets;
	}

	public void setTickets(List<Ticket> tickets)
	{
		this.tickets = tickets;
	}

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

	public int getTicketsPrice()
	{
		return ticketsPrice;
	}

	public void setTicketsPrice(int ticketsPrice)
	{
		this.ticketsPrice = ticketsPrice;
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
