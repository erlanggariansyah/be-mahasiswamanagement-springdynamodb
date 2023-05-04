package com.erlanggariansyah.mahasiswamanagementspringdynamodb.exception.handler;

import com.erlanggariansyah.mahasiswamanagementspringdynamodb.dto.ResponseList;
import com.erlanggariansyah.mahasiswamanagementspringdynamodb.exception.throwable.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class NotFoundExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, ?>> handle(NotFoundException notFoundException) {
        ArrayList<ResponseList> errorList = new ArrayList<>();
        Map<String, Object> responseBody = new LinkedHashMap<>();

        errorList.add(new ResponseList(notFoundException.getField(), notFoundException.getMessage()));

        responseBody.put("title", "NOT FOUND");
        responseBody.put("status", 404);
        responseBody.put("errors", errorList);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
    }
}
