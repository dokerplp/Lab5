package com.company.commandPattern.commands;

import com.company.commandPattern.Command;
import com.company.data.Product;
import com.company.utility.forData.DataBase;

import java.util.List;

/**
 * Command deletes all elements in collection
 */
public class ClearCommand implements Command { //Good

    private final List<Product> products; //Collection

    /**
     * AddIfMaxCommand Constructor
     * @param base - collection
     */
    public ClearCommand(DataBase base) {
        this.products = base.getBase();
    }

    /**
     * Realization of this command
     */
    private void ClearRealization(){
        products.clear(); //Clear Collection
    }

    /**
     * Execution of this command
     */
    @Override
    public void execute(String Argument) {
        if (Argument != null) System.out.println("Эта комманда не требует никаих аргуметов так-то :)");
        ClearRealization();
    }
}
