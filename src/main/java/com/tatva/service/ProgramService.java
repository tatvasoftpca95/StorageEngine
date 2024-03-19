package com.tatva.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tatva.entities.Program;
import com.tatva.exceptionhandling.BusinessException;
import com.tatva.repositories.ProgramRepository;
import com.tatva.utils.ResponseCode;
import com.tatva.utils.Validations;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProgramService {
	private final ProgramRepository programRepository;
	
	/*
	 * Returns a specific program based on program id
	 */
	public Program getById(Integer programId){
		Program program = programRepository.findById(programId)
				.orElseThrow(() -> new BusinessException(ResponseCode.CFG_INVALID_PROGRAM_ID, HttpStatus.NOT_FOUND));
		return program;
	}
	
	/*
	 * Returns all records of programs
	 */
	public List<Program> getAll(){
		List<Program> allFaculties = programRepository.findAll();
		Validations.isEmpty(allFaculties);
		return allFaculties;
	}

}
