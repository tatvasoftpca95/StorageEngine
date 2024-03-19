package com.tatva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tatva.entities.Program;
@Repository
public interface ProgramRepository extends JpaRepository<Program, Integer>{

}
