package com.rsotar.backendninja.controller;

import com.rsotar.backendninja.model.ContactModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

  @GetMapping("/checkrest")
  public ResponseEntity<ContactModel> checkRest(){

	ContactModel contactModel = new ContactModel(2, "Lucho", "Sarasa", "123456", "atlantida");

    return new ResponseEntity<>(contactModel, HttpStatus.OK);
  }
}
