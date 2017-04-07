package com.docker.example.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.docker.example.dao.User;


public interface UserRepository extends MongoRepository<User, String> {

}