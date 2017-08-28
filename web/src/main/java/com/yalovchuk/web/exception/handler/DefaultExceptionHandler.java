package com.yalovchuk.web.exception.handler;

import com.yalovchuk.service.exception.ForbiddenException;
import com.yalovchuk.service.exception.NotFoundException;
import com.yalovchuk.service.exception.NotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public void notFoundHandler(Exception e, HttpServletResponse response) throws Exception {
        response.sendError(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ExceptionHandler(value = NotValidException.class)
    public void notValidHandler(Exception e, HttpServletResponse response) throws Exception {
        response.sendError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(value = ForbiddenException.class)
    public void forbiddenHandler(Exception e, HttpServletResponse response) throws Exception {
        response.sendError(HttpStatus.FORBIDDEN.value(), e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public void defaultErrorHandler(Exception e, HttpServletResponse response) throws Exception {
        response.sendError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }
}
