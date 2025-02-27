package com.capgemini.address_book.controller;

import com.capgemini.address_book.dto.AddressBookDto;
import com.capgemini.address_book.model.AddressBook;
import com.capgemini.address_book.service.IAddressBookService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address-book")
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class AddressBookController {

    private IAddressBookService addressBookService;

    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBookDto> getAddressBook(@PathVariable Long id){
        log.info("Get address book request with id : {}", id);
        return new ResponseEntity<>(addressBookService.getAddressBookById(id), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<AddressBookDto> postAddressBook(@RequestBody AddressBook addressBook){
        log.info("post request for adding new address book");
        log.trace("AddressBook: {} requested to be added", addressBook);
        return new ResponseEntity<>(addressBookService.addAddressBook(addressBook), HttpStatus.CREATED);
    }

    @PatchMapping("/update")
    public ResponseEntity<AddressBookDto> patchAddressBook(@RequestBody AddressBook addressBook){
        log.info("Request to patch address book with id : {}", addressBook.getId());
        log.trace("AddressBook: {} to be updated", addressBook);
        return new ResponseEntity<>(addressBookService.patchAddressBook(addressBook), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteAddressBook(@PathVariable Long id){
        log.info("Delete request to delete address book with id: {}", id);
        return new ResponseEntity<>(addressBookService.deleteAddressBookById(id), HttpStatus.ACCEPTED);
    }
}
