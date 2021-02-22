package com.platform.salus.registryUser.medic.controller;

import com.platform.salus.common.controller.BaseController;
import com.platform.salus.registryUser.medic.converter.output.MedicCountOutput;
import com.platform.salus.registryUser.medic.converter.output.MedicOutput;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class MedicBaseController extends BaseController {

    public ResponseEntity<List<MedicOutput>> ok(List<MedicOutput> obj){
        return ResponseEntity.ok(obj);
    }
    public ResponseEntity<List<MedicOutput>> error(List<MedicOutput> obj){
        return ResponseEntity.badRequest().body(obj);
    }

    public ResponseEntity<MedicOutput> ok(MedicOutput obj){
        return ResponseEntity.ok(obj);
    }
    public ResponseEntity<MedicOutput> error(MedicOutput obj){
        return ResponseEntity.badRequest().body(obj);
    }

    public ResponseEntity<MedicCountOutput> ok(MedicCountOutput obj){
        return ResponseEntity.ok(obj);
    }
    public ResponseEntity<MedicCountOutput> error(MedicCountOutput obj){ return ResponseEntity.badRequest().body(obj); }
}