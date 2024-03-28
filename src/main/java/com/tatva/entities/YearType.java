package com.tatva.entities;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "YEAR_TYPE")
@JsonIgnoreProperties({"courses","semesters","programs"})
public class YearType {
	//year_type (1st, 2nd, 3rd, 4th, 5th) - id, yearNumber(String), ListofCourse(onetomany), 
	//List ofsemester(onetomany), ListofPrograms(onetoMany) 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "YEAR_TYPE_ID", nullable = false)
	private Integer yearTypeId;
	
	@Column(name = "YEAR_NUMBER")
	private String yearNumber;
	
	@OneToMany(mappedBy ="yearType", cascade = CascadeType.ALL)
	private List<Course> courses;
	
	@OneToMany(mappedBy ="yearType", cascade = CascadeType.ALL)
	private List<Semester> semesters;
	
	@OneToMany(mappedBy ="yearType", cascade = CascadeType.ALL)
	private List<Program> programs;
}
