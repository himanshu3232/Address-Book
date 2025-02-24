package com.capgemini.address_book.service;

import com.capgemini.address_book.dto.AddressBookDto;
import com.capgemini.address_book.model.AddressBook;

public interface IAddressBookService {
    AddressBookDto addAddressBook(AddressBook addressBook);
    AddressBookDto getAddressBookById(Long id);
    AddressBookDto patchAddressBook(AddressBook addressBook);
    boolean deleteAddressBookById(Long id);
}
