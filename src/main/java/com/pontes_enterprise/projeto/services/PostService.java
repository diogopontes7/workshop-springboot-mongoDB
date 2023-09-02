package com.pontes_enterprise.projeto.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pontes_enterprise.projeto.domain.Post;
import com.pontes_enterprise.projeto.repository.PostRepository;
import com.pontes_enterprise.projeto.services.exception.ObjectNotFoundException;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("O post não foi encontrado"));//Parametros->expressao
    }

    public List<Post> findByTitle(String text){
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime()+ 24 * 60 * 60 * 1000);//Nos queremos o dia maximo um dia depois á meia noite em vez de ser o proprio dia á meia noite, nao sei explicar mas percebi a lógica 
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
