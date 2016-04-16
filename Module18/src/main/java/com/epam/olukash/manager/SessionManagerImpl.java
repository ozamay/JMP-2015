package com.epam.olukash.manager;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.olukash.dao.CinemaSessionDAO;
import com.epam.olukash.dto.CinemaSession;

/**
 * @author Oleksii.Lukash
 */
@Component
public class SessionManagerImpl extends AbstractManager<CinemaSession, CinemaSessionDAO> implements SessionManager
{
	@Autowired private TicketManager ticketManager;

	@Override
	public List<CinemaSession> findByDate(Date date)
	{
		List<CinemaSession> sessions = beanDAO.findByDate(date);
		for (CinemaSession session : sessions)
		{
			session.setTickets(ticketManager.findByCinemaSessionID(session.getCinemaSessionID()));
		}
		return sessions;
	}
}
