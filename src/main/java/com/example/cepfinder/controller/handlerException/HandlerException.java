package com.example.cepfinder.controller.handlerException;

import com.example.cepfinder.exceptions.InvalidCepException;
import com.example.cepfinder.exceptions.NotFoundException;
import com.example.cepfinder.model.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(InvalidCepException.class)
    public ResponseEntity<ErrorDTO> invalidCepException(InvalidCepException invalidCepException){
        ErrorDTO errorDTO = new ErrorDTO(HttpStatus.BAD_REQUEST,invalidCepException.getMessage());
        return new ResponseEntity<>(errorDTO,errorDTO.getHttpStatus());
    };

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> notFoundException(NotFoundException notFoundException){
        ErrorDTO errorDTO = new ErrorDTO(HttpStatus.NOT_FOUND,notFoundException.getMessage());
        return new ResponseEntity<>(errorDTO,errorDTO.getHttpStatus());
    };
}
