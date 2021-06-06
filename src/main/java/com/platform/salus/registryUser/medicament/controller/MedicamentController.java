package com.platform.salus.registryUser.medicament.controller;

import com.platform.salus.common.exceptions.InvalidInformationException;
import com.platform.salus.common.exceptions.InvalidPageRequestException;
import com.platform.salus.registryUser.medicament.converter.MedicamentConverter;
import com.platform.salus.registryUser.medicament.converter.input.MedicamentInput;
import com.platform.salus.registryUser.medicament.converter.output.MedicamentCountOutput;
import com.platform.salus.registryUser.medicament.converter.output.MedicamentOutput;
import com.platform.salus.registryUser.medicament.model.MedicamentEntity;
import com.platform.salus.registryUser.medicament.service.MedicamentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user/medicament")
public class MedicamentController extends MedicamentBaseController {

    private final MedicamentService medicamentService;
    private final MedicamentConverter medicamentConverter;

    public MedicamentController(MedicamentService medicamentService, MedicamentConverter medicamentConverter) {
        this.medicamentService = medicamentService;
        this.medicamentConverter = medicamentConverter;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<MedicamentOutput> create(@RequestBody MedicamentInput medicament) {

        try {
            MedicamentEntity medicamentEntity = medicamentService.create(this.medicamentConverter.inputToEntity(medicament));

            return ok(this.medicamentConverter.entityToOutput(medicamentEntity));
        } catch (InvalidInformationException ex) {
            return error((MedicamentOutput) new MedicamentOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<MedicamentOutput> update(@PathVariable Long id, @RequestBody MedicamentInput medicament) {

        try {
            MedicamentEntity medicamentEntity = medicamentService.update(id, this.medicamentConverter.inputToUpdateEntity(medicament));

            return ok(this.medicamentConverter.entityToOutput(medicamentEntity));
        } catch (InvalidInformationException ex) {
            return error((MedicamentOutput) new MedicamentOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<MedicamentOutput> findById(@PathVariable Long id) {

        try {
            MedicamentEntity medicamentEntity = medicamentService.findById(id);

            return ok(this.medicamentConverter.entityToOutput(medicamentEntity));
        } catch (InvalidInformationException ex) {
            return error((MedicamentOutput) new MedicamentOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @GetMapping(value = "/list/{page}/{count}")
    public ResponseEntity<List<MedicamentOutput>> list(@PathVariable Long page, @PathVariable Long count) {

        try {
            medicamentConverter.checkPageInfo(page, count);
            List<MedicamentEntity> medicaments = medicamentService.list(page, count);

            return ok(medicaments.stream()
                    .map(this.medicamentConverter::entityToOutput)
                    .collect(Collectors.toList()));
        } catch (InvalidPageRequestException ex) {
            return error(Collections.singletonList((MedicamentOutput) new MedicamentOutput().setErrorMessage(ex.getMessage())));
        }
    }

    @GetMapping(value = "/count")
    public ResponseEntity<MedicamentCountOutput> count() {

        try {
            Long count = medicamentService.count();

            return ok(new MedicamentCountOutput().setCount(count));
        } catch (Exception ex){
            return error((MedicamentCountOutput) new MedicamentCountOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<MedicamentOutput> delete(@PathVariable Long id) {

        try {
            MedicamentEntity medicamentEntity = medicamentService.delete(id);

            return ok((MedicamentOutput) new MedicamentOutput().setSuccessMessage(""));
        } catch (InvalidInformationException ex) {
            return error((MedicamentOutput) new MedicamentOutput().setErrorMessage(ex.getMessage()));
        }
    }
}
