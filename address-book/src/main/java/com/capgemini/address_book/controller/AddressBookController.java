package com.capgemini.address_book.controller;

import com.capgemini.address_book.dto.AddressBookDto;
import com.capgemini.address_book.model.AddressBook;
import com.capgemini.address_book.service.IAddressBookService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address-book")
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookController {

    private IAddressBookService addressBookService;

    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBookDto> getAddressBook(@PathVariable Long id){
        return new ResponseEntity<>(addressBookService.getAddressBookById(id), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<AddressBookDto> postAddressBook(@RequestBody AddressBook addressBook){
        return new ResponseEntity<>(addressBookService.addAddressBook(addressBook), HttpStatus.CREATED);
    }
    @PatchMapping("/update")
    public ResponseEntity<AddressBookDto> patchAddressBook(@RequestBody AddressBook addressBook){
        return new ResponseEntity<>(addressBookService.patchAddressBook(addressBook), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteAddressBook(@PathVariable Long id){
        return new ResponseEntity<>(addressBookService.deleteAddressBookById(id), HttpStatus.ACCEPTED);
    }
}
