package com.tatva.entities;

import java.time.LocalTime;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Entity(name = "TIMETABLE_FACULTY")
@JsonIgnoreProperties({"faculty"})
public class TimeTableFaculty {
	//timetable_faculty - id, facultyId, day, start time, end time, courseId , roomId
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "TIMETABLE_FACULTY_ID", nullable = false)
	private Integer timeTableFacultyId;
	
	@ManyToOne
	@JoinColumn(name="FACULTY_ID")
	private Faculty faculty;
	
	@Column(name = "DAY")
	private String day;
	
	@Column(name = "START_TIME")
	private LocalTime startTime;
	
	@Column(name = "END_TIME")
	private LocalTime endTime;
	
	@Column(name = "COURSE_ID")
	private Integer courseId;
	
	@Column(name = "ROOM_ID")
	private Integer roomId;
//	@OneToMany(mappedBy ="timeTableFaculty", cascade = CascadeType.ALL)
//	private List<Room> rooms;

}
