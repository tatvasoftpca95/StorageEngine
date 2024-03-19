package com.tatva.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.tatva.entities.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

	@Query(value="SELECT * FROM COURSE WHERE ACADEMIC_ID = :academicId",nativeQuery=true)
	List<Course> findAllByAcademicId(Integer academicId);

	@Query(value="SELECT * FROM COURSE WHERE ACADEMIC_ID = :academicId and YEAR_TYPE_ID= :yearTypeId "
			+ "and SEMESTER_ID= :semesterId and PROGRAM_ID= :programId",nativeQuery=true)
	List<Course> findAllByAcademicIdAndYearTypeIdAndSemesterIdAndProgramId(
			Integer academicId, Integer yearTypeId,
			Integer semesterId, Integer programId);



}
