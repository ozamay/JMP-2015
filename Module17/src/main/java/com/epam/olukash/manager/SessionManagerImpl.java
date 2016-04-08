package com.epam.olukash.manager;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.olukash.dao.SessionDAO;
import com.epam.olukash.dto.CinemaSession;

/**
 * @author Oleksii.Lukash
 */
@Component
public class SessionManagerImpl extends AbstractManager<CinemaSession, SessionDAO> implements SessionManager
{
	@Override
	public List<CinemaSession> findByDate(Date date)
	{
		return beanDAO.findByDate(date);
	}
}
