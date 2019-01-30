package com.kyc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kyc.bean.Person;

public interface KycIndividualRepository extends JpaRepository<Person, Long> {
	List<Person> findByFirstName(String firstName);
}
