package com.tatva.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tatva.entities.Faculty;
import com.tatva.entities.Room;
import com.tatva.exceptionhandling.BusinessException;
import com.tatva.repositories.FacultyRepository;
import com.tatva.repositories.RoomRepository;
import com.tatva.response.FacultiesAndRoomsResponseDto;
import com.tatva.utils.ResponseCode;
import com.tatva.utils.Validations;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FacultyService {
	private final FacultyRepository facultyRepository;
	private final RoomRepository roomRepository;
	
	/*
	 * Returns a specific faculty based on courseId
	 */
	public Faculty getByCourseId(Integer courseId){
		Faculty faculty = facultyRepository.findByCourseId(courseId);
		if (faculty==null) {
			throw new BusinessException(ResponseCode.CFG_INVALID_COURSE_ID, HttpStatus.NOT_FOUND);
		}
		return faculty;
	}
	
	/*
	 * Returns a specific faculty based on faculty id
	 */
	public Faculty getById(Integer facultyId){
		Faculty faculty = facultyRepository.findById(facultyId)
				.orElseThrow(() -> new BusinessException(ResponseCode.CFG_INVALID_FACULTY_ID, HttpStatus.NOT_FOUND));
		return faculty;
	}
	
	/*
	 * Returns all records of Faculties
	 */
	public List<Faculty> getAll(){
		List<Faculty> allFaculties = facultyRepository.findAll();
		Validations.isEmpty(allFaculties);
		return allFaculties;
	}
	
	
	/*
	 * Returns FacultiesAndRoomsResponseDto
	 */
	public FacultiesAndRoomsResponseDto getFacultiesAndRooms(){
		
		FacultiesAndRoomsResponseDto responseDto= new FacultiesAndRoomsResponseDto();
		
		//get faculties based on courseid
		List<Faculty> faculties= new ArrayList<Faculty>();
		faculties= facultyRepository.findAll();
		Validations.isEmpty(faculties);
		
		//get rooms- all the data for rooms
		List<Room> rooms=roomRepository.findAll();
		
		//set in responseDto
		responseDto.setFaculties(faculties);
		responseDto.setRooms(rooms);
		return responseDto;
	}

}
