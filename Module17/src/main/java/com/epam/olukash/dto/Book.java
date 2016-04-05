package com.epam.olukash.dto;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Oleksii.Lukash
 */
@Entity
@Table(name = "Book")
public class Book extends AbstractBean
{
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookID;

	@Column
	private String bookNumber;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "book_seat", joinColumns = {
			@JoinColumn(name = "bookID")}, inverseJoinColumns = {
			@JoinColumn(name = "seatID")})
	private List<Seat> seats;

	@Column
	private long ticketPrice;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientID")
	private Client client;

	public String getBookNumber()
	{
		return bookNumber;
	}

	public void setBookNumber(String bookNumber)
	{
		this.bookNumber = bookNumber;
	}

	public long getBookID()
	{
		return bookID;
	}

	public void setBookID(long bookID)
	{
		this.bookID = bookID;
	}

	public long getTicketPrice()
	{
		return ticketPrice;
	}

	public void setTicketPrice(long ticketPrice)
	{
		this.ticketPrice = ticketPrice;
	}

	public Client getClient()
	{
		return client;
	}

	public void setClient(Client client)
	{
		this.client = client;
	}

	public List<Seat> getSeats()
	{
		return seats;
	}

	public void setSeats(List<Seat> seats)
	{
		this.seats = seats;
	}

}
