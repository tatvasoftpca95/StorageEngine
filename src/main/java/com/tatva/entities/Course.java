package com.tatva.entities;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "COURSE")
@JsonIgnoreProperties({"academicDetails","yearType","semester","program"})
public class Course {
	//course - id, name, code, academicId, yearTypeId(MAnytoOne), semesterId(manytoone), programId(manytoone), 
	//creditHours, type(lab,lecture)
	//course - id, name, code, academicId, yearTypeId(MAnytoOne), semesterId(manytoone), programId(manytoone),
	//ListOfFaculties(onetomany) creditHours, type(lab,lecture)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "COURSE_ID", nullable = false)
	private Integer courseId;
	
	@Column(name = "COURSE_CODE")
	private String courseCode;
	
	@Column(name = "COURSE_NAME")
	private String courseName;

	@ManyToOne
	@JoinColumn(name="ACADEMIC_ID")
	private AcademicDetails academicDetails;
	
	@ManyToOne
	@JoinColumn(name="YEAR_TYPE_ID")
	private YearType yearType;
	
	@ManyToOne
	@JoinColumn(name="SEMESTER_ID")
	private Semester semester;
	
	@ManyToOne
	@JoinColumn(name="PROGRAM_ID")
	private Program program;
	
//	@OneToMany(mappedBy ="course", cascade = CascadeType.ALL)
//	private List<Faculty> faculties;
	
	@ManyToMany
	@JoinTable(
			name = "COURSE_FACULTY",
			joinColumns = @JoinColumn(name="COURSE_ID"),
			inverseJoinColumns = @JoinColumn(name="FACULTY_ID"))
	private List<Faculty> faculties;
	
	@Column(name = "CREDIT_HOURS")
	private Integer creditHours;
	
	
	@Column(name = "TYPE")
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "ROOM_ID")
	private Room room;
	
	

}
