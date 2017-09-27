package com.rsotar.backendninja.service;

import com.rsotar.backendninja.entity.Contact;
import com.rsotar.backendninja.model.ContactModel;

public interface ContactService {

  Contact addContact(ContactModel contactModel);

}
