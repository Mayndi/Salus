package com.platform.salus.registryHospital.information.controller;

import com.platform.salus.common.controller.BaseController;
import com.platform.salus.registryHospital.information.converter.output.HospitalCountOutput;
import com.platform.salus.registryHospital.information.converter.output.HospitalOutput;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class HospitalBaseController extends BaseController {

    public ResponseEntity<List<HospitalOutput>> ok(List<HospitalOutput> obj){
        return ResponseEntity.ok(obj);
    }
    public ResponseEntity<List<HospitalOutput>> error(List<HospitalOutput> obj){
        return ResponseEntity.badRequest().body(obj);
    }

    public ResponseEntity<HospitalOutput> ok(HospitalOutput obj){
        return ResponseEntity.ok(obj);
    }
    public ResponseEntity<HospitalOutput> error(HospitalOutput obj){
        return ResponseEntity.badRequest().body(obj);
    }

    public ResponseEntity<HospitalCountOutput> ok(HospitalCountOutput obj){
        return ResponseEntity.ok(obj);
    }
    public ResponseEntity<HospitalCountOutput> error(HospitalCountOutput obj){ return ResponseEntity.badRequest().body(obj);
    }
}