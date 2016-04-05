package com.epam.olukash.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.olukash.dao.BookDAO;
import com.epam.olukash.dto.Book;
import com.epam.olukash.dto.Seat;

/**
 * @author Oleksii.Lukash
 */
@Component
public class BookManagerImpl extends AbstractManager<Book, BookDAO> implements
		BookManager
{
	@Autowired SeatManager seatManager;
	@Autowired ClientManager clientManager;

	@Override
	public Book saveNew(Book book)
	{
		clientManager.save(book.getClient());

		String bookNumber = book.getClient().getName() + "-" + book.getClient().getId();
		book.setBookNumber(bookNumber);
		book.setTicketPrice(calculateTicketsPrice(book.getSeats()));
		save(book);

		for(Seat seat : book.getSeats())
		{
			seat.setBooked(true);
			seatManager.update(seat);
		}

		return book;
	}

	@Override
	public Book findByBookNumber(String bookNumber)
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
