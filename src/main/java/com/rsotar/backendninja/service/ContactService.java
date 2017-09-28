package com.rsotar.backendninja.service;

import com.rsotar.backendninja.entity.Contact;
import com.rsotar.backendninja.model.ContactModel;

import java.util.List;

public interface ContactService {

  ContactModel addContact(ContactModel contactModel);

  List<ContactModel> listAllContacts();

  Contact findContact(int id);

  void removeContact(int id);

}
