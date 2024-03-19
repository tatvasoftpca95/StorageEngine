package com.tatva.entities;

import java.time.LocalDate;
import java.time.LocalTime;
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
@Entity(name = "ACADEMIC_DETAILS")
//@JsonIgnoreProperties({"courses"})
public class AcademicDetails {
	//academic year - id, name, start date, duration in months, end date
	//( will be calculated based on start date and duration)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "ACADEMIC_ID",  nullable = false)
	private Integer academicId;
	
	@Column(name = "ACADEMIC_NAME")
	private String academicName;
	
	@OneToMany(mappedBy ="academicDetails", cascade = CascadeType.ALL)
	private List<Course> courses;
	
	@Column(name = "START_DATE")
	private LocalDate startDate;
	
	@Column(name = "DURATION_MONTH")
	private Integer durationMonth;
	
	@Column(name = "END_DATE")
	private LocalDate endDate;

}
