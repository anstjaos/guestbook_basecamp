package com.develop.guestbook.Controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WriteGuestbookController {
	private static final Logger logger = LoggerFactory.getLogger(WriteGuestbookController.class);
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/writeGuestbook", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome! The client locale is {}.", locale);
		
		return "writeGuestbook";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public ModelAndView write(HttpServletRequest req) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("email", req.getParameter("email"));
		
		ModelAndView mv = new ModelAndView("redirect:/");
		return mv;
	}
}
