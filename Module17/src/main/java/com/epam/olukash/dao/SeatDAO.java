package com.epam.olukash.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.epam.olukash.dto.AbstractBean;
import com.epam.olukash.dto.Seat;

/**
 * @author Oleksii.Lukash
 */
@Repository
public class SeatDAO extends AbstractDAO<Seat>
{
	protected Class<? extends AbstractBean> getClazz()
	{
		return Seat.class;
	}

	public List<Seat> getSeatsByIds(List<Long> ids)
	{
		Criteria criteria = getSession().createCriteria(getClazz());
		criteria.add(Restrictions.in("seatID", ids));
		return criteria.list();
	}
}
