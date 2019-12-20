package com.develop.guestbook.Controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.develop.guestbook.DAO.GuestbookDAO;
import com.develop.guestbook.Service.GuestbookService;

@Controller
public class WriteGuestbookController {
	private static final Logger logger = LoggerFactory.getLogger(WriteGuestbookController.class);
	@Resource(name="com.develop.guestbook.service.GuestbookServiceImpl")
	private GuestbookService guestbookServiceImpl;
	
	@RequestMapping(value = "/writeGuestbook", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome! The client locale is {}.", locale);
		
		return "writeGuestbook";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public ModelAndView write(HttpServletRequest req) {
		String email = req.getParameter("email");
		
		GuestbookDAO guestbook = new GuestbookDAO(email, req.getParameter("password"), req.getParameter("contents"));
		
		
		ModelAndView mv = new ModelAndView("redirect:/");
		return mv;
	}
}
