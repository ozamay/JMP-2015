package com.epam.olukash.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.olukash.dao.db.InitialDataLoader;

/**
 * @author Oleksii.Lukash
 */
@Controller
@RequestMapping("/database")
public class InitialDataController
{
	@Autowired private InitialDataLoader initialDataLoader;

	@RequestMapping(value = {"/init" }, method = RequestMethod.GET)
	public String initialData() {
		return "initialData";
	}

	@RequestMapping(value = {"/setup" }, method = RequestMethod.GET)
	public String viewCreateData() {
		initialDataLoader.setUpInitialData();
		return "redirect:/";
	}
}
