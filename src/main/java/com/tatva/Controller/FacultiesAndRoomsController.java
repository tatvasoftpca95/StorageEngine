package com.tatva.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatva.response.FacultiesAndRoomsResponseDto;
import com.tatva.service.FacultyService;

import jakarta.transaction.Transactional;

@RestController
@Transactional(rollbackOn=Exception.class)
@RequestMapping("/faculties")
@Validated
public class FacultiesAndRoomsController {
	
	private final FacultyService facultyService;
	@Autowired
	public FacultiesAndRoomsController(FacultyService facultyService) {
		super();
		this.facultyService = facultyService;
	}
	
	//1. getAllFacultiesAndRooms will return List<Room> and List<Faculty>
	@GetMapping("/rooms")
	//@ApiOperation(value = "Get all the faculties and rooms details")
	public ResponseEntity<FacultiesAndRoomsResponseDto> getFacultiesAndRooms(){
		return ResponseEntity.ok(facultyService.getFacultiesAndRooms()); 
	}

}
