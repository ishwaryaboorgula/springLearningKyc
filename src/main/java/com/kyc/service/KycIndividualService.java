package com.kyc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyc.bean.Person;
import com.kyc.repository.KycIndividualRepository;

@Service
public class KycIndividualService {

	@Autowired
	private KycIndividualRepository individualRepository;
	
	public boolean addPerson(Person person) {
		return individualRepository.save(person)!=null;
	}
	
	public List<Person> findPersonByFirstName(String name){
		return individualRepository.findByFirstName(name);
	}
}
