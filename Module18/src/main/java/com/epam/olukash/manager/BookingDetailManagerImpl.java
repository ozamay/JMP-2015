package com.epam.olukash.manager;

import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.olukash.dao.BookingDetailDAO;
import com.epam.olukash.dto.BookingDetail;

/**
 * @author Oleksii.Lukash
 */
@Component
public class BookingDetailManagerImpl extends AbstractManager<BookingDetail, BookingDetailDAO> implements BookingDetailManager
{
	@Override
	public List<BookingDetail> findByBookingID(long bookingID)
	{
		return beanDAO.findByBookingID(bookingID);
	}
}
