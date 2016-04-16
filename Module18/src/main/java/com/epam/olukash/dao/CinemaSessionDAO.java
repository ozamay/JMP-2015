package com.epam.olukash.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.epam.olukash.dto.AbstractBean;
import com.epam.olukash.dto.CinemaSession;

/**
 * @author Oleksii.Lukash
 */
@Repository
public class CinemaSessionDAO extends AbstractDAO<CinemaSession>
{
	private static final Logger logger = Logger.getLogger(CinemaSessionDAO.class);

	private static final String SQL_INSERT = "INSERT INTO CINEMASESSION(sessionDate, filmName) VALUES (?,?)";
	private static final String SQL_UPDATE = "UPDATE CINEMASESSION SET sessionDate = ?, filmName = ? WHERE cinemaSessionID = ?";
	private static final String SQL_FIND_BY_ID = "SELECT cinemaSessionID, sessionDate, filmName FROM CINEMASESSION WHERE cinemaSessionID = ?";
	private static final String SQL_FIND_ALL = "SELECT cinemaSessionID, sessionDate, filmName FROM CINEMASESSION";
	private static final String SQL_REMOVE = "REMOVE FROM CINEMASESSION WHERE cinemaSessionID = ?";
	private static final String SQL_FIND_BY_DATE = "SELECT cinemaSessionID, sessionDate, filmName FROM CINEMASESSION WHERE sessionDate BETWEEN ? AND ?";

	public List<CinemaSession> findByDate(java.util.Date date)
	{
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_FIND_BY_DATE, new Object[] {date,  DateUtils.addDays(date, 1)});
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
	protected void populateStatement(CinemaSession bean, PreparedStatement ps) throws SQLException
	{
	 	ps.setDate(1, new Date(bean.getSessionDate().getTime()));
		ps.setString(2, bean.getFilmName());
	}

	@Override
	protected Object[] getUpdateParam(CinemaSession bean)
	{
		return new Object[]{bean.getSessionDate(), bean.getFilmName(), bean.getCinemaSessionID()};
	}

	@Override
	protected List<CinemaSession> createsBeans(List<Map<String, Object>> rows)
	{
		List<CinemaSession> cinemaSessionList = new ArrayList<>();
		for(Map<String,Object> row : rows){
			CinemaSession cinemaSession = new CinemaSession();
			cinemaSession.setCinemaSessionID(Long.parseLong(String.valueOf(row.get("cinemaSessionID"))));

			try
			{
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				java.util.Date date = format.parse(String.valueOf(row.get("sessionDate")));
				cinemaSession.setSessionDate(date);
			}
			catch (ParseException e)
			{
				logger.error("cant pare date");
			}

			cinemaSession.setFilmName(String.valueOf(row.get("filmName")));
			cinemaSessionList.add(cinemaSession);
		}
		return cinemaSessionList;
	}

	protected Class<? extends AbstractBean> getClazz()
	{
		return CinemaSession.class;
	}

}
