package com.tatva.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tatva.entities.AcademicDetails;
import com.tatva.entities.Course;
import com.tatva.entities.Faculty;
import com.tatva.entities.Room;

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
@JsonInclude(Include.NON_DEFAULT)
public class TimeTableGenerationDataResponseDTO {
	//TimeTableGenerationDataResponseDTO -> List<Course>, List<Faculty>, List<Room>
	
	private List<Course> courses;
	
	private AcademicDetails academicDetails;
	
	private List<Faculty> faculties;
	
	private List<Room> rooms;
	

}
