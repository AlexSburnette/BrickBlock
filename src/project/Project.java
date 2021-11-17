/*
 * CSC-251 and CTS 285
 * Brick Block
 * In Collaberation of Brandon Alder, Nicholas Baxley, and Alexander Burnette
 * Version 8
 * Working on the main part of the project to where the user can buy the bricks.
 * Started on Oct 18, 2021 Updated on Nov 17, 2021
 */
package project;
import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;
public class Project {
    
    // Need to add properly length and heigth to each set of bricks.
    // Brick("Length","Heigth","Cost")
    final static Brick HOME = new Brick(1,1,0.70);
    final static Brick LOWES = new Brick(1,1,0.65);
    final static Brick BUILD = new Brick(1,1,0.59);
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
         // Option to put in JOption pane   
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
         // Option to put in JOption pane   
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
                    System.out.printf("\nLowes bricks are $%.2f per brick.\n", LOWES.getCostPerBrick());
                    type();
                    break;
                case "2":
                    loop = false;
                    System.out.printf("\nHome Depot bricks are $%.2f per brick.\n", HOME.getCostPerBrick());
                    type();
                    break;
                case "3":
                    loop = false;
                    System.out.printf("\nThe Buildclub bricks are $%.2f per brick.\n", BUILD.getCostPerBrick());
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
        String answer;
        boolean loop = true;
         // Option to put in JOption pane               
        while(loop){
            System.out.println("\nWhich one would you like to choose?"
                + "\n"
                + PATTERN1
                    //Change for 100 per pallet. There should be a change for the 100 brick.
                + "\nBricks are sold as a set of 100 per pallet."
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
                   // calculatePalletCost("Lowes", LOWES.getCostPerBrick());  
                    System.out.println("You picked Lowes"
                            + "\nWhat wouuld you like to look at?"
                            + "\n1. Bricks"
                            + "\n2. Veneers"
                            + "\n3. Pavers"
                            + "\n.4 Back to Quotes");
                    answer = scnr.next();
                    switch(answer)
                    {
                        case "1":
                            System.out.println("We have two different type of bricks."
                                    + "/n8in x 4in for $0.65 per brick"
                                    + "/n7.62in x 3.5in for $0.86 per brick");
                            break;
                        case "2":
                            System.out.println("We have two different types of veneers."
                                    + "/nOld Mill Thin Brick 12 bricks per sheet. Each sheet is 28in W x 10.5in H for $101.56 per 5 sheets"
                                    + "/nAntico Elements Faux Brick covers about 9 Sq feet per sheet. Each sheet is 47.5 in x 27.25 for $122.54 per sheet");
                            break;
                        case "3":
                            System.out.println("We have two different types of pavers"
                                    + "/n8in x 4in for $0.56 per paver brick"
                                    + "/n4in x 8in for $0.44 per paver brick");
                            break;
                        case "4":
                            quote();
                            break;
                        default:
                            System.out.println("Please choose 1-4");
                            break;
                    }
                    break;
                case "2":
                    //calculatePalletCost("Home Depot", HOME.getCostPerBrick());
                    System.out.println("You picked Home Depot"
                            + "\nWhat wouuld you like to look at?"
                            + "\n1. Bricks"
                            + "\n2. Veneers"
                            + "\n3. Pavers"
                            + "\n.4 Back to Quotes");
                    answer = scnr.next();
                    switch(answer)
                    {
                        case "1":
                            System.out.println("We have two different type of bricks."
                                    + "/n7.62in x 3.56in for $0.70 per brick"
                                    + "/n3.62in x 8in for $0.80 per brick");
                            break;
                        case "2":
                            System.out.println("We have two different types of veneers"
                                    + "/nOld Mill Brick 12 bricks per sheet. Each sheet is 28in x 10.5in for $101.56 per 5 sheets."
                                    + "/nBrickwebb brick sheets 12 bricks per sheet. Each sheet is 28in x 10in for $119.00 per 5 sheets.");
                            break;
                        case "3":
                            System.out.println("We have two different types of pavers"
                                    + "/n"
                                    + "/n");
                            break;
                        case "4":
                            quote();
                            break;
                        default:
                            System.out.println("Please choose 1-4");
                            break;
                    }
                    break;
                case "3":
                    //calculatePalletCost("The Buildclub", BUILD.getCostPerBrick());
                    System.out.println("You picked Lowes"
                            + "\nWhat wouuld you like to look at?"
                            + "\n1. Bricks"
                            + "\n2. Veneers"
                            + "\n3. Pavers"
                            + "\n.4 Back to Quotes");
                    answer = scnr.next();
                    switch(answer)
                    {
                        case "1":
                            break;
                        case "2":
                            break;
                        case "3":
                            break;
                        case "4":
                            quote();
                            break;
                        default:
                            System.out.println("Please choose 1-4");
                            break;
                    }
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
        String answer;
        getCustomerName();
        Brick customerBricks;
         // Option to put in JOption pane   
        System.out.println("Where would you like to get your order from?"
                + "\n1. Lowes"
                + "\n2. Home Depot"
                + "\n3. The Buildclub"
                + "\n4. Main Menu");
        choices = scnr.next();
        switch(choices)
        {
            case "1":
                System.out.println("You have chosen Lowes for your order");
                //customerBricks = LOWES;
                System.out.println(""
                        + "What would you like to order"
                        + "\n1. Bricks"
                        + "\n2. Veneers"
                        + "\n3. Pavers"
                        + "\n4. Go back");
                answer = scnr.next();
                switch(answer)
                {
                    case "1":
                        System.out.println(""
                                + "You have chosen bricks");
                        break;
                    case "2":
                        System.out.println("You have chosen veeners");
                        break;
                    case "3":
                        System.out.println("You have chosen pavers");
                        break;
                    case "4":
                        real();
                        break;
                    default:
                        break;
                }
                break;
            case "2":
                System.out.println("You have chosen Home Depot for your order");
                //customerBricks = HOME;
                System.out.println(""
                        + "What would you like to order"
                        + "\n1. Bricks"
                        + "\n2. Veneers"
                        + "\n3. Pavers"
                        + "\n4. Go back");
                answer = scnr.next();
                 switch(answer)
                {
                    case "1":
                        System.out.println(""
                                + "You have chosen bricks");
                        break;
                    case "2":
                        System.out.println("You have chosen veeners");
                        break;
                    case "3":
                        System.out.println("You have chosen pavers");
                        break;
                    case "4":
                        real();
                        break;
                    default:
                        break;
                }
                break;
            case "3":
                System.out.println("You have chosen The Buildclub for your brick order");
                //customerBricks = BUILD;
                System.out.println(""
                        + "What would you like to order"
                        + "\n1. Bricks"
                        + "\n2. Veneers"
                        + "\n3. Pavers"
                        + "\n4. Go back");
                answer = scnr.next();
                 switch(answer)
              {
                    case "1":
                        System.out.println(""
                                + "You have chosen bricks");
                        break;
                    case "2":
                        System.out.println("You have chosen veeners");
                        break;
                    case "3":
                        System.out.println("You have chosen pavers");
                        break;
                    case "4":
                        real();
                        break;
                    default:
                        break;
                }
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
        final int PER = 100;
        
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
    

    public static class Brick{
        int length;
        int height;
        double costPerBrick;
        
        public Brick(int Length, int Height, double CostPerBrick){
            length = Length;
            height = Height;
            costPerBrick = CostPerBrick;
        }
        
        public int getLength(){
            return length;
        }
        
        public int getHeight(){
            return height;
        }
        
        public double getCostPerBrick(){
            return costPerBrick;
        }
    }
    public static void printBill(int bricksNeeded, double brickPrice) throws FileNotFoundException
    {
        DecimalFormat format = new DecimalFormat("$#,###.00");
        double total = bricksNeeded * brickPrice;
        double tax = total * .07;
       
        String bill = "Bill for " + customerName + "\n"
                + PATTERN1 + "\n"
                + "BrickType - Total \n" // TODO - Fix brick type, add measurement and total
                + "x " + bricksNeeded + " @ " + format.format(brickPrice) + "\n"
                + PATTERN2 + "\n"
                + "Subtotal: " + format.format(total) +"\n"
                + "Tax: " + format.format(tax) + "\n"
                + PATTERN2 + "\n"
                + "Total: " + format.format(tax + total);
       
        try
        {
            PrintWriter writer = new PrintWriter(customerName + "Bill.txt");
            writer.print(bill);
            writer.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Could not create file.");
        }
        catch(Exception ee)
        {
            System.out.println("Error.");
        }
    }

}