package com.company.CommandPattern.commands;

import com.company.CommandPattern.Command;
import com.company.Data.Product;
import com.company.utility.ForCommands.CreateNewProduct;
import com.company.utility.ForData.DataOperator;

import java.util.List;

/**
 * Command create and add new element to collection, if its price is more then  ̶u̶n̶i̶v̶e̶r̶s̶i̶t̶y̶ max price
 */
public class AddIfMaxCommand implements Command {

    List<Product> products;
    DataOperator operator;
    CreateNewProduct createNewProduct;
    Product product;

    /**
     * AddIfMaxCommand Constructor
     * @param products - collection
     * @param operator - Class to run Data
     */
    public AddIfMaxCommand(List<Product> products, DataOperator operator) { //done //maybe //TESTED!
        this.products = products;
        this.operator = operator;
    }

    /**
     * Realization of this command
     */
    private void AddIfMaxRealization(){
        createNewProduct = new CreateNewProduct(products);
        product = createNewProduct.HumanMode();
        boolean trigger = true; //if trigger is false, then creation will be canceled
        long price = product.getPrice(); //price is a comparison criterion
        for (Product product2 : products){
            if (product2.getPrice() >= price) trigger = false;
        }
        if (trigger){
            products.add(product);
            Product.setLastInit();
            System.out.println("\nПродукт создан!");
        }
        else {
            System.out.println("\nНовый продукт не превышает максимального, создание отменено!");
        }

    }

    /**
     * Execution of this command
     */
    @Override
    public void execute(String Argument) {
        if (Argument != null) System.out.println("Эта комманда не требует никаих аргуметов так-то :)");
        AddIfMaxRealization();
    }
}
