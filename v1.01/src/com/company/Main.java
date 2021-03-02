package com.company;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;


public class Main implements ICommands{

    public static void main(String[] args) {
	// write your code here
        //ICommands.help();

        List <Product> products = new ArrayList<>();


        Scanner myConsole = new Scanner(System.in);
        Scanner Field = new Scanner(System.in);
        boolean ConsoleRunning = true;

        while (ConsoleRunning){
            String command = myConsole.next();

            switch (command.toLowerCase()){
                case "help":
                    ICommands.help();
                    break;
                case "info":
                    ICommands.info(products);
                    break;
                case "show":
                    ICommands.show(products);
                    break;
                case "add":
                    ICommands.add(products);
                    break;
                case "update":
                    System.out.print("Введите id: ");
                    try{
                        int id = Console.nextInt();
                        ICommands.update(products, id);
                    } catch (Exception e){
                        System.out.println("Некорректные данные");
                    }
                    break;
                case "remove_by_id":
                    System.out.print("Введите id: ");
                    int id = Console.nextInt();
                    ICommands.remove_by_id(products, id);
                    break;
                case "clear":
                    ICommands.clear(products);
                    break;
                case "save":
                    ICommands.save();
                    break;
                case "execute_script":
                    ICommands.execute_script();
                    break;
                case "exit":
                    ConsoleRunning = ICommands.exit();
                    break;
                case "add_if_max":
                    ICommands.add_if_max();
                    break;
                case "shuffle":
                    ICommands.shuffle();
                    break;
                case "remove_greater":
                    ICommands.remove_greater();
                    break;
                case "average_of_price":
                    ICommands.average_of_price(products);
                    break;
                case "count_by_manufacture_cost":
                    System.out.println("Введите цену производства (число с плавающей точкой)");
                    float cost = 0;
                    try{
                        cost = Field.nextFloat();
                        ICommands.count_by_manufacture_cost(products, cost);
                    } catch (Exception e){
                        System.out.println("Некорректные данные");
                    }
                    break;
                case "count_less_than_manufacture_cost":
                    System.out.println("Введите цену производства (число с плавающей точкой)");
                    float costLess = 0;
                    try{
                        costLess = Field.nextFloat();
                        ICommands.count_less_than_manufacture_cost(products, costLess);
                    } catch (Exception e){
                        System.out.println("Некорректные данные");
                    }
                    break;
                default:
                    System.out.println("К сожалению такой комманды не существует");

            }
        }

        System.exit(0);



    }





}
