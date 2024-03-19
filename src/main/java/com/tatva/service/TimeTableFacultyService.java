package com.tatva.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tatva.entities.TimeTableFaculty;
import com.tatva.exceptionhandling.BusinessException;
import com.tatva.repositories.TimeTableFacultyRepository;
import com.tatva.utils.ResponseCode;
import com.tatva.utils.Validations;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TimeTableFacultyService {
	private final TimeTableFacultyRepository timeTableFacultyRepository;
	
	/*
	 * Returns a specific timeTableFaculty based on timeTableFaculty id
	 */
	public TimeTableFaculty getById(Integer timeTableFacultyId){
		TimeTableFaculty timeTableFaculty = timeTableFacultyRepository.findById(timeTableFacultyId)
				.orElseThrow(() -> new BusinessException(ResponseCode.CFG_INVALID_TIME_TABLE_FACULTY_ID, HttpStatus.NOT_FOUND));
		return timeTableFaculty;
	}
	
	/*
	 * Returns a specific timeTableFaculty based on courseId
	 */
	public List<TimeTableFaculty> getByCourseId(Integer courseId){
		List<TimeTableFaculty> allTimeTableFaculty = timeTableFacultyRepository.findAllByCourseId(courseId);
		Validations.isEmpty(allTimeTableFaculty);
		return allTimeTableFaculty;
	}
	
	/*
	 * Returns a specific timeTableFaculty based on facultyId
	 */
	public List<TimeTableFaculty> getByFacultyId(Integer facultyId){
		List<TimeTableFaculty> allTimeTableFaculty = timeTableFacultyRepository.findAllByFacultyId(facultyId);
		Validations.isEmpty(allTimeTableFaculty);
		return allTimeTableFaculty;
	}
	
	/*
	 * Returns a specific timeTableFaculty based on roomId
	 */
	public List<TimeTableFaculty> getByRoomId(Integer roomId){
		List<TimeTableFaculty> allTimeTableFaculty = timeTableFacultyRepository.findAllByRoomId(roomId);
		Validations.isEmpty(allTimeTableFaculty);
		return allTimeTableFaculty;
	}
	
	
	/*
	 * Returns all records of timeTableFaculty
	 */
	public List<TimeTableFaculty> getAll(){
		List<TimeTableFaculty> allTimeTableFaculty = timeTableFacultyRepository.findAll();
		Validations.isEmpty(allTimeTableFaculty);
		return allTimeTableFaculty;
	}

}
