package com.kyc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kyc.bean.Person;
import com.kyc.service.KycIndividualService;

@RestController
@RequestMapping("/individual")
public class KycInidividualController {
	
	@Autowired
	private KycIndividualService kycIndividualService;

	@RequestMapping(value = "/addperson", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Person> addPerson(@RequestBody Person person) {
		person.setFatherName("Uday Pal Yadav");
		boolean isPersonAdded=kycIndividualService.addPerson(person);
		HttpStatus httpStatus=isPersonAdded?HttpStatus.OK:HttpStatus.BAD_REQUEST;
		return new ResponseEntity<Person>(person, httpStatus);
	}
	
	@RequestMapping(value = "/findPersonByFirstName", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Person>> findPersonByFirstName(@RequestBody Person person) {
		List<Person> personList=kycIndividualService.findPersonByFirstName(person.getFirstName());
		HttpStatus httpStatus=personList!=null && !personList.isEmpty()?HttpStatus.OK:HttpStatus.NO_CONTENT;
		return new ResponseEntity<List<Person>>(personList, httpStatus);
	}
}

