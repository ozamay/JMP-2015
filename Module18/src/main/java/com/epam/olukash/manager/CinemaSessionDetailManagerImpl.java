package com.epam.olukash.manager;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.epam.olukash.dao.CinemaSessionDetailDAO;
import com.epam.olukash.dto.CinemaSessionDetail;

/**
 * @author Oleksii.Lukash
 */
@Component
public class CinemaSessionDetailManagerImpl extends AbstractManager<CinemaSessionDetail, CinemaSessionDetailDAO> implements CinemaSessionDetailManager
{

	@Override
	public List<CinemaSessionDetail> findByCinemaSessionID(long cinemaSessionID)
	{
		return beanDAO.findByCinemaSessionID(cinemaSessionID);
	}

	@Override
	public List<CinemaSessionDetail> findByIds(Set<Long> ids)
	{
		return beanDAO.findByIDs(ids);
	}
}
