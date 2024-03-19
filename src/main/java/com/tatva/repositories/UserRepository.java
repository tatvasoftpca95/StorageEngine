package com.tatva.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tatva.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findByEmail(String email);
    
}
