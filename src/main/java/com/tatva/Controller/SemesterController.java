package com.tatva.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatva.entities.Semester;
import com.tatva.service.SemesterService;

import jakarta.transaction.Transactional;

@RestController
@Transactional(rollbackOn=Exception.class)
@RequestMapping("/semester")
@Validated
public class SemesterController {
////			semester
//			=> GET BY ID
//			=> GET ALL
	
	private final SemesterService semesterService;
	@Autowired
	public SemesterController(SemesterService semesterService) {
		super();
		this.semesterService = semesterService;
	}
	
	@GetMapping("/{semesterId}")
	//@ApiOperation(value = "Get semester by semester-id")
	public ResponseEntity<Semester> getById(@PathVariable("semesterId") 
	Integer semesterId){
		return ResponseEntity.ok(semesterService.getById(semesterId)); 
	}
	
	@GetMapping
	//@ApiOperation(value = "Get  all records of semesters")
	public ResponseEntity<List<Semester>> getAll(){
		return ResponseEntity.ok(semesterService.getAll()); 
	}

}
