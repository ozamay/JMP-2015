package com.epam.olukash.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.epam.olukash.dto.AbstractBean;
import com.epam.olukash.dto.Ticket;

/**
 * @author Oleksii.Lukash
 */
@Repository
public class TickerDAO extends AbstractDAO<Ticket>
{
	private static final String SQL_INSERT = "INSERT INTO TICKET (seatID, cinemaSessionID, bookingID, ticketPrice) VALUES (?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE TICKET SET seatID = ?, cinemaSessionID = ?, bookingID = ?, ticketPrice = ? WHERE ticketID = ?";
	private static final String SQL_FIND_BY_ID = "SELECT ticketID, seatID, cinemaSessionID, bookingID, ticketPrice FROM TICKET WHERE ticketID = ?";
	private static final String SQL_FIND_ALL = "SELECT ticketID, seatID, cinemaSessionID, bookingID, ticketPrice FROM TICKET";
	private static final String SQL_REMOVE = "REMOVE FROM TICKET WHERE ticketID = ?";
	private static final String SQL_FIND_BY_CINEMASESSION_ID = "SELECT ticketID, seatID, cinemaSessionID, bookingID, ticketPrice FROM TICKET WHERE cinemaSessionID = ?";
	private static final String SQL_FIND_BY_BOOKING_ID = "SELECT ticketID, seatID, cinemaSessionID, bookingID, ticketPrice FROM TICKET WHERE bookingID = ?";
	private static final String SQL_FIND_BY_IDS = "SELECT ticketID, seatID, cinemaSessionID, bookingID, ticketPrice FROM TICKET WHERE ticketID IN (?)";

	public List<Ticket> findByCinemaSessionID(long cinemaSessionID)
	{
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_FIND_BY_CINEMASESSION_ID, new Object[] {cinemaSessionID});
		return createsBeans(rows);
	}

	public List<Ticket> findByIDs(Set<Long> ids)
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("ids", ids);

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_FIND_BY_IDS, new Object[] {parameters});
		return createsBeans(rows);
	}

	public List<Ticket> findByBookingID(long bookingID)
	{
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_FIND_BY_BOOKING_ID, new Object[] {bookingID});
		return createsBeans(rows);
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
	protected void populateStatement(Ticket bean, PreparedStatement ps) throws SQLException
	{
	 	ps.setLong(1, bean.getSeatID());
		ps.setLong(2, bean.getCinemaSessionID());
		ps.setLong(3, bean.getBookingID());
		ps.setInt(4, bean.getTicketPrice());
	}

	@Override
	protected Object[] getUpdateParam(Ticket bean)
	{
		return new Object[]{bean.getSeatID(), bean.getCinemaSessionID(), bean.getBookingID(), bean.getTicketPrice(), bean.getTicketID()};
	}

	@Override
	protected List<Ticket> createsBeans(List<Map<String, Object>> rows)
	{
		List<Ticket> tickets = new ArrayList<>();
		for(Map<String,Object> row : rows){
			Ticket ticket = new Ticket();
			ticket.setTicketID(Long.parseLong(String.valueOf(row.get("ticketID"))));
			ticket.setSeatID(Long.parseLong(String.valueOf(row.get("seatID"))));

			if (row.get("bookingID") != null)
			{
				ticket.setBookingID(Long.parseLong(String.valueOf(row.get("bookingID"))));
			}

			ticket.setCinemaSessionID(Long.parseLong(String.valueOf(row.get("cinemaSessionID"))));
			ticket.setTicketPrice(Integer.parseInt(String.valueOf(row.get("ticketPrice"))));
			tickets.add(ticket);
		}
		return tickets;
	}

	@Override
	protected Class<? extends AbstractBean> getClazz()
	{
		return Ticket.class;
	}
}
