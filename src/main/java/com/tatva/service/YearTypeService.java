package com.tatva.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tatva.entities.YearType;
import com.tatva.repositories.YearTypeRepository;
import com.tatva.utils.Validations;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class YearTypeService {
	
	private final YearTypeRepository yearTypeRepository; 
	
	/*
	 * Returns all records of YearType
	 */
	public List<YearType> getAll(){
		List<YearType> allYearType = yearTypeRepository.findAll();
		Validations.isEmpty(allYearType);
		return allYearType;
	}
}
