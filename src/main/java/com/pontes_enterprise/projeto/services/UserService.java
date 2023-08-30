package com.pontes_enterprise.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pontes_enterprise.projeto.domain.User;
import com.pontes_enterprise.projeto.repository.UserRepository;
import com.pontes_enterprise.projeto.services.exception.ObjectNotFoundException;

import dto.UserDTO;

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

    public User insert(User obj){
        return repository.insert(obj);//Ja esta implementado pelo MongoRepository
    } 

    //De UserDTo para user
    public User fromUserDTO(UserDTO obj){
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User update(User obj){//Dados que vao usar como requisicao
        //Vamos procurar o objeto na base de dados, e dps com os dados metidos, atualizamos
        User newObj = repository.findById(obj.getId()).orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
        updateData(newObj, obj);//Copia os dados do obj ao newObj
        return repository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }
}
