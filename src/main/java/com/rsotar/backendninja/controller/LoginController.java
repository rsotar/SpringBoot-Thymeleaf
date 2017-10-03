package com.rsotar.backendninja.controller;

import com.rsotar.backendninja.constant.ViewConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
  
  private static final Logger log = LoggerFactory.getLogger(LoginController.class);

  @GetMapping("/login")
  public String showLoginForm(Model model,
							  @RequestParam(name = "error", required = false) String error,
							  @RequestParam(name="logout", required = false) String logout) {
	log.info("Method: showLoginForm() -- Params: error= "+ error + ", logout= " + logout);

    model.addAttribute("logout", logout);
    model.addAttribute("error", error);
	log.info("Returning to login view");
    return ViewConstant.LOGIN;
  }

  @GetMapping({"/loginsuccess", "/"})
  public String loginCheck() {
	log.info("METHOD: loginCheck()");
	log.info("Returning to contacts view");
	return "redirect:/contacts/showcontacts";
  }
}
