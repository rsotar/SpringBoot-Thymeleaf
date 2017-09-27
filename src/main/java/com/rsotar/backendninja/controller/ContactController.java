package com.rsotar.backendninja.controller;

import com.rsotar.backendninja.constant.ViewConstant;
import com.rsotar.backendninja.model.ContactModel;
import com.rsotar.backendninja.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacts")
public class ContactController {

  private static final Logger log = LoggerFactory.getLogger(ContactController.class);

  private ContactService contactService;

  @Autowired
  public ContactController(ContactService contactService){
	this.contactService = contactService;
  }

  @GetMapping("/cancel")
  public String cancel(){
    return ViewConstant.CONTACTS;
  }

  @GetMapping("/contactform")
  private String redirectContactForm(Model model) {
    model.addAttribute("contactModel", new ContactModel());
    return ViewConstant.CONTACT_FORM;
  }

  @PostMapping("/addcontact")
  public String addContact(@ModelAttribute("contactModel") ContactModel contactModel, Model model){
	log.info("Method: addContact() -- Params: contactModel= "+ contactModel.toString());
	model.addAttribute("result", 1);
    return ViewConstant.CONTACTS;
  }
}
