package com.company.CommandPattern.commands;

import com.company.CommandPattern.Command;
import com.company.Data.Product;
import java.util.List;

/**
 * Command types average price of all products
 */
public class AverageOfPriceCommand implements Command { //done //maybe //TESTED!

    List<Product> products;

    /**
     * AddIfMaxCommand Constructor
     * @param products - collection
     */
    public AverageOfPriceCommand(List<Product> products) { //done //maybe
        this.products = products;
    }

    /**
     * Realization of this command
     */
    private void AverageOfPriceRealization(){
        long Average = 0;
        int Counter = 0;
        for(Product product : products){
            Average += product.getPrice();
            Counter += 1;
        }
        if (Counter != 0) {
            System.out.println("Средняя цена: " + Average/Counter);
        }
        else System.out.println("Еще не существет ни одного продукта!");
    }

    /**
     * Execution of this command
     */
    @Override
    public void execute(String Argument) {
        if (Argument != null) System.out.println("Эта комманда не требует никаих аргуметов так-то :)");
        AverageOfPriceRealization();
    }
}
