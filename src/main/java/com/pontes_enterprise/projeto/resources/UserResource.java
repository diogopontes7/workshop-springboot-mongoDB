package com.pontes_enterprise.projeto.resources;
//O pacote chama se recurso,já que é o termo que usamos para referenciar os recursos REST 


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.pontes_enterprise.projeto.domain.User;
import com.pontes_enterprise.projeto.services.UserService;

import dto.UserDTO;


@RestController//Estes controladores vao nos disponibilizar os endpoints para nós
@RequestMapping(value = "/users")//Caminho para fazermos o request dos usuarios
public class UserResource {
    
    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)//Para saber o metodo,como pedimos informacao é o metodo GET do http, ou basta fazer getmapping
    public ResponseEntity<List<UserDTO>> findAll(){//Só para testar
        //Ao em vez de instanciar objetos, vamos buscar na base de dados mongoDB
        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());//Instancia qualquer x para userDTO
        return ResponseEntity.ok().body(listDTO);//Qual vai ser o copro da resposta, vai ser o list
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)//Para saber o metodo,como pedimos informacao é o metodo GET do http, ou basta fazer getmapping
    public ResponseEntity<UserDTO> findById(@PathVariable String id){//Só para testar
        User user = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));//Qual vai ser o copro da resposta, vai ser o usuario
    }

}
