package com.capgemini.address_book.exception;

public class AddressBookAlreadyExistsException extends RuntimeException {
    public AddressBookAlreadyExistsException(String message) {
        super(message);
    }
}
