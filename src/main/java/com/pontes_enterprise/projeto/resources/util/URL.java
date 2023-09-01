package com.pontes_enterprise.projeto.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
    
    public static String decodeParam(String text){
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
           return "";
        }//Ou retorna o string codificado ou retorna a string vazia
    }
}
