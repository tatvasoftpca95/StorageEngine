package com.tatva.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tatva.entities.Semester;
import com.tatva.exceptionhandling.BusinessException;
import com.tatva.repositories.SemesterRepository;
import com.tatva.utils.ResponseCode;
import com.tatva.utils.Validations;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SemesterService {
	private final SemesterRepository semesterRepository;
	
	/*
	 * Returns a specific semester based on semester id
	 */
	public Semester getById(Integer semesterId){
		Semester semester = semesterRepository.findById(semesterId)
				.orElseThrow(() -> new BusinessException(ResponseCode.CFG_INVALID_SEMESTER_ID, HttpStatus.NOT_FOUND));
		return semester;
	}
	
	/*
	 * Returns all records of semesters
	 */
	public List<Semester> getAll(){
		List<Semester> allFaculties = semesterRepository.findAll();
		Validations.isEmpty(allFaculties);
		return allFaculties;
	}

}
