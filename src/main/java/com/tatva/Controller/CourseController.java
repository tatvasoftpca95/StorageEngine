package com.tatva.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatva.entities.Course;
import com.tatva.request.AllIdsRequestDto;
import com.tatva.response.TimeTableGenerationDataResponseDTO;
import com.tatva.service.CourseService;

import jakarta.transaction.Transactional;

@RestController
@Transactional(rollbackOn=Exception.class)
@RequestMapping("/course")
@Validated
public class CourseController {
//			=> GET BY COURSE ID
//			=> GET BY ACADEMIC ID
//			=> GET ALL
//getAllCourses based on academicId AND yearTypeId AND semesterId AND programId=> will return List<Course>
	private final CourseService courseService;
	@Autowired
	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}
	
	@GetMapping("/by-academic/{academicId}")
	//@ApiOperation(value = "Get all the courses by academic-id")
	public ResponseEntity<List<Course>> getByAcademicId(@PathVariable("academicId") 
	Integer academicId){
		return ResponseEntity.ok(courseService.getByAcademicId(academicId)); 
	}
	
	@GetMapping("/{courseId}")
	//@ApiOperation(value = "Get course by course-id")
	public ResponseEntity<Course> getById(@PathVariable("courseId") 
	Integer courseId){
		return ResponseEntity.ok(courseService.getById(courseId)); 
	}
	
	@GetMapping
	//@ApiOperation(value = "Get  all records of courses")
	public ResponseEntity<List<Course>> getAll(){
		return ResponseEntity.ok(courseService.getAll()); 
	}
	
	@PostMapping("/byAllIds")
	//@ApiOperation(value = "Get course by academicId, yerTypeId, semesterId and programId")
	public ResponseEntity<List<Course>>getBy4Ids(@Validated @RequestBody AllIdsRequestDto allIdsRequestDto){
		return courseService.getBy4Ids(allIdsRequestDto); 
	}
}
