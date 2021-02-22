package com.platform.salus.common.controller;

import com.platform.salus.registryUser.user.controller.UserController;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@ApiIgnore
@ControllerAdvice(basePackageClasses = UserController.class)
public class ErrorHandlerController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @GetMapping("/error")
    public void handleErrorWithRedirect(HttpServletResponse response) throws IOException {
            response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
}