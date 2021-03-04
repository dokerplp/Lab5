package com.company.exceptions;

/**
 * Throws if you need file, but path is a file but not a directory
 */
public class IsFileException extends RuntimeException{

    public IsFileException(){
        System.out.println("По указанному адресу не лежит файл");
    }
}
