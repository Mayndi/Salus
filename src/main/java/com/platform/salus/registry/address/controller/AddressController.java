package com.platform.salus.registry.address.controller;

import com.platform.salus.common.exceptions.InvalidInformationException;
import com.platform.salus.common.exceptions.InvalidPageRequestException;
import com.platform.salus.registry.address.converter.AddressConverter;
import com.platform.salus.registry.address.converter.input.AddressInput;
import com.platform.salus.registry.address.converter.output.AddressCountOutput;
import com.platform.salus.registry.address.converter.output.AddressOutput;
import com.platform.salus.registry.address.model.AddressEntity;
import com.platform.salus.registry.address.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
public class AddressController extends AddressBaseController {

    private final AddressService addressService;
    private final AddressConverter addressConverter;

    public AddressController(AddressService addressService, AddressConverter addressConverter) {
        this.addressService = addressService;
        this.addressConverter = addressConverter;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<AddressOutput> create(@RequestBody AddressInput address) {

        try {
            AddressEntity addressEntity = addressService.create(this.addressConverter.inputToEntity(address));

            return ok(this.addressConverter.entityToOutput(addressEntity));
        } catch (InvalidInformationException ex) {
            return error((AddressOutput) new AddressOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<AddressOutput> update(@PathVariable Long id, @RequestBody AddressInput address) {

        try {
            AddressEntity addressEntity = addressService.update(id, this.addressConverter.inputToEntity(address));

            return ok(this.addressConverter.entityToOutput(addressEntity));
        } catch (InvalidInformationException ex) {
            return error((AddressOutput) new AddressOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<AddressOutput> findById(@PathVariable Long id) {

        try {
            AddressEntity addressEntity = addressService.findById(id);

            return ok(this.addressConverter.entityToOutput(addressEntity));
        } catch (InvalidInformationException ex) {
            return error((AddressOutput) new AddressOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @GetMapping(value = "/list/{page}/{count}")
    public ResponseEntity<List<AddressOutput>> list(@PathVariable Long page, @PathVariable Long count) {

        try {
            addressConverter.checkPageInfo(page, count);
            List<AddressEntity> addresss = addressService.list(page, count);

            return ok(addresss.stream()
                    .map(this.addressConverter::entityToOutput)
                    .collect(Collectors.toList()));
        } catch (InvalidPageRequestException ex) {
            return error(Collections.singletonList((AddressOutput) new AddressOutput().setErrorMessage(ex.getMessage())));
        }
    }

    @GetMapping(value = "/count")
    public ResponseEntity<AddressCountOutput> count() {

        try {
            Long count = addressService.count();

            return ok(new AddressCountOutput().setCount(count));
        } catch (Exception ex){
            return error((AddressCountOutput) new AddressCountOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<AddressOutput> delete(@PathVariable Long id) {

        try {
            AddressEntity addressEntity = addressService.delete(id);

            return ok((AddressOutput) new AddressOutput().setSuccessMessage(""));
        } catch (InvalidInformationException ex) {
            return error((AddressOutput) new AddressOutput().setErrorMessage(ex.getMessage()));
        }
    }
}
