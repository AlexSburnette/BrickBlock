/*
 * CSC-251 and CTS 285
 * Brick Block
 * In Collaberation of Brandon Alder, Nicholas Baxley, and Alexander Burnette
 * Version 9
 * Working on the main part of the project to where the user can buy the bricks.
 * Started on Oct 18, 2021 Updated on Nov 19, 2021
 */

package project;
import java.awt.Color;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Project {
    
    // STORES.get(0) = Home Depot, STORES.get(1) = Lowes, STORES.get(2) = BuildClub
    // STORES.get(0).bricks.get(0) First brick in Home Depot, STORES.get(0).bricks.get(1) Second brick in Home Depot, etc...
    final static List<BrickStore> STORES = createStores();
    final static String PATTERN1 = "==============================";
    final static String PATTERN2 = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    final static double SALES_TAX = 0.07;
    final static JFrame FRAME = new JFrame();
    static boolean WELCOMED = false;
    static String customerName;
    
    public static void main(String[] args)
    {
        menu();
    }
    
    public static void menu(){
        Scanner scnr = new Scanner(System.in); 
        String choice;
        boolean loop = true;
        String menu = ("1. Places to buy bricks"
                   + "\n2. Quotes"
                   + "\n3. Project"
                   + "\n4. Custom Build"              
                   + "\n5. Exit");
        
        if (!WELCOMED){
            JOptionPane.showMessageDialog(null,"\nWelcome to Brick Block.");
            WELCOMED = true;
        }
        
        while(loop)
        {
            choice = JOptionPane.showInputDialog(null, menu, "Main Menu", JOptionPane.QUESTION_MESSAGE);
            if(choice == null)
            {
                exitDialog();
                choice = "";
            }
            
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
                    customOrders();
                    break;
                case "5":
                    exitDialog();
                default:
                    JOptionPane.showMessageDialog(null,"Please choose between 1 - 4.");
                    break;
            }
        }
            
    }
    public static void type(){
        Scanner scnr = new Scanner(System.in);
        boolean loop = true;
        int storeIndex;
        String menu = "1. Home Depot"
                  + "\n2. Lowes"
                  + "\n3. The BuildClub"
                  + "\n4. Exit";
        
        while(loop){
            String choice = JOptionPane.showInputDialog(null, menu, "Pick a store.", JOptionPane.QUESTION_MESSAGE);
            if(choice == null)
            {
                exitDialog();
                type();
            }
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
                    FRAME.setVisible(false);
                    menu();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Please choose between 1 - 4.");
                    break;
            }  
            
            if (storeIndex != -1)
            {
                BrickStore selectedStore = STORES.get(storeIndex);  
                int[] bounds = {100, 100, 700, 500};
                
                //Building model for the table
                DefaultTableModel model = new DefaultTableModel();
                Object[] col = {"Brick Name", "Type", "Length", "Height", "Cost Per Brick"};
                model.setColumnIdentifiers(col);
                for (int brickIndex = 0; brickIndex < selectedStore.bricks.size(); brickIndex++)
                {
                    Brick currentBrick = selectedStore.bricks.get(brickIndex);
                    model.addRow(new Object[]{currentBrick.name, currentBrick.type, currentBrick.length, currentBrick.height, String.format("$%.2f", currentBrick.costPerBrick)});  
                }  
          
                //Building table for the pane
                JTable table = new JTable();
                table.setModel(model);
                table.setRowHeight(30);
                table.setAutoCreateRowSorter(true);
                table.setFillsViewportHeight(true);
                
                //Building pane for the window frame
                JScrollPane pane = new JScrollPane(table);
                pane.setForeground(Color.red);
                pane.setBackground(Color.white);
                pane.setBounds(0, 0, bounds[2], bounds[3]);


                
                //Creating window frame
                FRAME.setTitle("Bricks in stock at " + selectedStore.name);
                FRAME.getContentPane().setBackground(Color.gray);
                FRAME.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
                FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                FRAME.getContentPane().setLayout(null);
                FRAME.setVisible(true);
                FRAME.getContentPane().add(pane);
          
            }        
        }
    }
    
    public static void quote(){
        Scanner scnr = new Scanner(System.in);
        String choice;
        boolean loop = true;
        int storeIndex;
        String menu = "What store do you want to buy from?"
                    + "\n"
                    + PATTERN1
                    + "\n1. Home Depot"
                    + "\n2. Lowes"
                    + "\n3. The Buildclub"
                    + "\n4. Main Menu";  
        
        while(loop){
            
            choice = JOptionPane.showInputDialog(null, menu, "Quote Menu", JOptionPane.QUESTION_MESSAGE);
            if(choice == null)
            {
                exitDialog();
                quote();
            }
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
                    JOptionPane.showMessageDialog(null,"Please choose between 1 - 4.");
                    break;
            }
            if (storeIndex != -1)
            {           
                String brickType = "";
                while(loop)
                {
                    choice = JOptionPane.showInputDialog("\nWhat type of bricks do you want?"
                                    + "\n" + PATTERN1
                                    + "\n1. Brick"
                                    + "\n2. Veneer"
                                    + "\n3. Paver");
                     
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
                            JOptionPane.showMessageDialog(null,"Please choose between 1 - 3.");
                            break;
                    }
                }
                
                List<Brick> validBricks = new ArrayList<>();
                int count = 0;
                BrickStore selectedStore = STORES.get(storeIndex);
                //needs JOption
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
                    brickChoice = JOptionPane.showInputDialog("\nWhich " + brickType + " would you like to buy?");
                    //After input in dialog, it needs another input on the console.
                    
                    if(!isNumber(brickChoice))
                    {
                        JOptionPane.showInputDialog("Please enter a number!");
                    }
                    else if(Integer.parseInt(brickChoice) < 1 || Integer.parseInt(brickChoice) > validBricks.size())
                    {
                        JOptionPane.showMessageDialog(null,"Enter a number from 1 to " + validBricks.size() + "!");
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
                    palletChoice = JOptionPane.showInputDialog("\nHow many pallets would you like to buy? (Pallet = 100 bricks)");
                
                    if(!isNumber(palletChoice))
                    {
                        JOptionPane.showMessageDialog(null,"Please enter a number!");
                    }
                    else
                    {
                        palletLoop = false;
                    }
                }
                
                // Showing total cost for the pallets of bricks the user requested.
                // Needs Joption.
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
        String menu = "Where would you like to get your order from?"
                    + "\n1. Lowes"
                    + "\n2. Home Depot"
                    + "\n3. The Buildclub"
                    + "\n4. Main Menu";
        //Brick customerBricks;
        Purchase cart = new Purchase();
        getCustomerName();
        cart.customerName = customerName;
        
        choices = JOptionPane.showInputDialog(null, menu, "Store Picker", JOptionPane.QUESTION_MESSAGE);
        if(choices == null)
        {
            exitDialog();
            real();
        }
        //choices = scnr.next();
        switch(choices)
        {
            case "1":
                JOptionPane.showMessageDialog(null,"You have chosen Lowes for your order");
                //customerBricks = LOWES;
                answer = JOptionPane.showInputDialog(""
                        + "What would you like to order"
                        + "\n1. Bricks"
                        + "\n2. Veneers"
                        + "\n3. Pavers"
                        + "\n4. Go back");
                
                switch(answer)
                {
                    case "1":
                        JOptionPane.showMessageDialog(null,""
                                + "You have chosen bricks\n");
                        
                        // Prints stores brick selection, gets user's choice and adds to cart
                        STORES.get(1).printBrickByType("Brick");
                        STORES.get(1).getBrickSelectionInput(cart, "Brick");
                        // Gets number of bricks needed and adds to cart
                        cart.quantity = getBricksNeeded(cart.brick);
                        // Displays receipt and prints to file
                        JOptionPane.showMessageDialog(null,cart.createReceipt());
                        cart.printReceipt();
                        break;
                    case "2":
                        JOptionPane.showMessageDialog(null,"You have chosen veeners");
                        STORES.get(1).printBrickByType("Veneer");
                        STORES.get(1).getBrickSelectionInput(cart, "Veneer");
                        cart.quantity = getBricksNeeded(cart.brick);
                        JOptionPane.showMessageDialog(null,cart.createReceipt());
                        cart.printReceipt();
                        break;
                        
                    case "3":
                        JOptionPane.showMessageDialog(null,"You have chosen pavers");
                        STORES.get(1).printBrickByType("Paver");
                        STORES.get(1).getBrickSelectionInput(cart, "Paver");
                        cart.quantity = getBricksNeeded(cart.brick);
                        JOptionPane.showMessageDialog(null,cart.createReceipt());
                        cart.printReceipt();
                        break;
                    case "4":
                        real();
                        break;
                    default:
                        break;
                }
                break;
            case "2":
                JOptionPane.showMessageDialog(null,"You have chosen Home Depot for your order");
                //customerBricks = HOME;
                answer = JOptionPane.showInputDialog(""
                        + "What would you like to order"
                        + "\n1. Bricks"
                        + "\n2. Veneers"
                        + "\n3. Pavers"
                        + "\n4. Go back");
                
                 switch(answer)
                {
                    case "1":
                        JOptionPane.showMessageDialog(null,""
                                + "You have chosen bricks");
                        // Prints stores brick selection, gets user's choice and adds to cart
                        STORES.get(0).printBrickByType("Brick");
                        STORES.get(0).getBrickSelectionInput(cart, "Brick");
                            
                        // Gets number of bricks needed and adds to cart
                        cart.quantity = getBricksNeeded(cart.brick);
                        JOptionPane.showMessageDialog(null,cart.createReceipt());
                        cart.printReceipt();
                        break;
                    case "2":
                        JOptionPane.showMessageDialog(null,"You have chosen veeners");
                        STORES.get(0).printBrickByType("Veneer");
                        STORES.get(0).getBrickSelectionInput(cart, "Veneer");
                        cart.quantity = getBricksNeeded(cart.brick);
                        JOptionPane.showMessageDialog(null,cart.createReceipt());
                        cart.printReceipt();
                        break;
                    case "3":
                        JOptionPane.showMessageDialog(null,"You have chosen pavers");
                        STORES.get(0).printBrickByType("Paver");
                        STORES.get(0).getBrickSelectionInput(cart, "Paver");
                        cart.quantity = getBricksNeeded(cart.brick);
                        JOptionPane.showMessageDialog(null,cart.createReceipt());
                        cart.printReceipt();
                        break;
                    case "4":
                        real();
                        break;
                    default:
                        break;
                }
                break;
            case "3":
                JOptionPane.showMessageDialog(null,"You have chosen The Buildclub for your brick order");
                //customerBricks = BUILD;
                answer = JOptionPane.showInputDialog(""
                        + "What would you like to order"
                        + "\n1. Bricks"
                        + "\n2. Veneers"
                        + "\n3. Pavers"
                        + "\n4. Go back");
                
                 switch(answer)
              {
                    case "1":
                        JOptionPane.showMessageDialog(null,""
                                + "You have chosen bricks");
                        STORES.get(2).printBrickByType("Brick");
                        STORES.get(2).getBrickSelectionInput(cart, "Brick");
                        cart.quantity = getBricksNeeded(cart.brick);
                        JOptionPane.showMessageDialog(null,cart.createReceipt());
                        cart.printReceipt();
                        break;
                    case "2":
                        JOptionPane.showMessageDialog(null,"You have chosen veeners");
                        STORES.get(2).printBrickByType("Veneer");
                        STORES.get(2).getBrickSelectionInput(cart, "Veneer");
                        cart.quantity = getBricksNeeded(cart.brick);
                        JOptionPane.showMessageDialog(null,cart.createReceipt());
                        cart.printReceipt();
                        break;
                    case "3":
                        JOptionPane.showMessageDialog(null,"You have chosen pavers");
                        STORES.get(2).printBrickByType("Paver");
                        STORES.get(2).getBrickSelectionInput(cart, "Paver");
                        cart.quantity = getBricksNeeded(cart.brick);
                        JOptionPane.showMessageDialog(null,cart.createReceipt());
                        cart.printReceipt();
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
                JOptionPane.showMessageDialog(null,"Please choose 1-4");
                break;
        }
         
    }   
    public static void customOrders()
    {
        Scanner scnr = new Scanner(System.in);
        String choices;
        String answer;
        String menu = "Where would you like to get your order from?"
                    + "\n1. Lowes"
                    + "\n2. Home Depot"
                    + "\n3. The Buildclub"
                    + "\n4. Main Menu";
        //Brick customerBricks;
        Purchase cart = new Purchase();
        getCustomerName();
        cart.customerName = customerName;
        
        choices = JOptionPane.showInputDialog(null, menu, "Store Picker", JOptionPane.QUESTION_MESSAGE);
        if(choices == null)
        {
            exitDialog();
            real();
        }
        switch(choices)
        {
            case "1":
                JOptionPane.showMessageDialog(null,"You have chosen Lowes for your order");
                //customerBricks = LOWES;
                answer = JOptionPane.showInputDialog(""
                        + "What would you like to order"
                        + "\n1. Bricks"
                        + "\n2. Veneers"
                        + "\n3. Pavers"
                        + "\n4. Go back");
                //needs more infor
                case "2":
                JOptionPane.showMessageDialog(null,"You have chosen Home Depot for your order");
                //customerBricks = HOME;
                answer = JOptionPane.showInputDialog(""
                        + "What would you like to order"
                        + "\n1. Bricks"
                        + "\n2. Veneers"
                        + "\n3. Pavers"
                        + "\n4. Go back");
        }
                //needs more info
        // copy and paste brick, veneer, and pavers
        //copy and paste selections
        // ask for wall measurements
        // add how many doors (double doors count as two doors)
        //ask how many windows (use standard size windows 24X36)
        // add doors and windows then use wall measurements to subtract
        //multiply with selection
        //print receipt
    }
    public static void getCustomerName()
    {
        Scanner keyboard = new Scanner(System.in);
        customerName = JOptionPane.showInputDialog("Hello, please enter your name: ");
        
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
    
    // Gets the number of bricksNeeded for school
    public static Integer getBricksNeeded(Brick brick)
    { 
        double patternHeight = 16;
        double standardPatternHeight = 80;
        double wallsInInches = 2813; 
        
        double normalPatternBricks = (wallsInInches * standardPatternHeight) / ((brick.length + .5) * (brick.height+.5));
        double bricksNeeded = normalPatternBricks + (wallsInInches * patternHeight) / ((brick.length + .5) * (brick.width + .5));
        double overage = bricksNeeded * .1;
        
        
        JOptionPane.showMessageDialog(null,"You will need " + (int)(bricksNeeded + overage) 
                + " bricks for the project, including 10% overage for damaged bricks.");
        return (int)(overage + bricksNeeded);
    }
   
    // Make a list of all the stores and their bricks for global use though
    // out the program
    public static List<BrickStore> createStores() // length height width cost
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
        lowes.addBrick(new Brick("Clay Red Cored", "Brick", 7.62, 2.25, 3.5, .86));        
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
    
    // JOptionPane - used to verify exit
    public static void exitDialog()
    {
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit?", JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }
}