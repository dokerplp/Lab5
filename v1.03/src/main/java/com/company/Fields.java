package com.company;

import com.company.data.Organization;
import com.company.data.Product;

import java.time.ZonedDateTime;

public class Fields {

    private int ProdLastId = 649432;
    public int getProdLastId() {
        return ProdLastId;
    }
    public void setProdLastId(int prodLastId) {
        ProdLastId = prodLastId;
    }
    public void NewID(Product product){
        ProdLastId++;
        product.setId(ProdLastId);
    }

    private int OrgLastId = 563592;
    public int getOrgLastId() {
        return OrgLastId;
    }
    public void setOrgLastId(int orgLastId) {
        OrgLastId = orgLastId;
    }
    public void NewID(Organization organization){
        OrgLastId++;
        organization.setId(OrgLastId);
    }


    private ZonedDateTime LastInit = null;
    public String getLastInit() {
        if (LastInit == null) return "Еще не было инициализации";
        else return LastInit.toString();
    }
    public void setLastInit() {
        LastInit = ZonedDateTime.now();
    }

    private ZonedDateTime LastSave = null;
    public String getLastSave() {
        if (LastSave == null) return "Еще не было сохранения";
        else return LastSave.toString();
    }
    public void setLastSave() {
        LastSave = ZonedDateTime.now();
    }

    private static int RecursionCounter = 0;

    /**
     * Increments counter
     */
    public static void RecPlus(){
        RecursionCounter++;
    }

    /**
     * Makes counter equal 0
     */
    public static void Putin(){
        RecursionCounter = 0;
    }




}
