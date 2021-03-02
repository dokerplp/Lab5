package com.company.utility.ForCommands;

import com.company.CommandPattern.CommandsOperator;
import com.company.CommandPattern.User;
import com.company.Data.Product;
import com.company.utility.ForData.DataBase;
import com.company.utility.ForData.DataOperator;
import com.company.utility.ForData.DataProcessor;

import java.util.ArrayList;
import java.util.List;

public class CommandRunner {

    public static List<Product> getProducts() {
        return products;
    }
    private final static List<Product> products = new ArrayList<>();
    public static DataBase getBase() {
        return base;
    }
    private final static DataBase base = new DataBase(products);
    private final static User user = new User();
    public static DataOperator getData() {
        return data;
    }
    private final static DataOperator data = new DataOperator();
    private final static CommandsOperator operator = new CommandsOperator(user, base, data);

    public static void run(String line){
        if (line != null) {
            String command = DataProcessor.getCommand(line);
            String argument = DataProcessor.getArgument(line);
            operator.execute(command, argument);
        }
    }
}
