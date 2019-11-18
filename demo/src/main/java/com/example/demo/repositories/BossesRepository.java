package com.example.demo.repositories;

import com.example.demo.models.Bosses;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BossesRepository extends MongoRepository<Bosses, String> {
  Bosses findBy_id(ObjectId _id);
}