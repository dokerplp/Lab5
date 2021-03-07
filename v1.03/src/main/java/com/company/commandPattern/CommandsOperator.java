package com.company.commandPattern;

import com.company.data.Product;
import com.company.commandPattern.commands.*;
import com.company.utility.forData.DataBase;
import com.company.utility.forData.DataOperator;

import java.util.List;

/**
 * Receiver class
 * It knows list of commands, but dont knows how execute it
 */
public class CommandsOperator { //Receiver

    private final User user;
    private final DataBase base;
    private final DataOperator data;

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
        user.addCommand("help", new HelpCommand());
        user.addCommand("add", new AddCommand(base));
        user.addCommand("add_if_max", new AddIfMaxCommand(base));
        user.addCommand("average_of_price", new AverageOfPriceCommand(base));
        user.addCommand("clear", new ClearCommand(base));
        user.addCommand("count_by_manufacture_cost", new CountByManufactureCostCommand(base, data));
        user.addCommand("count_less_than_manufacture_cost", new CountLessThanManufactureCostCommand(base, data));
        user.addCommand("execute_script", new ExecuteScriptCommand(base));
        user.addCommand("exit", new ExitCommand());
        user.addCommand("info", new InfoCommand(base));
        user.addCommand("remove_by_id", new RemoveByIdCommand(base, data));
        user.addCommand("remove_greater", new RemoveGreaterCommand(base, data));
        user.addCommand("save", new SaveCommand(base));
        user.addCommand("show", new ShowCommand(base));
        user.addCommand("shuffle", new ShuffleCommand(base));
        user.addCommand("update", new UpdateCommand(base, data));
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
