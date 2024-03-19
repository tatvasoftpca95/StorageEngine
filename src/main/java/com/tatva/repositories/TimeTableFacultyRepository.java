package com.tatva.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tatva.entities.TimeTableFaculty;
@Repository
public interface TimeTableFacultyRepository extends JpaRepository<TimeTableFaculty, Integer>{
	@Query(value="SELECT * FROM TIMETABLE_FACULTY WHERE COURSE_ID = :courseId",nativeQuery=true)
	TimeTableFaculty findByCourseId(Integer courseId);
	
	@Query(value="SELECT * FROM TIMETABLE_FACULTY WHERE COURSE_ID = :courseId",nativeQuery=true)
	List<TimeTableFaculty> findAllByCourseId(Integer courseId);
	
	@Query(value="SELECT * FROM TIMETABLE_FACULTY WHERE ROOM_ID = :roomId",nativeQuery=true)
	TimeTableFaculty findByRoomId(Integer roomId);
	
	@Query(value="SELECT * FROM TIMETABLE_FACULTY WHERE ROOM_ID = :roomId",nativeQuery=true)
	List<TimeTableFaculty> findAllByRoomId(Integer roomId);
	
	@Query(value="SELECT * FROM TIMETABLE_FACULTY WHERE FACULTY_ID = :facultyId",nativeQuery=true)
	TimeTableFaculty	 findByFacultyId(Integer facultyId);
	
	@Query(value="SELECT * FROM TIMETABLE_FACULTY WHERE FACULTY_ID = :facultyId",nativeQuery=true)
	List<TimeTableFaculty> findAllByFacultyId(Integer facultyId);

}
