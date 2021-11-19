/*
 * CSC-251 and CTS 285
 * Brick Block
 * In Collaberation of Brandon Alder, Nicholas Baxley, and Alexander Burnette
 * Version 9
 * Working on the main part of the project to where the user can buy the bricks.
 * Started on Oct 18, 2021 Updated on Nov 19, 2021
 */

package project;
import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Project {
    
    // STORES.get(0) = Home Depot, STORES.get(1) = Lowes, STORES.get(2) = BuildClub
    // STORES.get(0).bricks.get(0) First brick in Home Depot, STORES.get(0).bricks.get(1) Second brick in Home Depot, etc...
    final static List<BrickStore> STORES = createStores();
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
        boolean loop = true;
        int storeIndex;
        
         // Option to put in JOption pane   
        while(loop){
            System.out.println("\nChoose a store to view their bricks"
                    + "\n"
                    + PATTERN1
                    + "\n1. Home Depot"
                    + "\n2. Lowes"
                    + "\n3. The BuildClub"
                    + "\n4. Exit");
            String choice = scnr.next();
            storeIndex = -1;       
            switch(choice)
            {
                case "1":
                    storeIndex = 0;
                    break;
                case "2":
                    storeIndex = 1;
                    break;
                case "3":
                    storeIndex = 2;
                    break;
                case "4":
                    loop = false;
                    menu();
                    break;
                default:
                    System.out.println("Please choose between 1 - 4.");
                    break;
            }  
            
            if (storeIndex != -1)
            {
                BrickStore selectedStore = STORES.get(storeIndex);
                System.out.println("\nBelow are the prices for all bricks at " 
                                   + selectedStore.name);
                System.out.printf("%-21s","Name");
                System.out.printf("%-8s","Type");
                System.out.printf("%-11s","Length");
                System.out.printf("%-8s","Height");
                System.out.print("Cost Per Brick");
                System.out.println("\n" + PATTERN2 + PATTERN2);
                for (int brickIndex = 0; brickIndex < selectedStore.bricks.size(); brickIndex++)
                {
                    Brick currentBrick = selectedStore.bricks.get(brickIndex);
                    currentBrick.getInfo();
                }  
            }        
        }
    }
    
    public static void quote(){
        Scanner scnr = new Scanner(System.in);
        String choice;
        boolean loop = true;
        int storeIndex;
         // Option to put in JOption pane               
        while(loop){
            System.out.println("\nWhat store do you want to buy from?"
                + "\n"
                + PATTERN1
                + "\n1. Home Depot"
                + "\n2. Lowes"
                + "\n3. The Buildclub"
                + "\n4. Main Menu");
            choice = scnr.next();
            storeIndex = -1;
            switch(choice)
            {
                case "1": 
                    storeIndex = 0;
                    break;
                case "2":
                    storeIndex = 1;
                    break;
                case "3":
                    storeIndex = 2;
                    break;
                case "4":
                    loop = false;
                    menu();
                    break;
                default:
                    System.out.println("Please choose between 1 - 4.");
                    break;
            }
            if (storeIndex != -1)
            {           
                String brickType = "";
                while(loop)
                {
                    System.out.println("\nWhat type of bricks do you want?"
                                    + "\n" + PATTERN1
                                    + "\n1. Brick"
                                    + "\n2. Veneer"
                                    + "\n3. Paver");
                    choice = scnr.next();  
                    switch(choice)
                    {
                        case "1": 
                            loop = false;
                            brickType = "Brick";
                            break;
                        case "2":
                            loop = false;
                            brickType = "Veneer";
                            break;
                        case "3":
                            loop = false;
                            brickType = "Paver";
                            break;
                        default:
                            System.out.println("Please choose between 1 - 3.");
                            break;
                    }
                }
                
                List<Brick> validBricks = new ArrayList<>();
                int count = 0;
                BrickStore selectedStore = STORES.get(storeIndex);
                System.out.println("\nBelow are the prices for all " 
                                   + brickType 
                                   + " at "
                                   + selectedStore.name
                                   + "\n" + PATTERN2);
                
                // Displaying all bricks of the requested type from the requested store
                for (int brickIndex = 0; brickIndex < selectedStore.bricks.size(); brickIndex++)
                {
                    Brick currentBrick = selectedStore.bricks.get(brickIndex);
                    if (currentBrick.type.equals(brickType))
                    {
                        count++;
                        validBricks.add(currentBrick);
                        System.out.print("" + count + "| ");
                        currentBrick.getInfo();                        
                    }            
                }
                
                boolean brickLoop = true;
                String brickChoice = "a";
                // Asking what bricks out of the avaliable bricks the user wants to buy
                while(brickLoop)
                {
                    System.out.println("\nWhich " + brickType + " would you like to buy?");
                    brickChoice = scnr.next();
                    if(!isNumber(brickChoice))
                    {
                        System.out.println("Please enter a number!");
                    }
                    else if(Integer.parseInt(brickChoice) < 1 || Integer.parseInt(brickChoice) > validBricks.size())
                    {
                        System.out.println("Enter a number from 1 to " + validBricks.size() + "!");
                    }
                    else
                    {
                        brickLoop = false;
                    }
                }
                Brick boughtBrick = validBricks.get(Integer.parseInt(brickChoice) - 1);
                        
                // Asking how many pallets the user wants   
                boolean palletLoop = true;
                String palletChoice = "a";
                while(palletLoop)
                {
                    System.out.println("\nHow many pallets would you like to buy? (Pallet = 100 bricks)");
                    palletChoice = scnr.next();
                    if(!isNumber(palletChoice))
                    {
                        System.out.println("Please enter a number!");
                    }
                    else
                    {
                        palletLoop = false;
                    }
                }
                
                // Showing total cost for the pallets of bricks the user requested.
                System.out.println("\n" + PATTERN2);
                System.out.println("Store:    " + selectedStore.name);
                System.out.println("Brick:    " + selectedStore.bricks.get(Integer.parseInt(brickChoice)).name);
                System.out.println("Pallets:  " + palletChoice);
                System.out.print("Cost:     $");
                System.out.printf("%.2f", boughtBrick.getPalletCost(Integer.parseInt(palletChoice)));
                System.out.println("\n" + PATTERN2);
                
                quote();
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
    
    // Make a list of all the stores and their bricks for global use though
    // out the program
    public static List<BrickStore> createStores() 
    { 
        // Making all bricks in Home Depot
        BrickStore homesDepot = new BrickStore("Homes Depot");
        homesDepot.addBrick(new Brick("Gray Castle Bricks", "Brick", 28, 10.50, 1.50)); 
        homesDepot.addBrick(new Brick("Brickwebb Cafe Mocha", "Brick", 28, 10.50, 1.69)); 
        homesDepot.addBrick(new Brick("Castle Gate Thin", "Veneer", 7.62, 2.25, 1.32));
        homesDepot.addBrick(new Brick("Glacier Bay Thin", "Veneer", 7.62, 2.25, 2.11));       
        homesDepot.addBrick(new Brick("Mission Tumbled", "Paver", 8, 4, 2.74));
        homesDepot.addBrick(new Brick("Brick Red Clay", "Paver", 8, 4, 4.78));
        
        // Making all bricks in Lowes
        BrickStore lowes = new BrickStore("Lowes");
        lowes.addBrick(new Brick("Broadmeadow Glazed Procelain", "Brick", 8, 4, .89));
        lowes.addBrick(new Brick("Clay Red Cored", "Brick", 7.62, 3.5, .86));        
        lowes.addBrick(new Brick("Faux Charcoal Panels", "Veneer", 5.45, 4.75, 2.44));
        lowes.addBrick(new Brick("Chicago Red Light Grout", "Veneer", 9.5, 2.72, 2.34));     
        lowes.addBrick(new Brick("Holland Red Paver", "Paver", 8, 4, .58));
        lowes.addBrick(new Brick("Holland Grey Paver", "Paver", 8, 4, .56));
        
        // Making all bricks in BuildClub
        BrickStore buildClub = new BrickStore("The BuildClub");
        buildClub.addBrick(new Brick("Brickwebb Sagebrush Thin", "Brick", 28, 10.50, 2.39));
        buildClub.addBrick(new Brick("Brickwebb Seaside", "Brick", 28, 10.50, 2.21));       
        buildClub.addBrick(new Brick("Chicago Brick Veneer", "Veneer", 7.5, 2.8, 2.06));
        buildClub.addBrick(new Brick("Concrete Americana Red", "Veneer", 8, 2.25, 1.65));      
        buildClub.addBrick(new Brick("Rustic Red Clay", "Paver", 8, 4, 5.25));
        buildClub.addBrick(new Brick("Relic Red clay", "Paver", 6, 1.63, 2.62));
        
        // Adding all stores to one list and returning them
        List<BrickStore> allStores = new ArrayList<>();
        allStores.add(homesDepot);
        allStores.add(lowes);
        allStores.add(buildClub);
        return allStores;   
    }
    
    // Needed for some switch statement checks
    public static boolean isNumber(String number)
    {
        try
        {
            int t = Integer.parseInt(number);
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
}