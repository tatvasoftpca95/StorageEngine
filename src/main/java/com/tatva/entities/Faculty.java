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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Entity(name = "FACULTY")
//@JsonIgnoreProperties({"schedules", "timeTableFaculties"})
@JsonIgnoreProperties({"course"})
public class Faculty {
	//faculty - id, name, courseId, facultyType(lecturer, teaching assistant), courseId(manytoone)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "FACULTY_ID", nullable = false)
	private Integer facultyId;
	
	@Column(name = "FACULTY_NAME")
	private String facultyName;
	
	@Column(name = "FACULTY_TYPE")
	private String facultyType;
	
	@ManyToOne
	@JoinColumn(name="COURSE_ID")
	private Course course;
	
	@OneToMany(mappedBy ="faculty", cascade = CascadeType.ALL)
	private List<TimeTableFaculty> timeTableFaculties;

}
