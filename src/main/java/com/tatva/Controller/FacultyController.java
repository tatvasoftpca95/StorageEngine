package com.tatva.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatva.entities.Faculty;
import com.tatva.response.FacultiesAndRoomsResponseDto;
import com.tatva.response.TimeTableGenerationDataResponseDTO;
import com.tatva.service.FacultyService;

import jakarta.transaction.Transactional;

@RestController
@Transactional(rollbackOn=Exception.class)
@RequestMapping("/faculty")
@Validated
public class FacultyController {
//			=> GET BY COURSE ID
//			=> GET BY FACULTY ID
//			=> GET ALL

	
	private final FacultyService facultyService;
	@Autowired
	public FacultyController(FacultyService facultyService) {
		super();
		this.facultyService = facultyService;
	}
	
	@GetMapping("/by-course/{courseId}")
	//@ApiOperation(value = "Get faculty by courseId")
	public ResponseEntity<Faculty> getByCourseId(@PathVariable("courseId") 
	Integer courseId){
		return ResponseEntity.ok(facultyService.getByCourseId(courseId)); 
	}
	
	@GetMapping("/{facultyId}")
	//@ApiOperation(value = "Get faculty by faculty-id")
	public ResponseEntity<Faculty> getById(@PathVariable("facultyId") 
	Integer facultyId){
		return ResponseEntity.ok(facultyService.getById(facultyId)); 
	}
	
	@GetMapping
	//@ApiOperation(value = "Get  all records of faculties")
	public ResponseEntity<List<Faculty>> getAll(){
		return ResponseEntity.ok(facultyService.getAll()); 
	}
	

}
