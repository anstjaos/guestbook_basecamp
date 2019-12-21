package com.develop.guestbook.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.develop.guestbook.Security.SecurityUtil;
import com.develop.guestbook.Service.GuestbookService;

@Controller
public class ReviseGuestbookController {
	private static final Logger logger = LoggerFactory.getLogger(ReviseGuestbookController.class);
	@Resource(name="com.develop.guestbook.service.GuestbookServiceImpl")
	private GuestbookService guestbookServiceImpl;
	
	@RequestMapping(value = "/reviseGuestbook", method = RequestMethod.POST)
	public String reviseGuestbook(Locale locale, Model model, HttpServletRequest req) {
		logger.info("Welcome! The client locale is {}.", locale);
		
		model.addAttribute("id", req.getParameter("id"));
		model.addAttribute("email", req.getParameter("email"));
		model.addAttribute("contents", req.getParameter("contents"));
		
		SecurityUtil securityUtil = new SecurityUtil();
		String encryptPwd = securityUtil.encryptSHA256(req.getParameter("inputPwd"));
		
		System.out.println("ecrypt " + encryptPwd);
		System.out.println("pwd " +req.getParameter("password"));
		
		if(!encryptPwd.equals(req.getParameter("password"))) {
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다");
			model.addAttribute("url", "/guestbook/");
			
			return "redirect";
		}
		
		return "reviseGuestbook";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST) 
	public ModelAndView update(HttpServletRequest req) {
		Date now = new Date();
		String pattern = "yyyy-MM-dd HH:mm:ss";
		String date = new SimpleDateFormat(pattern).format(now);
		
		GuestbookDAO guestbook = new GuestbookDAO(Integer.parseInt(req.getParameter("id")), req.getParameter("contents"), date);
		guestbookServiceImpl.updateGuestbook(guestbook);
		
		ModelAndView mv = new ModelAndView("redirect:/");
		return mv;
	}
}
