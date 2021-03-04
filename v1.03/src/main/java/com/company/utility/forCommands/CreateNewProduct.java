package com.company.utility.forCommands;

import com.company.data.Address;
import com.company.data.Coordinates;
import com.company.data.Organization;
import com.company.data.Product;
import com.company.exceptions.IncorrectDataException;
import com.company.utility.forData.DataBase;

/**
 * Creating Product
 */
public class CreateNewProduct extends ProductOperator {

    private final Product product;
    private final Coordinates coordinates = new Coordinates();
    private final Organization organization = new Organization();
    private final Address address = new Address();
    private final DataBase base;


    /**
     * Constructor for add command
     */
    public CreateNewProduct(DataBase base) {
        product = new Product();
        this.base = base;
    }

    /**
     * Constructor dor update command
     * @param product - Updatable product
     */
    public CreateNewProduct(Product product, DataBase base){
        this.product = product;
        this.base = base;
    }

    /**
     * Recursive asker of correct product name
     */
    public void setName(){
        boolean trigger = true;

        while (trigger){
            try {
                product.setName(getName());
                trigger = false;
            } catch (IncorrectDataException ignored){
            }
        }
    }

    /**
     * Recursive asker of correct x coordinate
     */
    public void setX(){
        boolean trigger = true;

        while (trigger){
            try {
                coordinates.setX(getX());
                trigger = false;
            } catch (IncorrectDataException ignored){
            }
        }
    }

    /**
     * Recursive asker of correct y coordinate
     */
    public void setY(){
        boolean trigger = true;

        while (trigger){
            try {
                coordinates.setY(getY());
                trigger = false;
            } catch (IncorrectDataException ignored){
            }
        }
    }

    /**
     * Recursive asker of correct product price
     */
    public void setPrice(){
        boolean trigger = true;

        while (trigger){
            try {
                product.setPrice(getPrice());
                trigger = false;
            } catch (IncorrectDataException ignored){
            }
        }
    }

    /**
     * Recursive asker of correct product part number
     */
    public void setPartNumber(){
        boolean trigger = true;

        while (trigger){
            try {
                product.setPartNumber(getPartNumber());
                trigger = false;
            } catch (IncorrectDataException ignored){
            }
        }
    }

    /**
     * Recursive asker of correct product manufacture cost
     */
    public void setMCost(){
        boolean trigger = true;

        while (trigger){
            try {
                product.setManufactureCost(getMCost());
                trigger = false;
            } catch (IncorrectDataException ignored){
            }
        }
    }

    /**
     * Recursive asker of correct product Unit of Measure
     */
    public void setMeasure(){
        boolean trigger = true;

        while (trigger){
            try {
                product.setUnitOfMeasure(getMeasure());
                trigger = false;
            } catch (IncorrectDataException ignored){
            }
        }
    }

    /**
     * Recursive asker of correct organization name
     */
    public void setOrgName(){
        boolean trigger = true;

        while (trigger){
            try {
                organization.setName(getOrgName());
                trigger = false;
            } catch (IncorrectDataException ignored){
            }
        }
    }

    /**
     * Recursive asker of correct organization employees count
     */
    public void setEcount(){
        boolean trigger = true;

        while (trigger){
            try {
                organization.setEmployeesCount(getEcount());
                trigger = false;
            } catch (IncorrectDataException ignored){
            }
        }
    }

    /**
     * Recursive asker of correct organization type
     */
    public void setType(){
        boolean trigger = true;

        while (trigger){
            try {
                organization.setType(getType());
                trigger = false;
            } catch (IncorrectDataException ignored){
            }
        }
    }

    /**
     * Recursive asker of correct organization street
     */
    public void setStreet(){
        boolean trigger = true;

        while (trigger){
            try {
                address.setStreet(getStreet());
                trigger = false;
            } catch (IncorrectDataException ignored){
            }
        }
    }

    /**
     * Recursive asker of correct organization zip code
     */
    public void setZip(){
        boolean trigger = true;

        while (trigger){
            try {
                address.setZipCode(getZip());
                trigger = false;
            } catch (IncorrectDataException ignored){
            }
        }
    }

    /**
     * Run all recursive methods (for humans only)
     * @return done Product object
     */
    public Product HumanMode(){
        setName();
        if (RequestsQueue.status) System.out.println("Координаты: ");
        setX();
        setY();
        setPrice();
        setPartNumber();
        setMCost();
        setMeasure();
        if (RequestsQueue.status) System.out.println("Изготовитель: ");
        setOrgName();
        setEcount();
        setType();
        if (RequestsQueue.status) System.out.println("     Адрес: ");
        setStreet();
        setZip();

        product.setCoordinates(coordinates);
        organization.setOfficialAddress(address);
        base.NewID(organization);
        product.setManufacturer(organization);
        base.NewID(product);
        product.NewCreationDate();

        return product;
    }


}
