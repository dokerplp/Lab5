package com.company.utility.ForCommands;

public class CantWriteException extends RuntimeException{
    public CantWriteException() {
        System.out.println("Нет прав для записи данного файла");
    }
}
