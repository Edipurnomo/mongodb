package com.tugas5.edyp.repository;

import com.tugas5.edyp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String>{
  Optional <User> findById(String id);
    User findByUsername(String username);


    User deleteByid(String id);

}


