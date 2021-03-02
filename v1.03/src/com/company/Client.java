package com.company;

import com.company.CommandPattern.CommandsOperator;
import com.company.CommandPattern.User;
import com.company.Data.Product;
import com.company.utility.*;
import com.company.utility.JSON.JSON_Breaker;

import java.util.*;

/**
 * Main class
 */
public class Client {

    /**
     * main method
     */
    public static void main(String[] args) {

        try{
            JSON_Breaker breaker = new JSON_Breaker(CommandRunner.getProducts());
        }catch (Exception e){
            System.out.println("Не удалось загрузить коллекцию из файла");
        }

        while (true){
            RequestsQueue.status = true;
            String push = CommandRunner.getData().getSTRING();
            if (push != null) RequestsQueue.pushOne(push);
            while (RequestsQueue.getElemntAmount() != 0) CommandRunner.run(RequestsQueue.pollOne());
        }
    }
}
