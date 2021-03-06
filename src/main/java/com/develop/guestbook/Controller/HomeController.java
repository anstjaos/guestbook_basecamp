package com.develop.guestbook.Controller;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.develop.guestbook.DAO.GuestbookDAO;
import com.develop.guestbook.Service.GuestbookService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Resource(name="com.develop.guestbook.service.GuestbookServiceImpl")
	private GuestbookService guestbookServiceImpl;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		List<GuestbookDAO> guestbookList = guestbookServiceImpl.getGuestbooks();
		model.addAttribute("guestbookList", guestbookList);
		return "home";
	}
}
