package com.epam.olukash.manager;

import java.util.List;

import com.epam.olukash.dto.BookingDetail;

/**
 * @author Oleksii.Lukash
 */
public interface BookingDetailManager extends BeanManager<BookingDetail>
{
	List<BookingDetail> findByBookingID(long bookingID);
}
