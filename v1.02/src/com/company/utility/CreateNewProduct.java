package com.company.utility;

import com.company.Data.Address;
import com.company.Data.Coordinates;
import com.company.Data.Organization;
import com.company.Data.Product;
import com.company.exceptions.IncorrectDataException;

import java.util.List;

/**
 * Creating Product
 */
public class CreateNewProduct extends ProductOperator {

    private final Product product;
    private final Coordinates coordinates = new Coordinates();
    private final Organization organization = new Organization();
    private final Address address = new Address();


    /**
     * Constructor for add command
     * @param products - collection
     */
    public CreateNewProduct(List<Product> products) {
        super(products);
        product = new Product();
    }

    /**
     * Constructor dor update command
     * @param product - Updatable product
     */
    public CreateNewProduct(Product product){
        super(null);
        this.product = product;
    }

    /**
     * Recursive asker of correct product name
     */
    public void setName(){
        try {
            product.setName(getName());
        } catch (IncorrectDataException e){
            setName();
        }
    }

    /**
     * Recursive asker of correct x coordinate
     */
    public void setX(){
        try {
            coordinates.setX(getX());
        } catch (IncorrectDataException e){
            setX();
        }
    }

    /**
     * Recursive asker of correct y coordinate
     */
    public void setY(){
        try {
            coordinates.setY(getY());
        } catch (IncorrectDataException e){
            setY();
        }
    }

    /**
     * Recursive asker of correct product price
     */
    public void setPrice(){
        try{
            product.setPrice(getPrice());
        } catch (IncorrectDataException e){
            setPrice();
        }
    }

    /**
     * Recursive asker of correct product part number
     */
    public void setPartNumber(){
        try{
            product.setPartNumber(getPartNumber());
        } catch (IncorrectDataException e){
            setPartNumber();
        }
    }

    /**
     * Recursive asker of correct product manufacture cost
     */
    public void setMCost(){
        try{
            product.setManufactureCost(getMCost());
        } catch (IncorrectDataException e){
            setMCost();
        }
    }

    /**
     * Recursive asker of correct product Unit of Measure
     */
    public void setMeasure(){
        try{
            product.setUnitOfMeasure(getMeasure());
        } catch (IncorrectDataException e){
            setMeasure();
        }
    }

    /**
     * Recursive asker of correct organization name
     */
    public void setOrgName(){
        try{
            organization.setName(getOrgName());
        } catch (IncorrectDataException e){
            setOrgName();
        }
    }

    /**
     * Recursive asker of correct organization employees count
     */
    public void setEcount(){
        try{
            organization.setEmployeesCount(getEcount());
        } catch (IncorrectDataException e){
            setEcount();
        }
    }

    /**
     * Recursive asker of correct organization type
     */
    public void setType(){
        try{
            organization.setType(getType());
        } catch (IncorrectDataException e){
            setType();
        }
    }

    /**
     * Recursive asker of correct organization street
     */
    public void setStreet(){
        try{
            address.setStreet(getStreet());
        } catch (IncorrectDataException e){
            setStreet();
        }
    }

    /**
     * Recursive asker of correct organization zip code
     */
    public void setZip(){
        try{
            address.setZipCode(getZip());
        } catch (IncorrectDataException e){
            setZip();
        }
    }

    /**
     * Run all recursive methods (for humans only)
     * @return done Product object
     */
    public Product HumanMode(){
        setName();
        System.out.println("Координаты: ");
        setX();
        setY();
        setPrice();
        setPartNumber();
        setMCost();
        setMeasure();
        System.out.println("Изготовитель: ");
        setOrgName();
        setEcount();
        setType();
        System.out.println("     Адрес: ");
        setStreet();
        setZip();

        product.setCoordinates(coordinates);
        organization.setOfficialAddress(address);
        organization.NewID();
        product.setManufacturer(organization);
        product.NewID();
        product.NewCreationDate();

        return product;
    }


}
