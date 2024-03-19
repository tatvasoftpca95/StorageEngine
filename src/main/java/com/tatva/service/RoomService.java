package com.tatva.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tatva.entities.Room;
import com.tatva.exceptionhandling.BusinessException;
import com.tatva.repositories.RoomRepository;
import com.tatva.utils.ResponseCode;
import com.tatva.utils.Validations;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomService {
	private final RoomRepository roomRepository;
	
	/*
	 * Returns a specific room based on room id
	 */
	public Room getById(Integer roomId){
		Room room = roomRepository.findById(roomId)
				.orElseThrow(() -> new BusinessException(ResponseCode.CFG_INVALID_ROOM_ID, HttpStatus.NOT_FOUND));
		return room;
	}
	
	/*
	 * Returns all records of rooms
	 */
	public List<Room> getAll(){
		List<Room> allFaculties = roomRepository.findAll();
		Validations.isEmpty(allFaculties);
		return allFaculties;
	}

}
