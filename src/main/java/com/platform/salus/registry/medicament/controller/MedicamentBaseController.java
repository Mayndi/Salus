package com.platform.salus.registry.medicament.controller;

import com.platform.salus.common.controller.BaseController;
import com.platform.salus.registry.medicament.converter.output.MedicamentCountOutput;
import com.platform.salus.registry.medicament.converter.output.MedicamentOutput;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class MedicamentBaseController extends BaseController {

    public ResponseEntity<List<MedicamentOutput>> ok(List<MedicamentOutput> obj){
        return ResponseEntity.ok(obj);
    }
    public ResponseEntity<List<MedicamentOutput>> error(List<MedicamentOutput> obj){
        return ResponseEntity.badRequest().body(obj);
    }

    public ResponseEntity<MedicamentOutput> ok(MedicamentOutput obj){
        return ResponseEntity.ok(obj);
    }
    public ResponseEntity<MedicamentOutput> error(MedicamentOutput obj){
        return ResponseEntity.badRequest().body(obj);
    }

    public ResponseEntity<MedicamentCountOutput> ok(MedicamentCountOutput obj){
        return ResponseEntity.ok(obj);
    }
    public ResponseEntity<MedicamentCountOutput> error(MedicamentCountOutput obj){
        return ResponseEntity.badRequest().body(obj);
    }
}