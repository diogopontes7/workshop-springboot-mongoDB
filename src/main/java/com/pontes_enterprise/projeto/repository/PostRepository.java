package com.pontes_enterprise.projeto.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.pontes_enterprise.projeto.domain.Post;


public interface PostRepository extends MongoRepository<Post, String>{
    
    List<Post> findByTitleContainingIgnoreCase(String title);//Jaa faz que o spring data faça pra nós a consulta
}
//VAi ser capazr de apagar, adicionar e isso tudo so por ser subclasse do MongoRepository
