package com.pontes_enterprise.projeto.resources;
//O pacote chama se recurso,já que é o termo que usamos para referenciar os recursos REST 


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pontes_enterprise.projeto.domain.Post;
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

    @RequestMapping( method = RequestMethod.POST)//Para saber o metodo,como pedimos informacao é o metodo GET do http, ou basta fazer getmapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){//Só para testar
        User user = service.fromUserDTO(objDto);
        user = service.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();//Vamos retornar um cabecalho uri do recurso crado
        return ResponseEntity.created(uri).build();//Retorna o codigo 201 quando criamos um novo recurso, retorna uma resposta vazia 201 com o cabecalho com a localizacao do recurso criado
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)//Para saber o metodo,como pedimos informacao é o metodo GET do http, ou basta fazer getmapping
    public ResponseEntity<Void> delete(@PathVariable String id){//Só para testar
        service.delete(id);
        return ResponseEntity.noContent().build();//Para delete
    }

     @RequestMapping(value = "/{id}" ,  method = RequestMethod.PUT)//Para saber o metodo,como pedimos informacao é o metodo GET do http, ou basta fazer getmapping
    public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id){//Só para testar
        User user = service.fromUserDTO(objDto);
        user.setId(id);//O userDTO vai ser o user com o id especificado
        user = service.update(user);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findPostByUserId(@PathVariable String id){
        User user = service.findById(id);
        return ResponseEntity.ok().body(user.getPosts());//Vai obter atraves do id a lista de posts associados a ele
    }
}
