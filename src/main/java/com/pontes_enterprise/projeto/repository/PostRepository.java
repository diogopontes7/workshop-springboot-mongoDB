package com.pontes_enterprise.projeto.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pontes_enterprise.projeto.domain.Post;


public interface PostRepository extends MongoRepository<Post, String>{
    //Consulta simples com @Query
    //https://www.mongodb.com/docs/manual/reference/operator/query/regex
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);
    //o ?0 é o primeiro parametro da funcao

    //Pelo o nome do metodo, o spring data consegue fazer a consulta desejada, querry methods
    List<Post> findByTitleContainingIgnoreCase(String title);//Jaa faz que o spring data faça pra nós a consulta

    @Query("{ $and: [ { date: { $gte: ?1 } }, { date: { $lte: ?2 } }, { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
//VAi ser capazr de apagar, adicionar e isso tudo so por ser subclasse do MongoRepository
