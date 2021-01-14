package com.platform.salus.config;

import org.springframework.http.ResponseEntity;

import java.util.List;

public class Base {

	public final static String OK = "OK";

    public ResponseEntity ok(Object obj){
        return ResponseEntity.ok(obj);
    }

    public ResponseEntity ok(List<?> obj){
        return ResponseEntity.ok(obj);
    }

    public ResponseEntity error(){
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity error(String message){
        return ResponseEntity.badRequest().body(message);
    }
    public ResponseEntity error(Object obj){
        return  ResponseEntity.badRequest().body(obj);
    }

}
