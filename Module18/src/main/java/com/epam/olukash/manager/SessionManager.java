package com.epam.olukash.manager;

import java.util.Date;
import java.util.List;

import com.epam.olukash.dto.CinemaSession;

/**
 * @author Oleksii.Lukash
 */
public interface SessionManager extends BeanManager<CinemaSession>
{
	List<CinemaSession> findByDate(Date date);
}
