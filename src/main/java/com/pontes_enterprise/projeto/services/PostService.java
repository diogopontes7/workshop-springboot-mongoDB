package com.pontes_enterprise.projeto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pontes_enterprise.projeto.domain.Post;
import com.pontes_enterprise.projeto.repository.PostRepository;
import com.pontes_enterprise.projeto.services.exception.ObjectNotFoundException;

public class PostService {
    
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("O post não foi encontrado"));//Parametros->expressao
    }

    public List<Post> findByTitle(String text){
        return postRepository.findByTitleContainingIgnoreCase(text);
    }
}
