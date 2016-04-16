package com.epam.olukash.manager;

import org.springframework.stereotype.Component;

import com.epam.olukash.dao.SeatDAO;
import com.epam.olukash.dto.Seat;

/**
 * @author Oleksii.Lukash
 */
@Component
public class SeatManagerImpl extends AbstractManager<Seat, SeatDAO> implements
		SeatManager
{
}
