package com.platform.salus.registryHospital.information.controller;

import com.platform.salus.common.exceptions.InvalidInformationException;
import com.platform.salus.common.exceptions.InvalidPageRequestException;
import com.platform.salus.registryHospital.information.converter.HospitalConverter;
import com.platform.salus.registryHospital.information.converter.input.HospitalInput;
import com.platform.salus.registryHospital.information.converter.output.HospitalCountOutput;
import com.platform.salus.registryHospital.information.converter.output.HospitalOutput;
import com.platform.salus.registryHospital.information.model.HospitalEntity;
import com.platform.salus.registryHospital.information.service.HospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/hospital/hospital")
public class HospitalController extends HospitalBaseController {

    private final HospitalService hospitalService;
    private final HospitalConverter hospitalConverter;

    public HospitalController(HospitalService hospitalService, HospitalConverter hospitalConverter) {
        this.hospitalService = hospitalService;
        this.hospitalConverter = hospitalConverter;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<HospitalOutput> create(@RequestBody HospitalInput hospital) {

        try {
            HospitalEntity hospitalEntity = hospitalService.create(this.hospitalConverter.inputToEntity(hospital));

            return ok(this.hospitalConverter.entityToOutput(hospitalEntity));
        } catch (InvalidInformationException ex) {
            return error((HospitalOutput) new HospitalOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<HospitalOutput> update(@PathVariable Long id, @RequestBody HospitalInput hospital) {

        try {
            HospitalEntity hospitalEntity = hospitalService.update(id, this.hospitalConverter.inputToEntity(hospital));

            return ok(this.hospitalConverter.entityToOutput(hospitalEntity));
        } catch (InvalidInformationException ex) {
            return error((HospitalOutput) new HospitalOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<HospitalOutput> findById(@PathVariable Long id) {

        try {
            HospitalEntity hospitalEntity = hospitalService.findById(id);

            return ok(this.hospitalConverter.entityToOutput(hospitalEntity));
        } catch (InvalidInformationException ex) {
            return error((HospitalOutput) new HospitalOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @GetMapping(value = "/list/{page}/{count}")
    public ResponseEntity<List<HospitalOutput>> list(@PathVariable Long page, @PathVariable Long count) {

        try {
            hospitalConverter.checkPageInfo(page, count);
            List<HospitalEntity> hospitals = hospitalService.list(page, count);

            return ok(hospitals.stream()
                    .map(this.hospitalConverter::entityToOutput)
                    .collect(Collectors.toList()));
        } catch (InvalidPageRequestException ex) {
            return error(Collections.singletonList((HospitalOutput) new HospitalOutput().setErrorMessage(ex.getMessage())));
        }
    }

    @GetMapping(value = "/count")
    public ResponseEntity<HospitalCountOutput> count() {

        try {
            Long count = hospitalService.count();

            return ok(new HospitalCountOutput().setCount(count));
        } catch (Exception ex){
            return error((HospitalCountOutput) new HospitalCountOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<HospitalOutput> delete(@PathVariable Long id) {

        try {
            HospitalEntity hospitalEntity = hospitalService.delete(id);

            return ok((HospitalOutput) new HospitalOutput().setSuccessMessage(""));
        } catch (InvalidInformationException ex) {
            return error((HospitalOutput) new HospitalOutput().setErrorMessage(ex.getMessage()));
        }
    }
}
