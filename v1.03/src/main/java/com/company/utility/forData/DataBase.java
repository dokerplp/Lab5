package com.company.utility.forData;

import com.company.Fields;
import com.company.data.Organization;
import com.company.data.Product;
import com.company.utility.forCommands.RequestsQueue;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Queue;

/**
 * Contains collection
 */
public class DataBase {


//    private int ProdLastId = 649432;
//    public int getProdLastId() {
//        return ProdLastId;
//    }
//    public void setProdLastId(int prodLastId) {
//        ProdLastId = prodLastId;
//    }
//    public void NewID(Product product){
//        ProdLastId++;
//        product.setId(ProdLastId);
//    }
//
//    private int OrgLastId = 563592;
//    public int getOrgLastId() {
//        return OrgLastId;
//    }
//    public void setOrgLastId(int orgLastId) {
//        OrgLastId = orgLastId;
//    }
//    public void NewID(Organization organization){
//        OrgLastId++;
//        organization.setId(OrgLastId);
//    }
//
//
//    private ZonedDateTime LastInit = null;
//    public String getLastInit() {
//        if (LastInit == null) return "Еще не было инициализации";
//        else return LastInit.toString();
//    }
//    public void setLastInit() {
//        LastInit = ZonedDateTime.now();
//    }
//
//    private ZonedDateTime LastSave = null;
//    public String getLastSave() {
//        if (LastSave == null) return "Еще не было сохранения";
//        else return LastSave.toString();
//    }
//    public void setLastSave() {
//        LastSave = ZonedDateTime.now();
//    }


    private final List<Product> products;
    private final RequestsQueue queue;
    private final Fields fields;

    /**
     * Constructor
     * @param products - collection
     */
    public DataBase(List<Product> products, RequestsQueue queue, Fields fields){
        this.products = products;
        this.queue = queue;
        this.fields = fields;
    }

    /**
     * Collection getter
     * @return collection
     */
    public List<Product> getBase(){
        return products;
    }

    public RequestsQueue getQueue(){
        return queue;
    }

    public Fields getFields(){
        return fields;
    }

}
