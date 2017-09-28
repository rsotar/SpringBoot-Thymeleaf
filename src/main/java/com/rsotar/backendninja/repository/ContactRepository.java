package com.rsotar.backendninja.repository;

import com.rsotar.backendninja.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact,Serializable> {

  Contact findById(int id);

}
