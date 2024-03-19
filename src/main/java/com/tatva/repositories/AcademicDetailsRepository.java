package com.tatva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tatva.entities.AcademicDetails;


@Repository
public interface AcademicDetailsRepository extends JpaRepository<AcademicDetails, Integer>{

}
