package com.epam.olukash.mvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.olukash.dto.Booking;
import com.epam.olukash.dto.BookingDetail;
import com.epam.olukash.dto.CinemaSessionDetail;
import com.epam.olukash.dto.Client;
import com.epam.olukash.manager.BookingDetailManager;
import com.epam.olukash.manager.BookingManager;
import com.epam.olukash.manager.CinemaSessionDetailManager;
import com.epam.olukash.manager.ClientManager;
import com.epam.olukash.manager.SeatManager;
import com.epam.olukash.manager.SessionManager;

/**
 * @author Oleksii.Lukash
 */
@Controller
@RequestMapping("/")
public class CinemaController
{
	@Autowired private SeatManager seatManager;
	@Autowired private BookingManager bookingManager;
	@Autowired private SessionManager sessionManager;
	@Autowired private ClientManager clientManager;
	@Autowired private BookingDetailManager bookingDetailManager;
	@Autowired private CinemaSessionDetailManager cinemaSessionDetailManager;

	@RequestMapping(value = {"/sessions" }, method = RequestMethod.GET)
	public String viewSessions(ModelMap model,
			@RequestParam(value = "date", required = false) Date date) {

		loadDefaultData(model, date, new Client());
		return "allSessions";
	}

	@RequestMapping(value = {"/booking"}, method = RequestMethod.POST)
	public String saveBooking(@Valid @ModelAttribute("client") Client client, BindingResult bindingResult,
			@RequestParam(value = "seatsChose", required = false) Set<Long> seatsChose,
			@RequestParam(value = "sessionDate", required = false) Date date, ModelMap model){

		//error checking
		if(bindingResult.hasErrors() || seatsChose == null)
		{
			if(seatsChose == null)
			{
				model.addAttribute("message", "Please select at least one seat");
			}
			loadDefaultData(model, date, client);
			return "allSessions";
		}

		Booking booking = bookingManager.saveNew(new Booking(), client, seatsChose);

		model.addAttribute("booking", booking);
		model.addAttribute("client", client);
		populateDTOs(model, booking.getBookingID());
		return "bookInfo";
	}

	@RequestMapping(value = {"/ajax/bookingInfo"}, method = RequestMethod.GET)
	public ModelAndView findBookingInfo(ModelMap model,
			@RequestParam(value = "bookingNumber", required = false) String bookNumber){

		Booking booking = bookingManager.findByBookNumber(bookNumber);
		model.addAttribute("booking", booking);
		model.addAttribute("client", clientManager.find(booking.getClientID()));
		populateDTOs(model, booking.getBookingID());
		return new ModelAndView("info", model);
	}

	private void loadDefaultData(ModelMap model, Date date, Client client)
	{
		model.addAttribute("sessionDate", date);
		model.addAttribute("sessions", sessionManager.findByDate(date));
		model.addAttribute("client", client);
	}

	private void populateDTOs(ModelMap map, Long bookID)
	{
		List<BookInfoDTO> dtos = new ArrayList<>();
		for(BookingDetail bookingDetail : bookingDetailManager.findByBookingID(bookID))
		{
			CinemaSessionDetail cinemaSessionDetail = cinemaSessionDetailManager.find(bookingDetail.getCinemaSessionDetailID());

			BookInfoDTO dto = new BookInfoDTO();
			dto.setCinemaSession(sessionManager.find(cinemaSessionDetail.getCinemaSessionID()));
			dto.setSeat(seatManager.find(cinemaSessionDetail.getSeatID()));
			dtos.add(dto);
		}
		map.addAttribute("bookingInfoDTOs", dtos);
	}
}
