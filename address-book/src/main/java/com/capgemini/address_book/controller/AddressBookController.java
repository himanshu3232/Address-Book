package com.capgemini.address_book.controller;

import com.capgemini.address_book.dto.AddressBookDto;
import com.capgemini.address_book.model.AddressBook;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressBookController {

    

    AddressBookController(){}

    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBookDto> getAddressBook(@PathVariable Long id){

    }

    @PostMapping("/post")
    public ResponseEntity<AddressBookDto> postAddressBook(@RequestBody AddressBook){

    }
    @PatchMapping("/update")
    public ResponseEntity<AddressBookDto> patchAddressBook(@RequestBody AddressBook){

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteAddressBook(@PathVariable Long id){

    }
}
