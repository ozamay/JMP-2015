package com.epam.olukash.dto;

/**
 * @author OleksiiLukash
 */
public class BookingDetail extends AbstractBean
{
	public static final long serialVersionUID = 1L;

	private long bookingDetailID;
	private long bookingID;
	private long cinemaSessionDetailID;

	public long getBookingDetailID()
	{
		return bookingDetailID;
	}

	public void setBookingDetailID(long bookingDetailID)
	{
		this.bookingDetailID = bookingDetailID;
	}

	public long getBookingID()
	{
		return bookingID;
	}

	public void setBookingID(long bookingID)
	{
		this.bookingID = bookingID;
	}

	public long getCinemaSessionDetailID()
	{
		return cinemaSessionDetailID;
	}

	public void setCinemaSessionDetailID(long cinemaSessionDetailID)
	{
		this.cinemaSessionDetailID = cinemaSessionDetailID;
	}
}
