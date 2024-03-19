package com.tatva.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tatva.entities.AcademicDetails;
import com.tatva.entities.Course;
import com.tatva.exceptionhandling.BusinessException;
import com.tatva.repositories.AcademicDetailsRepository;
import com.tatva.repositories.CourseRepository;
import com.tatva.repositories.FacultyRepository;
import com.tatva.repositories.RoomRepository;
import com.tatva.request.AllIdsRequestDto;
import com.tatva.utils.ResponseCode;
import com.tatva.utils.Validations;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService {
	private final AcademicDetailsRepository academicDetailsRepository; 
	private final CourseRepository courseRepository;
	private final FacultyRepository facultyRepository;
	private final RoomRepository roomRepository;
	
	/*
	 * Returns a specific course based on academic id
	 */
	public List<Course> getByAcademicId(Integer academicId){
		//Validating id  from ACADEMIC_DETAILS table
		AcademicDetails academic = academicDetailsRepository.findById(academicId)
				.orElseThrow(() -> new BusinessException(ResponseCode.CFG_INVALID_ACADEMIC_ID, HttpStatus.NOT_FOUND));
		
		List<Course> courses=new ArrayList<Course>();
		
		courses=courseRepository.findAllByAcademicId(academicId);
        Validations.isEmpty(courses);
		
		return courses;
	}
	
	/*
	 * Returns a specific course based on course id
	 */
	public Course getById(Integer courseId){
		//Validating id  from ACADEMIC_DETAILS table
		Course course = courseRepository.findById(courseId)
				.orElseThrow(() -> new BusinessException(ResponseCode.CFG_INVALID_COURSE_ID, HttpStatus.NOT_FOUND));
		return course;
	}
	
	/*
	 * Returns all records of Courses
	 */
	public List<Course> getAll(){
		List<Course> allCourses = courseRepository.findAll();
		Validations.isEmpty(allCourses);
		return allCourses;
	}
	//AllIdsRequestDto=> academicId,yearTypeId,semesterId,programId;
	/*
	 * Returns a specific course based on course id
	 */
	public ResponseEntity<List<Course>> getBy4Ids(AllIdsRequestDto allIdsRequestDto){
		List<Course> courses= 
				courseRepository.findAllByAcademicIdAndYearTypeIdAndSemesterIdAndProgramId(allIdsRequestDto.getAcademicId(), 
						allIdsRequestDto.getYearTypeId(),
						allIdsRequestDto.getSemesterId(), allIdsRequestDto.getProgramId());
		return ResponseEntity.ok(courses);
	}

}
