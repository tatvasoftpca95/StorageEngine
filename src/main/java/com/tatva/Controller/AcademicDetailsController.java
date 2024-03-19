package com.tatva.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatva.entities.AcademicDetails;
import com.tatva.response.TimeTableGenerationDataResponseDTO;
import com.tatva.service.AcademicDetailsService;

import jakarta.transaction.Transactional;

@RestController
@Transactional(rollbackOn=Exception.class)
@RequestMapping("/academic")
@Validated
public class AcademicDetailsController {
	//2. getAllAcademicDetails will return List<AcademicDetails>
	private final AcademicDetailsService academicDetailsService;
	@Autowired
	public AcademicDetailsController(AcademicDetailsService academicDetailsService) {
		super();
		this.academicDetailsService = academicDetailsService;
	}
	
	@GetMapping("/all-details/{academicId}")
	//@ApiOperation(value = "Get all the courses, faculties and rooms details by academic-id")
	public ResponseEntity<TimeTableGenerationDataResponseDTO> getByAcademicId(@PathVariable("academicId") 
	Integer academicId){
		return ResponseEntity.ok(academicDetailsService.getByAcademicId(academicId)); 
	}
	
	@GetMapping("/{academicId}")
	//@ApiOperation(value = "Get academic details by academic-id")
	public ResponseEntity<AcademicDetails> getById(@PathVariable("academicId") 
	Integer academicId){
		return ResponseEntity.ok(academicDetailsService.getById(academicId)); 
	}
	
	@GetMapping
	//@ApiOperation(value = "Get  all records of academic details")
	public ResponseEntity<List<AcademicDetails>> getAll(){
		return ResponseEntity.ok(academicDetailsService.getAll()); 
	}

}
