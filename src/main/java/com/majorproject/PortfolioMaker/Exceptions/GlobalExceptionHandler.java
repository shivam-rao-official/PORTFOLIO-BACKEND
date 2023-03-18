package com.majorproject.PortfolioMaker.Exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler({
            UserAlreadyExists.class,
            BadCredentials.class,
            InvalidArgumentException.class,
            MissingServletRequestParameterException.class,
            DuplicateKeyException.class
    })
    public ResponseEntity<?> badRequests(Exception ex) {
        Map<String, Object> errMap = new HashMap<>();
        errMap.put("msg", ex.getMessage());
        errMap.put("httpCode", HttpStatus.BAD_REQUEST.value());
        errMap.put("httpStatus", HttpStatus.BAD_REQUEST);
        errMap.put("timeStamp", new Date(System.currentTimeMillis()));

        return ResponseEntity.badRequest().body(errMap);
    }
}
