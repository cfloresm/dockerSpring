package com.docker.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.docker.example.dao.User;
import com.docker.example.dao.repository.UserRepository;

@Controller(value="/users/register")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> register(RegisterInput input){
		try {
			repository.save(new User(input.getName(),input.getPassword(),input.getEmail()));
			System.out.println("Register user ....");
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
