package com.company.commandPattern.commands;

import com.company.commandPattern.Command;
import com.company.data.Product;
import com.company.utility.forCommands.CreateNewProduct;

import java.util.List;

/**
 * Command create and add new element to collection, if its price is more then  ̶u̶n̶i̶v̶e̶r̶s̶i̶t̶y̶ max price
 */
public class AddIfMaxCommand implements Command {

    private final List<Product> products;

    /**
     * AddIfMaxCommand Constructor
     * @param products - collection
     */
    public AddIfMaxCommand(List<Product> products) { //done //maybe //TESTED! //OK
        this.products = products;
    }

    /**
     * Realization of this command
     */
    private void AddIfMaxRealization(){
        CreateNewProduct createNewProduct = new CreateNewProduct();
        Product product = createNewProduct.HumanMode();
        boolean trigger = true; //if trigger is false, then creation will be canceled
        long price = product.getPrice(); //price is a comparison criterion
        for (Product product2 : products){
            if (product2.getPrice() >= price) {
                trigger = false;
                break;
            }
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
