package com.capgemini.address_book.dto;

import com.capgemini.address_book.model.AddressBook;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AddressBookDtoMapper {
    private AddressBookDtoMapper(){}

    public static AddressBookDto mapToAddressBookDto(AddressBook addressBook){
        log.trace("AddressBook mapped to addressBookDTO");
        return new AddressBookDto(addressBook.getName(), addressBook.getAddress());
    }

    public static AddressBook mapToAddressBook(AddressBookDto addressBookDto){
        log.trace("AddressBookDto to be mapped to AddressBook");
        AddressBook addressBook = new AddressBook();
        addressBook.setAddress(addressBookDto.address());
        addressBook.setName(addressBookDto.name());
        log.trace("AddressBookDto mapped to AddressBook");
        return addressBook;
    }
}
