package com.epam.olukash.dto;

/**
 * @author Oleksii.Lukash
 */
public class Ticket extends AbstractBean
{
	public static final long serialVersionUID = 1141232212L;

	private long ticketID;
	private long cinemaSessionID;
	private long seatID;
	private Long bookingID;
	private int ticketPrice;

	public int getTicketPrice()
	{
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice)
	{
		this.ticketPrice = ticketPrice;
	}

	public long getTicketID()
	{
		return ticketID;
	}

	public void setTicketID(long ticketID)
	{
		this.ticketID = ticketID;
	}

	public Long getBookingID()
	{
		return bookingID;
	}

	public void setBookingID(Long bookingID)
	{
		this.bookingID = bookingID;
	}

	public long getCinemaSessionID()
	{
		return cinemaSessionID;
	}

	public void setCinemaSessionID(long cinemaSessionID)
	{
		this.cinemaSessionID = cinemaSessionID;
	}

	public long getSeatID()
	{
		return seatID;
	}

	public void setSeatID(long seatID)
	{
		this.seatID = seatID;
	}


}
