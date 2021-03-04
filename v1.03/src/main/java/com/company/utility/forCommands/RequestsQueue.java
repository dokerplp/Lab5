package com.company.utility.forCommands;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class RequestsQueue {

    private final static Queue<String> request = new ArrayDeque<>();
    public static int getElemntAmount() {
        return elemntAmount;
    }
    private static int elemntAmount = 0; //Переделать!!!!!

    public static boolean status = true;
    //human - true, script - false

    public static void pushOne(String line){
        request.add(line);
        elemntAmount += 1;
    }

    public static void pushAll(List<String> list){
        request.addAll(list);
        elemntAmount += list.size();
    }

    public static String pollOne(){
        elemntAmount -= 1;
        return request.poll();
    }


}
