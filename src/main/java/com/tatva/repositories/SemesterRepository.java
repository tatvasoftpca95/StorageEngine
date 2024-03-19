package com.tatva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tatva.entities.Semester;
@Repository
public interface SemesterRepository extends JpaRepository<Semester, Integer>{

}
