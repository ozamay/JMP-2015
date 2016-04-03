package com.epam.olukash.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.epam.olukash.dto.AbstractBean;
import com.epam.olukash.dto.CinemaSession;

/**
 * @author Oleksii.Lukash
 */
@Repository
public class SessionDAO extends AbstractDAO<CinemaSession>
{
	protected Class<? extends AbstractBean> getClazz()
	{
		return CinemaSession.class;
	}

	public List<CinemaSession> findByDate(Date date)
	{
		Criteria criteria = getSession().createCriteria(getClazz());
		criteria.add(Restrictions.ge("sessionDate", date));
		criteria.add(Restrictions.lt("sessionDate", DateUtils.addDays(date, 1)));

		return criteria.list();
	}
}
