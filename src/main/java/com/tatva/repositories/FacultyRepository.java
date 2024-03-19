package com.tatva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tatva.entities.Faculty;
@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer>{
	@Query(value="SELECT * FROM FACULTY WHERE COURSE_ID = :courseId",nativeQuery=true)
	Faculty findByCourseId(Integer courseId);

}
