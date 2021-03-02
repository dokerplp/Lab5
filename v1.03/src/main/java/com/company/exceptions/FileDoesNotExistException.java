package com.company.exceptions;

/**
 * Throws if file doesn't exist
 */
public class FileDoesNotExistException extends RuntimeException {

    public FileDoesNotExistException() {
        System.out.println("Файла, находящегося по указанному адресу, не существует");
    }

}

