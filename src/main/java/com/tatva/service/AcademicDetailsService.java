package com.tatva.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tatva.entities.AcademicDetails;
import com.tatva.entities.Course;
import com.tatva.entities.Faculty;
import com.tatva.entities.Room;
import com.tatva.exceptionhandling.BusinessException;
import com.tatva.repositories.AcademicDetailsRepository;
import com.tatva.repositories.CourseRepository;
import com.tatva.repositories.FacultyRepository;
import com.tatva.repositories.RoomRepository;
import com.tatva.response.TimeTableGenerationDataResponseDTO;
import com.tatva.utils.ResponseCode;
import com.tatva.utils.Validations;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AcademicDetailsService {
	
	private final AcademicDetailsRepository academicDetailsRepository; 
	private final CourseRepository courseRepository;
	private final FacultyRepository facultyRepository;
	private final RoomRepository roomRepository;
	
	/*
	 * Returns TimeTableGenerationDataResponseDTO
	 */
	public TimeTableGenerationDataResponseDTO getByAcademicId(Integer academicId){
		//Validating id  from ACADEMIC_DETAILS table
		AcademicDetails academic = academicDetailsRepository.findById(academicId)
				.orElseThrow(() -> new BusinessException(ResponseCode.CFG_INVALID_ACADEMIC_ID, HttpStatus.NOT_FOUND));
		
		TimeTableGenerationDataResponseDTO ttResponseDto= new TimeTableGenerationDataResponseDTO();
//		//get courses based on academicId
		List<Course> courses=new ArrayList<Course>();
		courses=courseRepository.findAllByAcademicId(academicId);
		
		//get faculties based on courseid
		List<Faculty> faculties= new ArrayList<Faculty>();
		courses.forEach((course)->{
			Faculty faculty=facultyRepository.findByCourseId(course.getCourseId());
			faculties.add(faculty);
		});
		
		//get rooms- all the data for rooms
		List<Room> rooms=roomRepository.findAll();
		
		//set in ttResponseDto
		ttResponseDto.setCourses(courses);
		ttResponseDto.setAcademicDetails(academic);
		ttResponseDto.setFaculties(faculties);
		ttResponseDto.setRooms(rooms);
		return ttResponseDto;
	}
	
	/*
	 * Returns a specific Academic Details
	 */
	public AcademicDetails getById(Integer academicId){
		//Validating id  from ACADEMIC_DETAILS table
		AcademicDetails academic = academicDetailsRepository.findById(academicId)
				.orElseThrow(() -> new BusinessException(ResponseCode.CFG_INVALID_ACADEMIC_ID, HttpStatus.NOT_FOUND));
		return academic;
	}
	
	/*
	 * Returns all records of Academic Details
	 */
	public List<AcademicDetails> getAll(){
		List<AcademicDetails> allAcademics = academicDetailsRepository.findAll();
		Validations.isEmpty(allAcademics);
		return allAcademics;
	}

}
