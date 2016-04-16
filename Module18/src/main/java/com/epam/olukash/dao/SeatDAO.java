package com.epam.olukash.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.epam.olukash.dto.AbstractBean;
import com.epam.olukash.dto.Seat;

/**
 * @author Oleksii.Lukash
 */
@Repository
public class SeatDAO extends AbstractDAO<Seat>
{
	private static final String SQL_INSERT = "INSERT INTO SEAT (seatNumber) VALUES (?)";
	private static final String SQL_UPDATE = "UPDATE SEAT SET seatNumber = ? WHERE seatID = ?";
	private static final String SQL_FIND_BY_ID = "SELECT seatID, seatNumber FROM SEAT WHERE seatID = ?";
	private static final String SQL_FIND_ALL = "SELECT seatID, seatNumber FROM SEAT";
	private static final String SQL_REMOVE = "REMOVE FROM SEAT WHERE seatID = ?";

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
	protected void populateStatement(Seat bean, PreparedStatement ps) throws SQLException
	{
		ps.setInt(1, bean.getSeatNumber());
	}

	@Override
	protected Object[] getUpdateParam(Seat bean)
	{
		return new Object[]{bean.getSeatNumber(), bean.getSeatID()};
	}

	@Override
	protected List<Seat> createsBeans(List<Map<String, Object>> rows)
	{
		List<Seat> seatList = new ArrayList<>();
		for(Map<String,Object> row : rows){
			Seat seat = new Seat();
			seat.setSeatID(Long.parseLong(String.valueOf(row.get("seatID"))));
			seat.setSeatNumber(Integer.parseInt(String.valueOf(row.get("seatNumber"))));
			seatList.add(seat);
		}
		return seatList;
	}

	protected Class<? extends AbstractBean> getClazz()
	{
		return Seat.class;
	}

}
