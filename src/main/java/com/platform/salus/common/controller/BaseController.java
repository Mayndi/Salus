package com.platform.salus.common.controller;

import org.springframework.http.ResponseEntity;

public class BaseController {

    public static final String MESSAGE_OK = "OK";

    public ResponseEntity<String> ok(String obj){
        return ResponseEntity.ok(obj);
    }
    public ResponseEntity<String> error(String obj){
        return  ResponseEntity.badRequest().body(obj);
    }
}