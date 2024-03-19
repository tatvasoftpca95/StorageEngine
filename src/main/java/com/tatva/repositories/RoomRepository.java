package com.tatva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tatva.entities.Room;
@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{

}
