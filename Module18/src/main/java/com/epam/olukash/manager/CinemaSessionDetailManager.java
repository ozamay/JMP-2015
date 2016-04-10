package com.epam.olukash.manager;

import java.util.List;
import java.util.Set;

import com.epam.olukash.dto.CinemaSessionDetail;

/**
 * @author Oleksii_Lukash
 */
public interface CinemaSessionDetailManager extends BeanManager<CinemaSessionDetail>
{
	List<CinemaSessionDetail> findByCinemaSessionID(long cinemaSessionID);

	List<CinemaSessionDetail> findByIds(Set<Long> ids);
}
