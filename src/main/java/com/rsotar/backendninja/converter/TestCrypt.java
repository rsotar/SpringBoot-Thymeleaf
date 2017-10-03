package com.rsotar.backendninja.converter;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCrypt  {
	public static void main (String[] args) {
	  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	  System.out.printf(encoder.encode("user"));
	}

}
