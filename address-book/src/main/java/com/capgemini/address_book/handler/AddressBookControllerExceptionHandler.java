package com.capgemini.address_book.handler;

import com.capgemini.address_book.controller.AddressBookController;
import com.capgemini.address_book.exception.AddressBookAlreadyExistsException;
import com.capgemini.address_book.exception.AddressBookNotFoundException;
import com.capgemini.address_book.exception.InvalidRequestBodyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = AddressBookController.class)
@Slf4j
public class AddressBookControllerExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgsException(IllegalArgumentException e){
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(AddressBookAlreadyExistsException.class)
    public ResponseEntity<Object> handleAddressBookAlreadyExistsException(AddressBookAlreadyExistsException e){
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(AddressBookNotFoundException.class)
    public ResponseEntity<Object> handleAddressBookNotFoundException(AddressBookNotFoundException e){
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(InvalidRequestBodyException.class)
    public ResponseEntity<Object> handleInvalidRequestBodyExceptionException(InvalidRequestBodyException e){
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleOtherException(Exception e){
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
