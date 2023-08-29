package com.pontes_enterprise.projeto.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pontes_enterprise.projeto.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice//Vai indicar que esta classe vai ser responsavel por tratar possiveis erros nas minhas requisicoes
public class ResourceExceptionHandler {
    //Boa pratica de tratamento de erro

    //Quando estourar a excecao, vamos devolver um standarError, de acordo com o httpservlet
    @ExceptionHandler(ObjectNotFoundException.class)//Quando ocorre essa excecao, o sistema faz este tratamento
    public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException e, HttpServletRequest req){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandarError err = new StandarError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), req.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
