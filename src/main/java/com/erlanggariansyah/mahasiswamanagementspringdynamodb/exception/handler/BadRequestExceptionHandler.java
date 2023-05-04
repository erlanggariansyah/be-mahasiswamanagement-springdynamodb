package com.erlanggariansyah.mahasiswamanagementspringdynamodb.exception.handler;

import com.erlanggariansyah.mahasiswamanagementspringdynamodb.dto.ResponseList;
import com.erlanggariansyah.mahasiswamanagementspringdynamodb.exception.throwable.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class BadRequestExceptionHandler {
    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Map<String, ?>> handle(BadRequestException badRequestException) {
        List<ResponseList> errorList = new ArrayList<>();
        Map<String, Object> responseBody = new LinkedHashMap<>();

        errorList.add(new ResponseList(badRequestException.getField(), badRequestException.getMessage()));
        responseBody.put("title", "BAD REQUEST");
        responseBody.put("status", 400);
        responseBody.put("errors", errorList);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
