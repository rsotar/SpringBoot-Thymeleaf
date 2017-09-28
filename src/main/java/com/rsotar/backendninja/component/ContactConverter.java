package com.rsotar.backendninja.component;

import com.rsotar.backendninja.entity.Contact;
import com.rsotar.backendninja.model.ContactModel;
import org.springframework.stereotype.Component;

@Component("contactConverter")
public class ContactConverter {

  public Contact contactModelToContact(ContactModel contactModel) {
    Contact contact = new Contact();
    contact.setCity(contactModel.getCity());
    contact.setFirstname(contactModel.getFirstname());
    contact.setId(contactModel.getId());
    contact.setLastaname(contactModel.getLastname());
    contact.setTelephone(contactModel.getTelephone());
    return contact;
  }

  public ContactModel contactToContactModel(Contact contact) {
    ContactModel contactModel = new ContactModel();
	contactModel.setCity(contact.getCity());
	contactModel.setFirstname(contact.getFirstname());
	contactModel.setId(contact.getId());
	contactModel.setLastname(contact.getLastaname());
	contactModel.setTelephone(contact.getTelephone());
    return contactModel;
  }
}
