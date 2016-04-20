package com.epam.olukash.manager;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.epam.olukash.dao.TickerDAO;
import com.epam.olukash.dto.Ticket;

/**
 * @author Oleksii.Lukash
 */
@Component
public class TicketManagerImpl extends AbstractManager<Ticket, TickerDAO> implements TicketManager
{
	@Override
	public List<Ticket> findByCinemaSessionID(long cinemaSessionID)
	{
		return beanDAO.findByCinemaSessionID(cinemaSessionID);
	}

	@Override
	public List<Ticket> findByIds(Set<Long> ids)
	{
		return beanDAO.findByIDs(ids);
	}

	@Override
	public List<Ticket> getTicketsByBookingID(Long bookingID)
	{
		return beanDAO.findByBookingID(bookingID);
	}
}
