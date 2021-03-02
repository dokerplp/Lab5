package com.company.CommandPattern;

import com.company.Data.Product;
import com.company.CommandPattern.commands.*;
import com.company.utility.ForData.DataBase;
import com.company.utility.ForData.DataOperator;

import java.util.List;

/**
 * Receiver class
 * It knows list of commands, but dont knows how execute it
 */
public class CommandsOperator { //Receiver

    User user;
    DataBase base;
    List<Product> products;
    DataOperator data;

    /**
     * Constructor
     * @param user - Invoker class
     * @param base - Collection
     * @param data - Class to run Data (needs for some commands)
     */
    public CommandsOperator(User user, DataBase base, DataOperator data){
        this.user = user;
        this.base = base;
        this.data = data;
        SetCommands();
    }

    /**
     * Adding command in Invoker HashMap
     */
    private void SetCommands(){
        products = base.getBase();

        Command add = new AddCommand(products, data); //ListData
        Command addIM = new AddIfMaxCommand(products, data); //ListData
        Command averageOP = new AverageOfPriceCommand(products); //List
        Command clear = new ClearCommand(products); //List
        Command countBMC = new CountByManufactureCostCommand(products, data); //ListData
        Command countLTM = new CountLessThanManufactureCostCommand(products, data); //ListData
        Command executeScript = new ExecuteScriptCommand(); //NoData
        Command exit = new ExitCommand();
        Command help = new HelpCommand(); //NoData
        Command info = new InfoCommand(products); //List
        Command removeByID = new RemoveByIdCommand(products, data); //ListData
        Command removeGreater = new RemoveGreaterCommand(products, data); //ListData
        Command save = new SaveCommand(products);  //List
        Command show = new ShowCommand(products); //List
        Command shuffle = new ShuffleCommand(products); //List
        Command update = new UpdateCommand(products, data); //ListData

        user.addCommand("help", help);
        user.addCommand("add", add);
        user.addCommand("add_if_max", addIM);
        user.addCommand("average_of_price", averageOP);
        user.addCommand("clear", clear);
        user.addCommand("count_by_manufacture_cost", countBMC);
        user.addCommand("count_less_than_manufacture_cost", countLTM);
        user.addCommand("execute_script", executeScript);
        user.addCommand("exit", exit);
        user.addCommand("info",info);
        user.addCommand("remove_by_id", removeByID);
        user.addCommand("remove_greater", removeGreater);
        user.addCommand("save", save);
        user.addCommand("show", show);
        user.addCommand("shuffle", shuffle);
        user.addCommand("update", update);
    }

    /**
     * Running execution in Invoker class
     * @param command - what command
     * @param argument - what argument
     */
    public void execute(String command, String argument){
        user.execute(command, argument);
    }




}
