package com.pontes_enterprise.projeto.resources;
//O pacote chama se recurso,já que é o termo que usamos para referenciar os recursos REST 


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.pontes_enterprise.projeto.domain.User;
import com.pontes_enterprise.projeto.services.UserService;


@RestController//Estes controladores vao nos disponibilizar os endpoints para nós
@RequestMapping(value = "/users")//Caminho para fazermos o request dos usuarios
public class UserResource {
    
    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)//Para saber o metodo,como pedimos informacao é o metodo GET do http, ou basta fazer getmapping
    public ResponseEntity<List<User>> findAll(){//Só para testar
        //Ao em vez de instanciar objetos, vamos buscar na base de dados mongoDB
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);//Qual vai ser o copro da resposta, vai ser o list
    }
}
