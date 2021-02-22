package com.platform.salus.registryUser.user.controller;

import com.platform.salus.common.controller.BaseController;
import com.platform.salus.registryUser.user.converter.output.UserCountOutput;
import com.platform.salus.registryUser.user.converter.output.UserOutput;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UserBaseController extends BaseController {

    public ResponseEntity<List<UserOutput>> ok(List<UserOutput> obj) {
        return ResponseEntity.ok(obj);
    }

    public ResponseEntity<List<UserOutput>> error(List<UserOutput> obj) {
        return ResponseEntity.badRequest().body(obj);
    }

    public ResponseEntity<UserOutput> ok(UserOutput obj) {
        return ResponseEntity.ok(obj);
    }

    public ResponseEntity<UserOutput> error(UserOutput obj) {
        return ResponseEntity.badRequest().body(obj);
    }

    public ResponseEntity<UserCountOutput> ok(UserCountOutput obj) {
        return ResponseEntity.ok(obj);
    }

    public ResponseEntity<UserCountOutput> error(UserCountOutput obj) {
        return ResponseEntity.badRequest().body(obj);
    }
}