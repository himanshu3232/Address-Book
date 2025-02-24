package com.capgemini.address_book.dto;

import com.capgemini.address_book.model.AddressBook;

public class AddressBookDtoMapper {
    public static AddressBookDto mapToAddressBookDto(AddressBook addressBook){
        return new AddressBookDto(addressBook.getName(), addressBook.getAddress());
    }

    public static AddressBook mapToAddressBook(AddressBookDto addressBookDto){
        AddressBook addressBook = new AddressBook();
        addressBook.setAddress(addressBookDto.address());
        addressBook.setName(addressBookDto.name());
        return addressBook;
    }
}
