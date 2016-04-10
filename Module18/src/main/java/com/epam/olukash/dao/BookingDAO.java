package com.epam.olukash.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.epam.olukash.dto.AbstractBean;
import com.epam.olukash.dto.Booking;

/**
 * @author Oleksii.Lukash
 */
@Repository
public class BookingDAO extends AbstractDAO<Booking>
{
	private static final String SQL_FIND_BY_NAME = "SELECT bookingID, bookingNumber, ticketPrice, clientID FROM BOOKING WHERE bookingNumber = ?";
	private static final String SQL_INSERT = "INSERT INTO BOOKING (bookingNumber, ticketPrice, clientID) VALUES (?,?,?)";
	private static final String SQL_UPDATE = "UPDATE BOOKING SET bookingNumber = ?, ticketPrice = ?, clientID = ? WHERE bookingID = ?";
	private static final String SQL_FIND_BY_ID = "SELECT bookingID, bookingNumber, ticketPrice, clientID FROM BOOKING WHERE bookingID = ?";
	private static final String SQL_FIND_ALL = "SELECT bookingID, bookingNumber, ticketPrice, clientID FROM BOOKING";
	private static final String SQL_REMOVE = "REMOVE FROM BOOKING WHERE bookingID = ?";

	public Booking findByBookNumber(String bookNumber)
	{
		return (Booking) jdbcTemplate.queryForObject(SQL_FIND_BY_NAME, new Object[] { bookNumber }, new BeanPropertyRowMapper<>(getClazz()));
	}

	@Override
	protected String getInsertSQL()
	{
		return SQL_INSERT;
	}

	@Override
	protected String getUpdateSQL()
	{
		return SQL_UPDATE;
	}

	@Override
	protected String getRemoveSQL()
	{
		return SQL_REMOVE;
	}

	@Override
	protected String getFindSQL()
	{
		return SQL_FIND_BY_ID;
	}

	@Override
	protected String getFindAllSQL()
	{
		return SQL_FIND_ALL;
	}

	@Override
	protected void populateStatement(Booking bean, PreparedStatement ps) throws SQLException
	{
		ps.setString(1, bean.getBookingNumber());
		ps.setInt(2, bean.getTicketPrice());
		ps.setLong(3, bean.getClientID());
	}

	@Override
	protected Object[] getUpdateParam(Booking bean)
	{
		return new Object[]{bean.getBookingNumber(), bean.getTicketPrice(), bean.getClientID(), bean.getBookingID()};
	}

	@Override
	protected List<Booking> createsBeans(List<Map<String, Object>> rows)
	{
		List<Booking> bookingList = new ArrayList<>();
		for(Map<String,Object> row : rows){
			Booking booking = new Booking();
			booking.setBookingID(Long.parseLong(String.valueOf(row.get("bookingID"))));
			booking.setTicketPrice(Integer.parseInt(String.valueOf(row.get("ticketPrice"))));
			booking.setBookingNumber(String.valueOf(row.get("bookingNumber")));
			booking.setClientID(Long.parseLong(String.valueOf(row.get("clientID"))));
			bookingList.add(booking);
		}
		return bookingList;
	}

	protected Class<? extends AbstractBean> getClazz()
	{
		return Booking.class;
	}
}
