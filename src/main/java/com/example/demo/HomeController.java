package com.example.demo;

import java.util.Objects;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@Autowired
	LoginValidation val;

	@RequestMapping("login")
	public ModelAndView login(HttpServletRequest req) {
		System.out.println("logging in");
		ModelAndView mv = new ModelAndView();
		HttpSession session = req.getSession();
		session.setAttribute("message","Enter your user name and password to login");
		mv.setViewName("login");
		return mv;
	}

	@RequestMapping("adduser")
	public ModelAndView addUser(UserDetails user,HttpServletRequest req) {
		System.out.println("adding user");
		boolean valid = val.addUser(user);

		ModelAndView mv = new ModelAndView();
		HttpSession session = req.getSession();
		if (!valid) {
			session.setAttribute("message","User name already exists, Try again");
		} else {
		
			session.setAttribute("message","User account created you can login");
		}
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping("reset")
	public ModelAndView reset(UserDetails user,HttpServletRequest req) {
		System.out.println("adding user");
		HttpSession session = req.getSession();
		user.setUserName((String) session.getAttribute("userName"));
		
		boolean valid = val.updateDetails(user);

		ModelAndView mv = new ModelAndView();
		
		if (!valid) {
			session.setAttribute("message","User name already exists, Try again");
		} else {
		
			session.setAttribute("message","User account created you can login");
		}
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping("updateDetails")
	public ModelAndView update(UserDetails user,HttpServletRequest req) {
		System.out.println("adding user");
		HttpSession session = req.getSession();
		user.setUserName((String) session.getAttribute("userName"));
		user.setPassword((String) session.getAttribute("password"));
		boolean valid = val.updateDetails(user);

		ModelAndView mv = new ModelAndView();
		
		if (!valid) {
			session.setAttribute("message","User name already exists, Try again");
		} else {
		
			session.setAttribute("message","User account created you can login");
		}
		mv.setViewName("login");
		return mv;
	}

	@RequestMapping("signup")
	public ModelAndView signup(HttpServletRequest req) {
		System.out.println("sign iup");
		ModelAndView mv = new ModelAndView();
		HttpSession session = req.getSession();
		session.setAttribute("message","Create your account");
		mv.setViewName("signup");

		return mv;
	}

	@RequestMapping("validate")
	public ModelAndView validate(UserDetails user, HttpServletRequest req) {
		System.out.println("validate");
		HttpSession session = req.getSession();
		UserDetails usr;
		try {
			usr = val.validateLogin(user);

		} catch (EntityNotFoundException e) {
			usr = null;
			System.out.println(e.getMessage());
		}
		System.out.println(user.getPassword());
		
		
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject(user);
		if (!Objects.isNull(usr)) {
			session.setAttribute("userName", usr.getUserName());

			session.setAttribute("phoneNumber", usr.getPhoneNumber());
			session.setAttribute("age", usr.getAge());
			System.out.println("valid user");
			mv.setViewName("welcome");
		} else {
			session.setAttribute("message","Wrong use name /password");
			System.out.println("invalid user");
			mv.setViewName("login");
		}
		return mv;
	}

}
