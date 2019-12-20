package com.develop.guestbook.Controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

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
	public ModelAndView write(HttpServletRequest req, Model model) {
		String email = req.getParameter("email");
		String regExp = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
		if(Pattern.matches(regExp, email)==false) {
			ModelAndView redirectView = new ModelAndView();
			
			redirectView.addObject("msg", "이메일 형식이 올바르지 않습니다");
			redirectView.addObject("url", "/guestbook/writeGuestbook");
			redirectView.setViewName("redirect");
			return redirectView;
		}
		GuestbookDAO guestbook = new GuestbookDAO(email, req.getParameter("password"), req.getParameter("contents"));
		
		
		ModelAndView mv = new ModelAndView("redirect:/");
		return mv;
	}
}
