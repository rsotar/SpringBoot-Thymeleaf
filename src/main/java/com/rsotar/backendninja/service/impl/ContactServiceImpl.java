package com.rsotar.backendninja.service.impl;

import com.rsotar.backendninja.component.ContactConverter;
import com.rsotar.backendninja.entity.Contact;
import com.rsotar.backendninja.model.ContactModel;
import com.rsotar.backendninja.repository.ContactRepository;
import com.rsotar.backendninja.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

  private ContactRepository contactRepository;
  private ContactConverter contactConverter;

  @Autowired
  public ContactServiceImpl(@Qualifier("contactRepository") ContactRepository contactRepository,
							@Qualifier("contactConverter") ContactConverter contactConverter) {
	this.contactRepository = contactRepository;
	this.contactConverter = contactConverter;
  }

  @Override
  public ContactModel addContact(ContactModel contactModel) {

    Contact contact = contactRepository.save(contactConverter.contactModelToContact(contactModel));
	return contactConverter.contactToContactModel(contact);
  }

  @Override
  public List<ContactModel> listAllContacts() {
    List<Contact> contacts = contactRepository.findAll();
    List<ContactModel> contactModels = new ArrayList<>();
    for (Contact c : contacts) {
      contactModels.add(contactConverter.contactToContactModel(c));
	}
	return contactModels;
  }

  @Override
  public Contact findContact(int id) {

    return contactRepository.findById(id);

  }

  public ContactModel findContactByIdModel(int id) {
    return contactConverter.contactToContactModel(findContact(id));
  }

  @Override
  public void removeContact(int id) {
	Contact contact = findContact(id);
    if(contact != null) {
      contactRepository.delete(contact);
	}
  }
}
