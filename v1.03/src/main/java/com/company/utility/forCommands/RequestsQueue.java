package com.company.utility.forCommands;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class RequestsQueue {

    private final Queue<String> request = new ArrayDeque<>();

    public void pushOne(String line){
        request.add(line);
        ElementAmount += 1;
    }

    public void pushAll(List<String> list){
        request.addAll(list);
        ElementAmount += list.size();
    }

    public String pollOne(){
        ElementAmount -= 1;
        return request.poll();
    }

    private int ElementAmount = 0;
    public int getElementAmount() {
        return ElementAmount;
    }
    public void setElementAmount(int elementAmount) {
        ElementAmount = elementAmount;
    }

    private boolean Status = true;
    public boolean isStatus() {
        return Status;
    }
    public void setStatus(boolean status) {
        Status = status;
    }
}
