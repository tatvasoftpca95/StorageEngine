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
@Entity(name = "PROGRAM")
@JsonIgnoreProperties({"yearType"})
public class Program {
	//id, name(Btech in CS, BA), year_type_id(manytoone) 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "PROGRAM_ID", nullable = false)
	private Integer programId;
	
	@Column(name = "NAME")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="YEAR_TYPE_ID")
	private YearType yearType;
	
	@OneToMany(mappedBy ="program", cascade = CascadeType.ALL)
	private List<Course> courses;

}
