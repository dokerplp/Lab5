package com.company.CommandPattern.commands;

import com.company.CommandPattern.Command;
import com.company.utility.ForCommands.CreateNewProduct;
import com.company.Data.Product;
import com.company.utility.ForData.DataOperator;

import java.util.List;

/**
 * Command create and add new element to collection
 */
public class AddCommand implements Command { //done //maybe //TESTED!

    List<Product> products;
    DataOperator operator;
    CreateNewProduct createNewProduct;
    Product product;

    /**
     * AddCommand Constructor
     * @param products - collection
     * @param operator - Class to run Data
     */
    public AddCommand(List<Product> products, DataOperator operator) {
        this.products = products;
        this.operator = operator;
    }

    /**
     * Realization of this command
     */
    private void AddRealization(){
        createNewProduct = new CreateNewProduct(products);
        product = createNewProduct.HumanMode();
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