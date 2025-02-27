package com.capgemini.address_book.service.impl;

import com.capgemini.address_book.dto.AddressBookDto;
import com.capgemini.address_book.dto.AddressBookDtoMapper;
import com.capgemini.address_book.exception.AddressBookAlreadyExistsException;
import com.capgemini.address_book.exception.AddressBookNotFoundException;
import com.capgemini.address_book.model.AddressBook;
import com.capgemini.address_book.repository.AddressBookRepository;
import com.capgemini.address_book.service.IAddressBookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"prod"})
@Service
@RequiredArgsConstructor
@Slf4j
public class AddressBookServiceImpl implements IAddressBookService {

    private final AddressBookRepository addressBookRepository;


    @Override
    public AddressBookDto addAddressBook(AddressBook addressBook) {
        if(addressBookRepository.findById(addressBook.getId()).isPresent()){
            throw new AddressBookAlreadyExistsException("AddressBook already exists");
        }
        log.debug("AddressBook saved to database");
        AddressBook addedAddressBook = addressBookRepository.save(addressBook);
        return AddressBookDtoMapper.mapToAddressBookDto(addedAddressBook);
    }

    @Override
    public AddressBookDto getAddressBookById(Long id) {
        if(id < 1){
            throw new IllegalArgumentException("Invalid ID");
        }
        AddressBook addressBook = addressBookRepository.findById(id).orElseThrow();
        log.debug("AddressBook with id: {} is {}", id, addressBook);
        return AddressBookDtoMapper.mapToAddressBookDto(addressBook);
    }

    @Override
    public AddressBookDto patchAddressBook(AddressBook addressBook) {
        if(addressBookRepository.findById(addressBook.getId()).isEmpty()){
            throw new AddressBookNotFoundException("AddressBook with id " + addressBook.getId() + " not found");
        }
        AddressBook updatedAddressBook = addressBookRepository.save(addressBook);
        log.debug("AddressBook patched successfully!");
        return AddressBookDtoMapper.mapToAddressBookDto(updatedAddressBook);
    }

    @Override
    public boolean deleteAddressBookById(Long id) {
        if(addressBookRepository.findById(id).isEmpty()){
            throw new AddressBookNotFoundException("AddressBook with id " + id + " not found");
        }
        log.debug("AddressBook with id: {} removed from database", id);
        addressBookRepository.deleteById(id);
        return true;
    }
}
