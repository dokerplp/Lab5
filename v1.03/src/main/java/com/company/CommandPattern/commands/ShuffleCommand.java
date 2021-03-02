package com.company.CommandPattern.commands;

import com.company.CommandPattern.Command;
import com.company.Data.Product;

import java.util.Collections;
import java.util.List;

/**
 * Command shuffles collection
 */
public class ShuffleCommand implements Command { //done //maybe //TESTED!

    private final List<Product> products;

    /**
     * AddCommand Constructor
     * @param products - collection
     */
    public ShuffleCommand(List<Product> products) {
        this.products = products;
    }

    /**
     * Realization of this command
     */
    private void ShuffleRealization(){
        Collections.shuffle(products);
    }

    /**
     * Execution of this command
     */
    @Override
    public void execute(String Argument) {
        if (Argument != null) System.out.println("Эта комманда не требует никаих аргуметов так-то :)");
        ShuffleRealization();
    }
}
