package com.entex.aplication.api.exceptions;

public class EmailAddressExistsException extends RuntimeException {
    public EmailAddressExistsException() {
        super(" - Email address already exists!");
    }
}
