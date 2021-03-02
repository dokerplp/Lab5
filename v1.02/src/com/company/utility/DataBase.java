package com.company.utility;

import com.company.Data.Product;
import java.util.List;

/**
 * Contains collection
 */
public class DataBase {

    private final List<Product> products;

    /**
     * Constructor
     * @param products - collection
     */
    public DataBase(List<Product> products){
        this.products = products;
    }

    /**
     * Collection getter
     * @return collection
     */
    public List<Product> getBase(){
        return products;
    }

}
