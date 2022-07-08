package com.example.finalspringfx.MongoRepositorys;

import com.example.finalspringfx.Models.Fahrt;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


@org.springframework.stereotype.Repository
public interface FahrtenRepository extends MongoRepository<Fahrt, Integer> {
        @Override
        List<Fahrt> findAll();

        List<Fahrt> findFahrtsByUser_Username(String username);

}
