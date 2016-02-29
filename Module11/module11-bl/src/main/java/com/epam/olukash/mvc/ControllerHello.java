package com.epam.olukash.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epam.olukash.manager.UserManager;

/**
 * @author Oleksii.Lukash
 */
@Controller
public class ControllerHello
{
	@Autowired
	private UserManager userManager;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Hello");
		return "combo";

	}

	@RequestMapping(value = "/test/{id:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("id") int id) {

		ModelAndView model = new ModelAndView();
		model.setViewName("combo");
		model.addObject("user", userManager.find(id));

		return model;
	}

}