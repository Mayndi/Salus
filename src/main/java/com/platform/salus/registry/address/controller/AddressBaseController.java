package com.platform.salus.registry.address.controller;

import com.platform.salus.common.controller.BaseController;
import com.platform.salus.registry.address.converter.output.AddressCountOutput;
import com.platform.salus.registry.address.converter.output.AddressOutput;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class AddressBaseController extends BaseController {

    public ResponseEntity<List<AddressOutput>> ok(List<AddressOutput> obj){
        return ResponseEntity.ok(obj);
    }
    public ResponseEntity<List<AddressOutput>> error(List<AddressOutput> obj){
        return ResponseEntity.badRequest().body(obj);
    }

    public ResponseEntity<AddressOutput> ok(AddressOutput obj){
        return ResponseEntity.ok(obj);
    }
    public ResponseEntity<AddressOutput> error(AddressOutput obj){
        return ResponseEntity.badRequest().body(obj);
    }

    public ResponseEntity<AddressCountOutput> ok(AddressCountOutput obj){
        return ResponseEntity.ok(obj);
    }
    public ResponseEntity<AddressCountOutput> error(AddressCountOutput obj){
        return ResponseEntity.badRequest().body(obj);
    }
}