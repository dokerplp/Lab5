package com.company.exceptions;

/**
 * Throws if there are more then 100 execute script commands in script
 */
public class InfinityRecursionException extends RuntimeException{

    private static int RecursionCounter = 0; //Переделать!!!!!

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

    /**
     * Checking amount of recursions
     * @throws InfinityRecursionException if it need
     */
    public static void newRec() throws InfinityRecursionException{
        if (RecursionCounter >= 100) throw new InfinityRecursionException();
        else RecPlus();
    }

    @Override
    public String toString() {
        return "Произошла рекурсия, просьба разойтись, мероприятие незаконно";
    }
}
