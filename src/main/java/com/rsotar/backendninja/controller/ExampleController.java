package com.rsotar.backendninja.controller;

import com.rsotar.backendninja.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController {

  public static final String EXAMPLE_VIEW = "example";

  @GetMapping("/exampleString")
  public String exampleString(Model model) {
    model.addAttribute("person", new Person("Rober", 35));


	return EXAMPLE_VIEW;
  }

  @GetMapping("/exampleMAV")
  public ModelAndView exampleMAV() {
    ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
    mav.addObject("person", new Person("Homero", 50));

    return mav;
  }
}
