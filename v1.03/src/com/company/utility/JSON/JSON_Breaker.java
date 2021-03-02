package com.company.utility.JSON;
import java.io.IOException;
import java.nio.file.*;
import java.time.ZonedDateTime;
import java.util.*;
import java.io.*;

import com.company.Data.*;
import com.company.utility.ForData.DataOperator;
import com.company.exceptions.*;
import com.company.exceptions.IncorrectDataException;
import com.fasterxml.jackson.databind.*;

/**
 * Class for converting json file to Product Class
 */
public class JSON_Breaker {

    String path;
    List<Product> products;

    /**
     * Constructor
     * @param products - collection
     * @throws IOException if you have problems with file
     */
    public JSON_Breaker(List<Product> products) throws IOException {

        this.products = products;

        path = System.getenv("LAB");
        if (path == null) throw new EnvVarDoesNotExistException();
        File DJEYSON = new File(path);
        if (!DJEYSON.exists()) throw new FileDoesNotExistException();
        if (DJEYSON.isDirectory()) throw new IsDirException();
        String[] kostyl = path.split("\\.");
        if (!kostyl[kostyl.length - 1].equals("json")) throw new NotJsonException();
        if (!DJEYSON.canRead()) throw new CantReadException();

        Path newPath = Paths.get(path);
        Scanner scanner = new Scanner(newPath);
        String json = "";
        while (scanner.hasNext()) json += scanner.next();

        JSONtoProduct(json);

    }

    /**
     * Method divides list of products into products objects
     * @param json - file contents
     * @throws IOException if you have problem with your file
     */
    public void JSONtoProduct(String json) throws IOException {

        List<HashMap<String, Object>> list = new ObjectMapper().readValue(json, List.class);
        DataOperator operator = new DataOperator();

        for (HashMap<String, Object> it : list){

            try {
                Product product = transform(it, operator);
                if (product.correct(products)) products.add(product);
                else throw new IncorrectDataException();
            } catch (IncorrectDataException e){
                System.out.println("Продукт не добпален - данные не прошли проверку");
            } catch (Exception e) {
                System.out.println("Продукт не добпален - некорректные данные");
            }

        }
    }

    /**
     * Transform json object into Product object
     * @param it - Map of Product fields
     * @param operator - data operator
     * @return done Product Object ot Exception
     * @throws Exception if something went wrong
     */
    private Product transform(HashMap<String, Object> it, DataOperator operator) throws Exception{
        Product product = new Product();
        product.setId(operator.StringToInt((String) it.get("id")));
        product.setName((String) it.get("name"));
        Coordinates coordinates = new Coordinates();
        HashMap<String, Object> op = (HashMap) it.get("coordinates");
        coordinates.setX(operator.StringToFloat((String) op.get("x")));
        coordinates.setY(operator.StringToInt((String) op.get("y")));
        product.setCoordinates(coordinates);
        product.setCreationDate(ZonedDateTime.parse((String)it.get("creationDate")));
        product.setPrice(operator.StringToLong((String) it.get("price")));
        product.setPartNumber((String) it.get("partNumber"));
        product.setManufactureCost(operator.StringToFloat((String) it.get("manufactureCost")));
        product.setUnitOfMeasure(UnitOfMeasure.reverse((String) it.get("unitOfMeasure")));
        Organization organization = new Organization();
        HashMap<String, Object> or = (HashMap) it.get("manufacturer");
        organization.setId(operator.StringToInt((String) or.get("id")));
        organization.setName((String) or.get("name"));
        organization.setEmployeesCount(operator.StringToInt((String) or.get("employeesCount")));
        organization.setType(OrganizationType.reverse((String) or.get("type")));
        Address address = new Address();
        HashMap<String, Object> ad = (HashMap) or.get("address");
        address.setStreet((String) ad.get("street"));
        address.setZipCode((String) ad.get("zipCode"));
        organization.setOfficialAddress(address);
        product.setManufacturer(organization);

        return product;
    }



}
