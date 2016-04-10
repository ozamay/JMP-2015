package com.epam.olukash.manager;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.olukash.dao.SessionDAO;
import com.epam.olukash.dto.CinemaSession;

/**
 * @author Oleksii.Lukash
 */
@Component
public class SessionManagerImpl extends AbstractManager<CinemaSession, SessionDAO> implements SessionManager
{
	@Autowired private CinemaSessionDetailManager detailManager;

	@Override
	public List<CinemaSession> findByDate(Date date)
	{
		List<CinemaSession> sessions = beanDAO.findByDate(date);
		for (CinemaSession session : sessions)
		{
			session.setCinemaSessionDetails(detailManager.findByCinemaSessionID(session.getCinemaSessionID()));
		}
		return sessions;
	}
}
