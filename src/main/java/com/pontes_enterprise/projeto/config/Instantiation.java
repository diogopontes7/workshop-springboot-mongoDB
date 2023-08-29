package com.pontes_enterprise.projeto.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pontes_enterprise.projeto.domain.User;
import com.pontes_enterprise.projeto.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    //Contratos desta interface
    @Override
    public void run(String... args) throws Exception {
        
        userRepository.deleteAll();//apaga tudo no repositorio


        //Instancia os objetos
        User lm10 = new User(null, "Lionel Messi", "lapulga@gmail.com");
        User r9 = new User(null, "Ronaldo Nazario", "fenomeno@gmail.com");
        User cr7 = new User(null, "Cristiano Ronaldo", "obicho@gmail.com");

        //Guarda todos outra vez
        userRepository.saveAll(Arrays.asList(lm10,r9,cr7));//
    }
    
}
