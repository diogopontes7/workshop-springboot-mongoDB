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
import dto.CommentDTO;

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

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Eu sou o goat", "Ganhei a copa", new AuthorDTO(lm10));
        Post post2 = new Post(null, sdf.parse("21/03/2018"), "Eu sou o goat", "Eu sou o melhor marcador de todos os tempos", new AuthorDTO(cr7));

        CommentDTO c1 = new CommentDTO("Mas tu não tens copa Crisitiano", sdf.parse("27/02/2023"), new AuthorDTO(lm10));
        CommentDTO c2 = new CommentDTO("Não tenho pq a minha seleçao joga mal", sdf.parse("27/02/2023"), new AuthorDTO(cr7));
        CommentDTO c3 = new CommentDTO("Oh Messi a tua copa tmb foi só com penaltis, eu joguei muito na minha copa", sdf.parse("27/02/2023"), new AuthorDTO(r9));

        post1.getComments().addAll(Arrays.asList(c3));
        post2.getComments().addAll(Arrays.asList(c1,c2));

        //Guarda todos outra vez
        postRepository.saveAll(Arrays.asList(post1,post2));

        lm10.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(lm10);
    }
    
}
