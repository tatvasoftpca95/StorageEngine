package com.tatva.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatva.entities.Room;
import com.tatva.service.RoomService;

import jakarta.transaction.Transactional;

@RestController
@Transactional(rollbackOn=Exception.class)
@RequestMapping("/room")
@Validated
public class RoomController {
////			room
//			=> GET BY ID
//			=> GET ALL
	
	private final RoomService roomService;
	@Autowired
	public RoomController(RoomService roomService) {
		super();
		this.roomService = roomService;
	}
	
	@GetMapping("/{roomId}")
	//@ApiOperation(value = "Get room by room-id")
	public ResponseEntity<Room> getById(@PathVariable("roomId") 
	Integer roomId){
		return ResponseEntity.ok(roomService.getById(roomId)); 
	}
	
	@GetMapping
	//@ApiOperation(value = "Get  all records of rooms")
	public ResponseEntity<List<Room>> getAll(){
		return ResponseEntity.ok(roomService.getAll()); 
	}

}
