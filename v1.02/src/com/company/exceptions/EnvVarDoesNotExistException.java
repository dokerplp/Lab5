package com.company.exceptions;

/**
 * Throws if there aren't "LAB" environment variable
 */
public class EnvVarDoesNotExistException extends RuntimeException{

    public EnvVarDoesNotExistException(){
        System.out.println("Переменной среды LAB не существует");
    }

}

