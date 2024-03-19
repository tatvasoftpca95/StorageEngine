package com.tatva.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatva.entities.YearType;
import com.tatva.service.YearTypeService;

import jakarta.transaction.Transactional;

@RestController
@Transactional(rollbackOn=Exception.class)
@RequestMapping("/year-type")
@Validated
public class YearTypeController {
	//3. getAllYearTypes will return List<YearType>
		private final YearTypeService yearTypeService;
		@Autowired
		public YearTypeController(YearTypeService yearTypeService) {
			super();
			this.yearTypeService = yearTypeService;
		}
		
		@GetMapping
		//@ApiOperation(value = "Get  all records of year type")
		public ResponseEntity<List<YearType>> getAll(){
			return ResponseEntity.ok(yearTypeService.getAll()); 
		}

}
