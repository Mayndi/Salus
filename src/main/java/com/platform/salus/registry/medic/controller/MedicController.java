package com.platform.salus.registry.medic.controller;

import com.platform.salus.common.exceptions.InvalidInformationException;
import com.platform.salus.common.exceptions.InvalidPageRequestException;
import com.platform.salus.registry.medic.converter.MedicConverter;
import com.platform.salus.registry.medic.converter.input.MedicInput;
import com.platform.salus.registry.medic.converter.output.MedicCountOutput;
import com.platform.salus.registry.medic.converter.output.MedicOutput;
import com.platform.salus.registry.medic.model.MedicEntity;
import com.platform.salus.registry.medic.service.MedicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medic")
public class MedicController extends MedicBaseController {

    private final MedicService medicService;
    private final MedicConverter medicConverter;

    public MedicController(MedicService medicService, MedicConverter medicConverter) {
        this.medicService = medicService;
        this.medicConverter = medicConverter;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<MedicOutput> create(@RequestBody MedicInput medic) {

        try {
            MedicEntity medicEntity = medicService.create(this.medicConverter.inputToEntity(medic));

            return ok(this.medicConverter.entityToOutput(medicEntity));
        } catch (InvalidInformationException ex) {
            return error((MedicOutput) new MedicOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<MedicOutput> update(@PathVariable Long id, @RequestBody MedicInput medic) {

        try {
            MedicEntity medicEntity = medicService.update(id, this.medicConverter.inputToEntity(medic));

            return ok(this.medicConverter.entityToOutput(medicEntity));
        } catch (InvalidInformationException ex) {
            return error((MedicOutput) new MedicOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<MedicOutput> findById(@PathVariable Long id) {

        try {
            MedicEntity medicEntity = medicService.findById(id);

            return ok(this.medicConverter.entityToOutput(medicEntity));
        } catch (InvalidInformationException ex) {
            return error((MedicOutput) new MedicOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @GetMapping(value = "/list/{page}/{count}")
    public ResponseEntity<List<MedicOutput>> list(@PathVariable Long page, @PathVariable Long count) {

        try {
            medicConverter.checkPageInfo(page, count);
            List<MedicEntity> medics = medicService.list(page, count);

            return ok(medics.stream()
                    .map(this.medicConverter::entityToOutput)
                    .collect(Collectors.toList()));
        } catch (InvalidPageRequestException ex) {
            return error(Collections.singletonList((MedicOutput) new MedicOutput().setErrorMessage(ex.getMessage())));
        }
    }

    @GetMapping(value = "/count")
    public ResponseEntity<MedicCountOutput> count() {

        try {
            Long count = medicService.count();

            return ok(new MedicCountOutput().setCount(count));
        } catch (Exception ex){
            return error((MedicCountOutput) new MedicCountOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<MedicOutput> delete(@PathVariable Long id) {

        try {
            MedicEntity medicEntity = medicService.delete(id);

            return ok((MedicOutput) new MedicOutput().setSuccessMessage(""));
        } catch (InvalidInformationException ex) {
            return error((MedicOutput) new MedicOutput().setErrorMessage(ex.getMessage()));
        }
    }
}
