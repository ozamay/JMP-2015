package com.epam.olukash.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.epam.olukash.dto.AbstractBean;
import com.epam.olukash.dto.BookingDetail;

/**
 * @author Oleksii.Lukash
 */
@Repository
public class BookingDetailDAO extends AbstractDAO<BookingDetail>
{
	private static final String SQL_INSERT = "INSERT INTO BOOKINGDETAIL (bookingID, cinemaSessionDetailID) VALUES (?,?)";
	private static final String SQL_UPDATE = "UPDATE BOOKINGDETAIL SET bookingID = ?, cinemaSessionDetailID = ? WHERE bookingDetailID = ?";
	private static final String SQL_FIND_BY_ID = "SELECT bookingDetailID, bookingID, cinemaSessionDetailID FROM BOOKINGDETAIL WHERE bookingDetailID = ?";
	private static final String SQL_FIND_ALL = "SELECT bookingDetailID, bookingID, cinemaSessionDetailID FROM BOOKINGDETAIL";
	private static final String SQL_REMOVE = "REMOVE FROM BOOKINGDETAIL WHERE bookingDetailID = ?";
	private static final String SQL_FIND_BY_BOOKING_ID = "SELECT bookingDetailID, bookingID, cinemaSessionDetailID FROM BOOKINGDETAIL WHERE bookingID = ?";

	public List<BookingDetail> findByBookingID(long bookingID)
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
	protected void populateStatement(BookingDetail bean, PreparedStatement ps) throws SQLException
	{
		ps.setLong(1, bean.getBookingID());
		ps.setLong(2, bean.getCinemaSessionDetailID());
	}

	@Override
	protected Object[] getUpdateParam(BookingDetail bean)
	{
		return new Object[]{bean.getBookingID(), bean.getCinemaSessionDetailID(), bean.getBookingDetailID()};
	}

	@Override
	protected List<BookingDetail> createsBeans(List<Map<String, Object>> rows)
	{
		List<BookingDetail> bookingDetails = new ArrayList<>();
		for(Map<String,Object> row : rows){
			BookingDetail bookingDetail = new BookingDetail();
			bookingDetail.setBookingDetailID(Long.parseLong(String.valueOf(row.get("bookingDetailID"))));
			bookingDetail.setBookingID(Long.parseLong(String.valueOf(row.get("bookingID"))));
			bookingDetail.setCinemaSessionDetailID(Long.parseLong(String.valueOf(row.get("cinemaSessionDetailID"))));
			bookingDetails.add(bookingDetail);
		}
		return bookingDetails;
	}

	@Override
	protected Class<? extends AbstractBean> getClazz()
	{
		return BookingDetail.class;
	}

}
