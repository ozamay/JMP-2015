package com.epam.olukash.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.epam.olukash.dto.AbstractBean;
import com.epam.olukash.dto.CinemaSessionDetail;

/**
 * @author Oleksii.Lukash
 */
@Repository
public class CinemaSessionDetailDAO extends AbstractDAO<CinemaSessionDetail>
{
	private static final String SQL_INSERT = "INSERT INTO CINEMASESSIONDETAIL (seatID, cinemaSessionID, seatBooked) VALUES (?,?,?)";
	private static final String SQL_UPDATE = "UPDATE CINEMASESSIONDETAIL SET seatID = ?, cinemaSessionID = ?, seatBooked = ? WHERE cinemaSessionDetailID = ?";
	private static final String SQL_FIND_BY_ID = "SELECT cinemaSessionDetailID, seatID, cinemaSessionID, seatBooked FROM CINEMASESSIONDETAIL WHERE cinemaSessionDetailID = ?";
	private static final String SQL_FIND_ALL = "SELECT cinemaSessionDetailID, seatID, cinemaSessionID, seatBooked FROM CINEMASESSIONDETAIL";
	private static final String SQL_REMOVE = "REMOVE FROM CINEMASESSIONDETAIL WHERE bookingDetailID = ?";
	private static final String SQL_FIND_BY_CINEMASESSION_ID = "SELECT cinemaSessionDetailID, seatID, cinemaSessionID, seatBooked FROM CINEMASESSIONDETAIL WHERE cinemaSessionID = ?";
	private static final String SQL_FIND_BY_IDS = "SELECT cinemaSessionDetailID, seatID, cinemaSessionID, seatBooked FROM CINEMASESSIONDETAIL WHERE cinemaSessionDetailID IN (?)";

	public List<CinemaSessionDetail> findByCinemaSessionID(long cinemaSessionID)
	{
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_FIND_BY_CINEMASESSION_ID, new Object[] {cinemaSessionID});
		return createsBeans(rows);
	}

	public List<CinemaSessionDetail> findByIDs(Set<Long> ids)
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("ids", ids);

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_FIND_BY_IDS, new Object[] {parameters});
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
	protected void populateStatement(CinemaSessionDetail bean, PreparedStatement ps) throws SQLException
	{
	 	ps.setLong(1, bean.getSeatID());
		ps.setLong(2, bean.getCinemaSessionID());
		ps.setBoolean(3, bean.isSeatBooked());
	}

	@Override
	protected Object[] getUpdateParam(CinemaSessionDetail bean)
	{
		return new Object[]{bean.getSeatID(), bean.getCinemaSessionID(), bean.isSeatBooked(), bean.getCinemaSessionDetailID()};
	}

	@Override
	protected List<CinemaSessionDetail> createsBeans(List<Map<String, Object>> rows)
	{
		List<CinemaSessionDetail> cinemaSessionDetails = new ArrayList<>();
		for(Map<String,Object> row : rows){
			CinemaSessionDetail detail = new CinemaSessionDetail();
			detail.setCinemaSessionDetailID(Long.parseLong(String.valueOf(row.get("cinemaSessionDetailID"))));
			detail.setSeatID(Long.parseLong(String.valueOf(row.get("seatID"))));
			detail.setSeatBooked(Boolean.parseBoolean(String.valueOf(row.get("seatBooked"))));
			detail.setCinemaSessionID(Long.parseLong(String.valueOf(row.get("cinemaSessionID"))));
			cinemaSessionDetails.add(detail);
		}
		return cinemaSessionDetails;
	}

	@Override
	protected Class<? extends AbstractBean> getClazz()
	{
		return CinemaSessionDetail.class;
	}
}
