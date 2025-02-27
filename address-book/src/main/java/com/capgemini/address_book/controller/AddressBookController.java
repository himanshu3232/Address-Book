package com.capgemini.address_book.controller;

import com.capgemini.address_book.dto.AddressBookDto;
import com.capgemini.address_book.exception.InvalidRequestBodyException;
import com.capgemini.address_book.model.AddressBook;
import com.capgemini.address_book.service.IAddressBookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address-book")
@RequiredArgsConstructor
@Slf4j
public class AddressBookController {

    private final IAddressBookService addressBookService;

    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBookDto> getAddressBook(@PathVariable Long id){
        log.info("Get address book request with id : {}", id);
        return new ResponseEntity<>(addressBookService.getAddressBookById(id), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<AddressBookDto> postAddressBook
            (@RequestBody @Valid AddressBook addressBook,
             BindingResult bindingResult){
        log.info("post request for adding new address book");
        log.trace("AddressBook: {} requested to be added", addressBook);
        if(bindingResult.hasErrors()){
            log.error("Error in post request validation");
            for(ObjectError error : bindingResult.getAllErrors()){
                log.warn(error.getDefaultMessage());
            }
            throw new InvalidRequestBodyException("Invalid request body");
        }
        return new ResponseEntity<>(addressBookService.addAddressBook(addressBook), HttpStatus.CREATED);
    }
    @PatchMapping("/patch")
    public ResponseEntity<AddressBookDto> patchAddressBook
            (@RequestBody @Valid AddressBook addressBook,
             BindingResult bindingResult){
        log.info("Request to patch address book with id : {}", addressBook.getId());
        log.trace("AddressBook: {} to be updated", addressBook);
        if(bindingResult.hasErrors()){
            log.error("Error in patch request validation");
            for(ObjectError error : bindingResult.getAllErrors()){
                log.warn(error.getDefaultMessage());
            }
            throw new InvalidRequestBodyException("Invalid request body");
        }
        return new ResponseEntity<>(addressBookService.patchAddressBook(addressBook), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteAddressBook(@PathVariable Long id){
        log.info("Delete request to delete address book with id: {}", id);
        return new ResponseEntity<>(addressBookService.deleteAddressBookById(id), HttpStatus.ACCEPTED);
    }
}
