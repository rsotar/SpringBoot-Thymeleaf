package com.rsotar.backendninja.controller;

import com.rsotar.backendninja.constant.ViewConstant;
import com.rsotar.backendninja.model.UserCredential;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
  
  private static final Logger log = LoggerFactory.getLogger(LoginController.class);

  @GetMapping("/")
  public String redirectToLogin() {
    log.info("Method: redirectToLogin()");
	return "redirect:/login";
  }

  @GetMapping("/login")
  public String showLoginForm(Model model, @RequestParam(name = "error", required = false) String error,
							   @RequestParam(name="logout", required = false) String logout) {
	log.info("Method: showLoginForm() -- Params: error= "+ error + ", logout= " + logout);
    model.addAttribute("userCredentials", new UserCredential());
    model.addAttribute("logout", logout);
    model.addAttribute("error", error);
	log.info("Returning to login view");
    return ViewConstant.LOGIN;
  }

  @PostMapping("/logincheck")
  public String loginCheck(@ModelAttribute(name="userCredentials") UserCredential userCredential) {
    if(userCredential.getUsername().equals("user") && userCredential.getPassword().equals("pass")) {
	  log.info("Returning to contacts view");
      return ViewConstant.CONTACTS;
	}
	log.info("Returning to login?error");
	return "redirect:/login?error";
  }
}
