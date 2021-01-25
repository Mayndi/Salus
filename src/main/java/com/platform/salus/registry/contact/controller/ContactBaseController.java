package com.platform.salus.registry.contact.controller;

import com.platform.salus.common.controller.BaseController;
import com.platform.salus.registry.contact.converter.output.ContactCountOutput;
import com.platform.salus.registry.contact.converter.output.ContactOutput;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ContactBaseController extends BaseController {

    public ResponseEntity<List<ContactOutput>> ok(List<ContactOutput> obj){
        return ResponseEntity.ok(obj);
    }
    public ResponseEntity<List<ContactOutput>> error(List<ContactOutput> obj){
        return ResponseEntity.badRequest().body(obj);
    }

    public ResponseEntity<ContactOutput> ok(ContactOutput obj){
        return ResponseEntity.ok(obj);
    }
    public ResponseEntity<ContactOutput> error(ContactOutput obj){
        return ResponseEntity.badRequest().body(obj);
    }

    public ResponseEntity<ContactCountOutput> ok(ContactCountOutput obj){
        return ResponseEntity.ok(obj);
    }
    public ResponseEntity<ContactCountOutput> error(ContactCountOutput obj){ return ResponseEntity.badRequest().body(obj);
    }
}