package com.pontes_enterprise.projeto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pontes_enterprise.projeto.domain.User;
import com.pontes_enterprise.projeto.repository.UserRepository;

@Service
public class UserService {


    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
}
