package com.company;

import com.company.CommandPattern.CommandsOperator;
import com.company.CommandPattern.User;
import com.company.Data.Product;
import com.company.utility.DataBase;
import com.company.utility.DataOperator;
import com.company.utility.DataProcessor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandRunner {

    public static List<Product> getProducts() {
        return products;
    }
    private final static List<Product> products = new ArrayList<>();
    private final static DataBase base = new DataBase(products);
    private final static User user = new User();
    public static DataOperator getData() {
        return data;
    }
    private final static DataOperator data = new DataOperator();
    private final static CommandsOperator operator = new CommandsOperator(user, base, data);

    public static void run(String line){
        String command = DataProcessor.getCommand(line);
        String argument = DataProcessor.getArgument(line);
        operator.execute(command, argument);
    }
}
