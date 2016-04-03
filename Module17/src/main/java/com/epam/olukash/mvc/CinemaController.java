package com.epam.olukash.mvc;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.olukash.dto.Book;
import com.epam.olukash.dto.Client;
import com.epam.olukash.dto.Seat;
import com.epam.olukash.manager.BookManager;
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
	@Autowired private BookManager bookManager;
	@Autowired private SessionManager sessionManager;

	@RequestMapping(value = {"/sessions" }, method = RequestMethod.GET)
	public String viewSessions(ModelMap model,
			@RequestParam(value = "date", required = false) Date date) {

		loadDefaultData(model, date, new Client());
		return "allSessions";
	}

	@RequestMapping(value = {"/booking"}, method = RequestMethod.POST)
	public String saveBooking(@Valid @ModelAttribute("client") Client client, BindingResult bindingResult,
			@RequestParam(value = "seatsChose", required = false) List<Long> seatsChose,
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

		List<Seat> seats = seatManager.getSeats(seatsChose);

		Book book = new Book();
		book.setClient(client);
		book.setSeats(seats);
		bookManager.saveNew(book);

		model.addAttribute("book", book);
		return "bookInfo";
	}

	@RequestMapping(value = {"/findBooking"}, method = RequestMethod.GET)
	public String findBooking(ModelMap model,
			@RequestParam(value = "bookNumber", required = false) String bookNumber){

		model.addAttribute("book", bookManager.findByBookNumber(bookNumber));
		return "bookInfo";
	}

	private void loadDefaultData(ModelMap model, Date date, Client client)
	{
		model.addAttribute("sessionDate", date);
		model.addAttribute("sessions", sessionManager.findByDate(date));
		model.addAttribute("client", client);
	}

}
