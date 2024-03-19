package com.tatva.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatva.entities.TimeTableFaculty;
import com.tatva.service.TimeTableFacultyService;

import jakarta.transaction.Transactional;

@RestController
@Transactional(rollbackOn=Exception.class)
@RequestMapping("/ttFaculty")
@Validated
public class TimeTableFacultyController {
//			=> GET BY ID
//			=> GET BY COURSE ID
//			=> GET BY FACULTY ID
//			=> GET BY ROOM ID
//			=> GET ALL
//
//	
	private final TimeTableFacultyService timeTableFacultyService;
	@Autowired
	public TimeTableFacultyController(TimeTableFacultyService timeTableFacultyService) {
		super();
		this.timeTableFacultyService = timeTableFacultyService;
	}
	
	@GetMapping("/{timeTableFacultyId}")
	//@ApiOperation(value = "Get timeTableFaculty by timeTableFaculty-id")
	public ResponseEntity<TimeTableFaculty> getById(@PathVariable("timeTableFacultyId") 
	Integer timeTableFacultyId){
		return ResponseEntity.ok(timeTableFacultyService.getById(timeTableFacultyId)); 
	}

	@GetMapping("/by-course/{courseId}")
	//@ApiOperation(value = "Get timeTableFaculty by courseId")
	public ResponseEntity<List<TimeTableFaculty>> getByCourseId(@PathVariable("courseId") 
	Integer courseId){
		return ResponseEntity.ok(timeTableFacultyService.getByCourseId(courseId)); 
	}
	
	@GetMapping("/by-faculty/{facultyId}")
	//@ApiOperation(value = "Get timeTableFaculty by facultyId")
	public ResponseEntity<List<TimeTableFaculty>> getByFacultyId(@PathVariable("facultyId") 
	Integer facultyId){
		return ResponseEntity.ok(timeTableFacultyService.getByFacultyId(facultyId)); 
	}
	
	@GetMapping("/by-room/{roomId}")
	//@ApiOperation(value = "Get timeTableFaculty by roomId")
	public ResponseEntity<List<TimeTableFaculty>> getByRoomId(@PathVariable("roomId") 
	Integer roomId){
		return ResponseEntity.ok(timeTableFacultyService.getByRoomId(roomId)); 
	}
	
	@GetMapping
	//@ApiOperation(value = "Get  all records of faculties")
	public ResponseEntity<List<TimeTableFaculty>> getAll(){
		return ResponseEntity.ok(timeTableFacultyService.getAll()); 
	}

}
