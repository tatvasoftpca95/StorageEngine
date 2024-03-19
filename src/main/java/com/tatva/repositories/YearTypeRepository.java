package com.tatva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tatva.entities.YearType;


@Repository
public interface YearTypeRepository  extends JpaRepository<YearType, Integer>{

}
