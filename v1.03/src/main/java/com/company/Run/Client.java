package com.company.Run;

import com.company.CommandPattern.CommandsOperator;
import com.company.CommandPattern.User;
import com.company.Data.Product;
import com.company.exceptions.InfinityRecursionException;
import com.company.utility.ForCommands.RequestsQueue;
import com.company.utility.ForData.DataBase;
import com.company.utility.ForData.DataOperator;
import com.company.utility.ForData.DataProcessor;
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

        List<Product> products = new ArrayList<>();
        DataBase base = new DataBase(products);
        User user = new User();
        DataOperator data = new DataOperator();
        CommandsOperator operator = new CommandsOperator(user, base, data);

        try{
            new JSON_Breaker(products);
            Collections.sort(products);
        }catch (Exception e){
            System.out.println("Не удалось загрузить коллекцию из файла");
        }

        while (true){
            RequestsQueue.status = true;
            InfinityRecursionException.Putin();
            String push = CommandRunner.getData().getSTRING();
            if (push != null) RequestsQueue.pushOne(push);
            while (RequestsQueue.getElemntAmount() != 0) {
                String line = RequestsQueue.pollOne();
                if (line != null) {
                    String command = DataProcessor.getCommand(line);
                    String argument = DataProcessor.getArgument(line);
                    operator.execute(command, argument);
                }
            }
        }
    }
}
