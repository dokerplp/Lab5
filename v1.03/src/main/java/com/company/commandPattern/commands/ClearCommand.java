package com.company.commandPattern.commands;

import com.company.commandPattern.Command;
import com.company.data.Product;
import java.util.List;

/**
 * Command deletes all elements in collection
 */
public class ClearCommand implements Command { //done //maybe //TESTED!

    private final List<Product> products;

    /**
     * AddIfMaxCommand Constructor
     * @param products - collection
     */
    public ClearCommand(List<Product> products) {
        this.products = products;
    }

    /**
     * Realization of this command
     */
    private void ClearRealization(){
        products.clear();
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
