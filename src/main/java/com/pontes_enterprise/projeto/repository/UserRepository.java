package com.pontes_enterprise.projeto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.pontes_enterprise.projeto.domain.User;


public interface UserRepository extends MongoRepository<User, String>{
    
}
//VAi ser capazr de apagar, adicionar e isso tudo so por ser subclasse do MongoRepository
