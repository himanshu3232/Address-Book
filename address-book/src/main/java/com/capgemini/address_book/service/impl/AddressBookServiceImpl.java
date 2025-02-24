package com.capgemini.address_book.service.impl;

import com.capgemini.address_book.dto.AddressBookDto;
import com.capgemini.address_book.model.AddressBook;
import com.capgemini.address_book.repository.AddressBookRepository;
import com.capgemini.address_book.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl implements IAddressBookService {

    private AddressBookRepository addressBookRepository;

    @Autowired
    public AddressBookServiceImpl(AddressBookRepository addressBookRepository){
        this.addressBookRepository = addressBookRepository;
    }

    public AddressBookServiceImpl(){}

    @Override
    public AddressBookDto addAddressBook(AddressBook addressBook) {
        return null;
    }

    @Override
    public AddressBookDto getAddressBookById(Long id) {
        return null;
    }

    @Override
    public AddressBookDto patchAddressBook(AddressBook addressBook) {
        return null;
    }

    @Override
    public boolean deleteAddressBookById(Long id) {
        return false;
    }
}
