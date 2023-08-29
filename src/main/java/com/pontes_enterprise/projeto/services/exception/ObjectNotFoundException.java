package com.pontes_enterprise.projeto.services.exception;

//Uma excecao que o compilador nao exige que eu a trate
public class ObjectNotFoundException extends RuntimeException{
    
    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
