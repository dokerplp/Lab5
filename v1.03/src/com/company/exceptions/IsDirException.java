package com.company.exceptions;

/**
 * Throws if you need file, but path is a file but not a directory
 */
public class IsDirException extends RuntimeException{

    public IsDirException(){
        System.out.println("По указанному адресу лежит дириктория, а не файл");
    }
}
