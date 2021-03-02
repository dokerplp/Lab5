package com.company.exceptions;

import com.company.utility.ForCommands.RequestsQueue;

/**
 * Throws if you entered wrong data
 */
public class IncorrectDataException extends RuntimeException{

    String logs;

    public IncorrectDataException(String logs){
        this.logs = logs;
        if (RequestsQueue.status) System.out.println("Ошибка данных..." + logs);
    }
    public IncorrectDataException(){
        this.logs = "";
        if (RequestsQueue.status) System.out.println("Ошибка данных...");
    }

    @Override
    public String toString(){
        return "Ошибка данных...\n" + logs;
    }
}
