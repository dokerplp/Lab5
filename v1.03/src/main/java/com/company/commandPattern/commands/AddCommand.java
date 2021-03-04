package com.company.commandPattern.commands;

import com.company.commandPattern.Command;
import com.company.utility.forCommands.CreateNewProduct;
import com.company.data.Product;

import java.util.List;

/**
 * Command create and add new element to collection
 */
public class AddCommand implements Command { //done //maybe //TESTED! //OK

    private final List<Product> products;

    /**
     * AddCommand Constructor
     * @param products - collection
     */
    public AddCommand(List<Product> products) {
        this.products = products;
    }

    /**
     * Realization of this command
     */
    private void AddRealization(){
        CreateNewProduct createNewProduct = new CreateNewProduct();
        Product product = createNewProduct.HumanMode();
        products.add(product);
    }


    /**
     * Execution of this command
     */
    @Override
    public void execute(String Argument) {
        if (Argument != null) System.out.println("Эта комманда не требует никаих аргуметов так-то :)");
        AddRealization();
        Product.setLastInit();
        System.out.println("\nПродукт создан!");
    }
}