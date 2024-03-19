package com.tatva.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatva.entities.Program;
import com.tatva.service.ProgramService;

import jakarta.transaction.Transactional;

@RestController
@Transactional(rollbackOn=Exception.class)
@RequestMapping("/program")
@Validated
public class ProgramController {
////			program
//			=> GET BY ID
//			=> GET ALL
	
	private final ProgramService programService;
	@Autowired
	public ProgramController(ProgramService programService) {
		super();
		this.programService = programService;
	}
	
	@GetMapping("/{programId}")
	//@ApiOperation(value = "Get program by program-id")
	public ResponseEntity<Program> getById(@PathVariable("programId") 
	Integer programId){
		return ResponseEntity.ok(programService.getById(programId)); 
	}
	
	@GetMapping
	//@ApiOperation(value = "Get  all records of programs")
	public ResponseEntity<List<Program>> getAll(){
		return ResponseEntity.ok(programService.getAll()); 
	}

}
