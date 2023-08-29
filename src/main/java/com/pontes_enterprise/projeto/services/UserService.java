package com.pontes_enterprise.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pontes_enterprise.projeto.domain.User;
import com.pontes_enterprise.projeto.repository.UserRepository;
import com.pontes_enterprise.projeto.services.exception.ObjectNotFoundException;

@Service
public class UserService {


    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    //Optional aceita nulos
    public User findById(String id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));//Se nao encontrar usuario, lanca a excecao
    }
}
