package com.rsotar.backendninja.controller;

import com.rsotar.backendninja.constant.ViewConstant;
import com.rsotar.backendninja.model.ContactModel;
import com.rsotar.backendninja.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contacts")
public class ContactController {

  private static final Logger log = LoggerFactory.getLogger(ContactController.class);


  private ContactService contactService;

  @Autowired
  public ContactController(@Qualifier("contactServiceImpl") ContactService contactService){
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

  @GetMapping("/showcontacts")
  public ModelAndView showContacts() {
    ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
    mav.addObject("contacts", contactService.listAllContacts());

    return mav;
  }

  @GetMapping("/removecontact")
	public ModelAndView removeContact(@RequestParam(name="id", required=true) int id) {
    contactService.removeContact(id);
    return showContacts();
  }

  @PostMapping("/addcontact")
  public String addContact(@ModelAttribute("contactModel") ContactModel contactModel, Model model){
	log.info("Method: addContact() -- Params: contactModel= "+ contactModel.toString());

	if (contactService.addContact(contactModel) != null) {
	  model.addAttribute("result", 1);
	} else {
	  model.addAttribute("result", 0);
	}

    return "redirect:/contacts/showcontacts";
  }
}
