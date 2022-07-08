package com.example.finalspringfx.MongoRepositorys;

import com.example.finalspringfx.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface UserRepository extends MongoRepository<User, Integer> {

    Optional<User> findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
    User findUserByUsernameIs(String username);
    




}
