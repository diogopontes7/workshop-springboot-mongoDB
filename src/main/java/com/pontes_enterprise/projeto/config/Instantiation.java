package com.pontes_enterprise.projeto.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pontes_enterprise.projeto.domain.Post;
import com.pontes_enterprise.projeto.domain.User;
import com.pontes_enterprise.projeto.repository.PostRepository;
import com.pontes_enterprise.projeto.repository.UserRepository;

import dto.AuthorDTO;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    //Contratos desta interface
    @Override
    public void run(String... args) throws Exception {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        userRepository.deleteAll();//apaga tudo no repositorio
        postRepository.deleteAll();

        //Instancia os objetos
        User lm10 = new User(null, "Lionel Messi", "lapulga@gmail.com");
        User r9 = new User(null, "Ronaldo Nazario", "fenomeno@gmail.com");
        User cr7 = new User(null, "Cristiano Ronaldo", "obicho@gmail.com");
        //Vamos salvar os usuarios e dps fazemos a copia pelo AuthorDTO
        userRepository.saveAll(Arrays.asList(lm10,r9,cr7));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "O Ronaldo é o Goat", "O gajo é o melhor marcador de todos os tempos", new AuthorDTO(lm10));
        Post post2 = new Post(null, sdf.parse("21/03/2018"), "Eu sou o goat", "Eu sou o melhor marcador de todos os tempos", new AuthorDTO(cr7));

        //Guarda todos outra vez
        postRepository.saveAll(Arrays.asList(post1,post2));
    }
    
}
