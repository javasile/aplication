package com.entex.aplication.api.exceptions;

public class InvalidUUIDException extends RuntimeException {
    public InvalidUUIDException() {
        super("UUID is invalid");
    }
}
