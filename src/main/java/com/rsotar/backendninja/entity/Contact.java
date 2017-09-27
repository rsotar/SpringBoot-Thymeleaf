package com.rsotar.backendninja.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private int id;

  @Column(name = "firstname")
  private String firstname;

  @Column(name = "lastaname")
  private String lastaname;

  @Column(name = "telephone")
  private String telephone;

  @Column(name = "city")
  private String city;

  public Contact() {
  }



  public int getId() {
	return id;
  }

  public void setId(int id) {
	this.id = id;
  }

  public String getFirstname() {
	return firstname;
  }

  public void setFirstname(String firstname) {
	this.firstname = firstname;
  }

  public String getLastaname() {
	return lastaname;
  }

  public void setLastaname(String lastaname) {
	this.lastaname = lastaname;
  }

  public String getTelephone() {
	return telephone;
  }

  public void setTelephone(String telephone) {
	this.telephone = telephone;
  }

  public String getCity() {
	return city;
  }

  public void setCity(String city) {
	this.city = city;
  }

  @Override
  public String toString() {
	return "Contact{" +
			"firstname='" + firstname + '\'' +
			", lastaname='" + lastaname + '\'' +
			", telephone='" + telephone + '\'' +
			", city='" + city + '\'' +
			'}';
  }
}
