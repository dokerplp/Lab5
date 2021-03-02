package com.company.Run;

import com.company.exceptions.InfinityRecursionException;
import com.company.utility.ForCommands.CommandRunner;
import com.company.utility.ForCommands.RequestsQueue;
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
            Collections.sort(CommandRunner.getBase().getBase());
        }catch (Exception e){
            System.out.println("Не удалось загрузить коллекцию из файла");
        }

        while (true){
            RequestsQueue.status = true;
            InfinityRecursionException.Putin();
            String push = CommandRunner.getData().getSTRING();
            if (push != null) RequestsQueue.pushOne(push);
            while (RequestsQueue.getElemntAmount() != 0) CommandRunner.run(RequestsQueue.pollOne());
        }
    }
}
