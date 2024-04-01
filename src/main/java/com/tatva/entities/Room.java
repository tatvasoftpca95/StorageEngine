package com.tatva.entities;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity(name = "ROOM")
@JsonIgnoreProperties({"courses"})
public class Room {
	//room_details - id, floor, room_no
	//room - id, floor, roomNo, roomType(Classroom, Lab)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "ROOM_ID", nullable = false)
	private Integer roomId;
	
	@Column(name = "FLOOR")
	private String floor;
	
	@Column(name = "ROOM_NO")
	private String roomNo;
	
	@Column(name = "ROOM_TYPE")
	private String roomType;
	
//	@ManyToOne
//	@JoinColumn(name="TIMETABLE_FACULTY_ID")
//	private TimeTableFaculty timeTableFaculty;

}
