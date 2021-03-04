package com.company.run;

import com.company.commandPattern.CommandsOperator;
import com.company.commandPattern.User;
import com.company.data.Product;
import com.company.exceptions.InfinityRecursionException;
import com.company.utility.forCommands.RequestsQueue;
import com.company.utility.forData.DataBase;
import com.company.utility.forData.DataOperator;
import com.company.utility.forData.DataProcessor;
import com.company.utility.json.JSON_Breaker;

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
            String push = null;
            try{
                push = data.getSTRING();
            } catch (NoSuchElementException e){
                System.out.println("КЧАУ!");
                System.exit(0);
            }
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
