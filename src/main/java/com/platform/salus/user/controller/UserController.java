package com.platform.salus.user.controller;

import com.platform.salus.common.exceptions.InvalidPageRequestException;
import com.platform.salus.common.exceptions.SalusException;
import com.platform.salus.user.converter.UserConverter;
import com.platform.salus.user.converter.input.UserInput;
import com.platform.salus.user.converter.output.UserCountOutput;
import com.platform.salus.user.converter.output.UserOutput;
import com.platform.salus.user.model.UserEntity;
import com.platform.salus.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController extends UserBaseController {

    private final UserService userService;
    private final UserConverter userConverter;

    public UserController(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<UserOutput> create(@RequestBody UserInput user) {

        try {
            UserEntity userEntity = userService.create(this.userConverter.inputToEntity(user));

            return ok(this.userConverter.entityToOutput(userEntity));
        } catch (SalusException ex) {
            return error((UserOutput) new UserOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<UserOutput> update(@PathVariable Long id, @RequestBody UserInput user) {

        try {
            UserEntity userEntity = userService.update(id, this.userConverter.inputToEntity(user));

            return ok(this.userConverter.entityToOutput(userEntity));
        } catch (SalusException ex) {
            return error((UserOutput) new UserOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<UserOutput> findById(@PathVariable Long id) {

        try {
            UserEntity userEntity = userService.findById(id);

            return ok(this.userConverter.entityToOutput(userEntity));
        } catch (SalusException ex) {
            return error((UserOutput) new UserOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @GetMapping(value = "/list/{page}/{count}")
    public ResponseEntity<List<UserOutput>> list(@PathVariable Long page, @PathVariable Long count) {

        try {
            List<UserEntity> users = userService.list(page, count);

            return ok(users.stream()
                    .map(this.userConverter::entityToOutput)
                    .collect(Collectors.toList()));
        } catch (InvalidPageRequestException ex) {
            return error(Collections.singletonList((UserOutput) new UserOutput().setErrorMessage(ex.getMessage())));
        }
    }

    @GetMapping(value = "/count")
    public ResponseEntity<UserCountOutput> count() {

        try {
            Long count = userService.count();

            return ok(new UserCountOutput().setCount(count));
        } catch (Exception ex){
            return error((UserCountOutput) new UserCountOutput().setErrorMessage(ex.getMessage()));
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<UserOutput> delete(@PathVariable Long id) {

        try {
            UserEntity userEntity = userService.delete(id);

            return ok((UserOutput) new UserOutput().setSuccessMessage(""));
        } catch (SalusException ex) {
            return error((UserOutput) new UserOutput().setErrorMessage(ex.getMessage()));
        }
    }
}
