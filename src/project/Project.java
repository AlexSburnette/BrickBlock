/*
 * CSC-251 and CTS 285
 * Brick Block
 * In Collaberation of Brandon Alder, Nicholas Baxley, and Alexander Burnette
 * Version 8
 * Working on the main part of the project to where the user can buy the bricks.
 * Started on Oct 18, 2021 Updated on Nov 15, 2021
 */
package project;
import java.util.Scanner;
import java.io.*;
public class Project {
    
    final static double HOME = 0.70;
    final static double LOWES = 0.65;
    final static double BUILD = 0.59;
    final static String PATTERN1 = "==============================";
    final static String PATTERN2 = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    static String customerName;
    
    public static void main(String[] args)
    {
        menu();
    }
    
    public static void menu(){
        Scanner scnr = new Scanner(System.in); 
        String choice;
        boolean loop = true;
        
        System.out.println("\nWelcome to Brick Block.");
        
        // Gets client's name
        getCustomerName();
        
        while(loop)
        {
             System.out.println(PATTERN1
                + "\n1. Places to buy bricks"
                + "\n2. Quotes"
                + "\n3. Real Deal"
                + "\n4. Exit");

            choice = scnr.next();
            switch(choice)
            {
                case "1":
                    loop = false;
                    type();       
                    break;
                case "2":
                    loop = false;
                    quote();
                    break;
                case "3":
                    loop = false;
                    real(); 
                    break;
                case "4":
                    loop = false;
                    System.out.println("Have a nice day!!");
                    break;
                default:
                    System.out.println("Please choose between 1 - 4.");
                    break;
            }
        }
        
        
    }
    public static void type(){
        Scanner scnr = new Scanner(System.in); 
        String choice;
        boolean loop = true;
        
        while(loop){
            System.out.println("\nPrice per Brick"
                    + "\n1. Lowes"
                    + "\n2. Home Depot"
                    + "\n3. The BuildClub"
                    + "\n4. Exit");
            choice = scnr.next();
            switch(choice)
            {
                case "1":
                    loop = false;
                    System.out.printf("\nLowes bricks are $%.2f per brick.\n", LOWES);
                    type();
                    break;
                case "2":
                    loop = false;
                    System.out.printf("\nHome Depot bricks are $%.2f per brick.\n", HOME);
                    type();
                    break;
                case "3":
                    loop = false;
                    System.out.printf("\nThe Buildclub bricks are $%.2f per brick.\n", BUILD);
                    type();
                    break;
                case "4":
                    loop = false;
                    menu();
                    break;
                default:
                    System.out.println("Please choose between 1 - 4.");
                    break;
            }
        }
    }
    public static void quote(){
        Scanner scnr = new Scanner(System.in);
        String choice;
        boolean loop = true;
                        
        while(loop){
            System.out.println("\nWhich one would you like to choose?"
                + "\n"
                + PATTERN1
                + "\nBricks are sold as a set of 500 per pallet."
                + "\n"
                + PATTERN2
                + "\n1. Lowes"
                + "\n2. Home Depot"
                + "\n3. The Buildclub"
                + "\n4. Main Menu");
            choice = scnr.next();
            switch(choice)
            {
                case "1":
                    calculatePalletCost("Lowes", LOWES);   
                    break;
                case "2":
                    calculatePalletCost("Home Depot", HOME);
                    break;
                case "3":
                    calculatePalletCost("The Buildclub", BUILD);
                    break;
                case "4":
                    loop = false;
                    menu();
                    break;
                default:
                    System.out.println("Please choose between 1 - 4.");
                    break;
            }
        }
    }
    
    // TODO - Calculate how much it would cost to replace all bricks around
    // the school walls.
    public static void real(){
        Scanner scnr = new Scanner(System.in);
        String choices;
        getCustomerName();
        
        System.out.println("Where would you like to get your bricks from?"
                + "\n1. Lowes"
                + "\n2. Home Depot"
                + "\n3. The Buildclub"
                + "\n4. Main Menu");
        choices = scnr.next();
        switch(choices)
        {
            case "1":
                System.out.println("You have chosen Lowes for your brick order");
                break;
            case "2":
                System.out.println("You have chosen Home Depot for your brick order");
                break;
            case "3":
                System.out.println("You have chosen The Buildclub for your brick order");
                break;
            case "4":
                menu();
                break;
            default:
                System.out.println("Please choose 1-4");
                break;
        }
         
    }   
    
    public static void getCustomerName()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Hello, please enter your name: ");
        customerName = keyboard.nextLine();
    }
    // Takes a name and cost of a single brick as input, and 
    // displays the cost of a pallet for that company.
    public static void calculatePalletCost(String name, double brickCost){
        double total;
        int pallet;
        Scanner scnr = new Scanner(System.in);
        final int PER = 500;
        
        System.out.printf("\nYou have chosen %s for your bricks.\n", name);
        System.out.println("How many pallets do you need?");
        
        //TODO - Validate to make sure user inputs int, crashes if anything 
        //else is inputted.
        pallet = scnr.nextInt();
        
        System.out.println();
        System.out.println("You entered " + pallet + " pallet(s).");
        
        total=brickCost*PER*pallet;
        
        System.out.println(PATTERN1); 
        System.out.printf("Your quote is $%.2f", total);
        System.out.println("."); 
        System.out.println(PATTERN1); 
    }
}