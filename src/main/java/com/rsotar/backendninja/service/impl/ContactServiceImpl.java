package com.rsotar.backendninja.service.impl;

import com.rsotar.backendninja.entity.Contact;
import com.rsotar.backendninja.model.ContactModel;
import com.rsotar.backendninja.service.ContactService;
import org.springframework.stereotype.Service;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService{

  @Override
  public Contact addContact(ContactModel contactModel) {
	return null;
  }
}
