/*
 * CSC-251 and CTS 285
 * Brick Block
 * In Collaberation of Brandon Alder, Nicholas Baxley, and Alexander Burnette
 * Version 13
 * Fixing validation issues in real and custom section.
 * Started on Oct 18, 2021 Updated on Dec 4, 2021
 */

package project;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Project {
    // STORES.get(0) = Home Depot, STORES.get(1) = Lowes, STORES.get(2) = BuildClub
    // STORES.get(0).bricks.get(0) First brick in Home Depot, 
    // STORES.get(0).bricks.get(1) Second brick in Home Depot, etc...\
    
    // <editor-fold defaultstate="collapsed" desc="Global Vars">
    final static List<BrickStore> STORES = createStores();
    final static String PATTERN1 = "==============================";
    final static String PATTERN2 = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    final static double SALES_TAX = 0.07;
    static boolean WELCOMED = false;
    static String customerName = "";
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Main">
    public static void main(String[] args)
    {
        menu();
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Menu">
    public static void menu(){
        Scanner scnr = new Scanner(System.in); 
        String choice;
        boolean loop = true;
        String menu = ("1. Places to buy bricks"
                   + "\n2. Quotes"
                   +"\n3. Project"
                   + "\n4. Custom Build"              
                   + "\n5. Exit");
        
        if (!WELCOMED){
            JOptionPane.showMessageDialog(null,"\nWelcome to Brick Block.");
            WELCOMED = true;
        }
        
        while(loop)
        {
            choice = JOptionPane.showInputDialog(null, menu, "Main Menu", 
                                                 JOptionPane.QUESTION_MESSAGE);
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
                    JOptionPane.showMessageDialog(null,
                                                "Please choose between 1 - 5.");
                    break;
            }
        }
            
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Type Method">
    public static void type(){
        Table allBricks = new Table();
        boolean loop = true;
        int storeIndex;
        String menu = "1. Home Depot"
                  + "\n2. Lowes"
                  + "\n3. The BuildClub"
                  + "\n4. Exit";
        
        while(loop){
            String choice = JOptionPane.showInputDialog(null, menu, 
                                "Pick a store.", JOptionPane.QUESTION_MESSAGE);
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
                    if(allBricks.active){
                        allBricks.closeTable();
                    }
                    menu();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                                                "Please choose between 1 - 4.");
                    break;
            }  
            
            
            if (storeIndex != -1)
            {
                BrickStore selectedStore = STORES.get(storeIndex);
                if (allBricks.active)
                {
                    allBricks.closeTable();
                    allBricks = new Table();
                }
                allBricks.active = true;
                allBricks.frame.setTitle("All bricks at: " + selectedStore.name);
                Object[] cols = new Object[]{"Name","Type","Length","Height",
                                             "Cost Per Brick"};
                allBricks.addColumns(cols);
                
                for (Brick brick : selectedStore.bricks) 
                {
                    allBricks.addRow(new Object[] {brick.name, brick.type, 
                                brick.length, brick.height, brick.costPerBrick});
                }
                allBricks.frame.setVisible(true);
            }     
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Quote Method">
    public static void quote(){
        Table storeBricks = new Table();
        Table finalQuote = new Table();
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
            
            choice = JOptionPane.showInputDialog(null, menu, "Quote Menu", 
                                                 JOptionPane.QUESTION_MESSAGE);
            if(finalQuote.active){
                finalQuote.frame.setVisible(false);
                finalQuote.closeTable();
                finalQuote = new Table();
            }
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
                    JOptionPane.showMessageDialog(null,
                                                "Please choose between 1 - 4.");
                    break;
            }
            if (storeIndex != -1)
            {           
                String brickType = "";
                while(loop)
                {
                    choice = JOptionPane.showInputDialog("\nWhat type of "
                                    + "bricks do you want?"
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
                            JOptionPane.showMessageDialog(null,
                                                "Please choose between 1 - 3.");
                            break;
                    }
                }
                
                // Showing user all avaiable bricks from their selected store
                List<Brick> validBricks = new ArrayList<>();
                int count = 0;
                BrickStore selectedStore = STORES.get(storeIndex);
                
                storeBricks.active = true;
                
                storeBricks.addColumns(new Object[] {"Id", "Name", "Length", 
                                                    "Height", "Cost Per Brick"});
                storeBricks.frame.setTitle("All " + brickType + " at " 
                                            + selectedStore.name);
                storeBricks.frame.setBounds(100, 100, 710, 500);
                for(Brick brick : selectedStore.bricks)
                {                   
                    if(brick.type.equals(brickType))
                    {
                        count++;
                        validBricks.add(brick);
                        storeBricks.addRow(new Object[]{count, brick.name, 
                                brick.length, brick.height, brick.costPerBrick});
                    }
                }           
                storeBricks.frame.setVisible(true);
                
                boolean brickLoop = true;
                String brickChoice = "a";
                // Asking what bricks out of the avaliable 
                // bricks the user wants to buy
                while(brickLoop)
                {
                    brickChoice = JOptionPane.showInputDialog("\nWhich " 
                                        + brickType + " would you like to buy?");
                    
                    if(!isNumber(brickChoice))
                    {
                        JOptionPane.showMessageDialog(null,"Please enter a number!");
                    }
                    else if(Integer.parseInt(brickChoice) < 1 
                         || Integer.parseInt(brickChoice) > validBricks.size())
                    {
                        JOptionPane.showMessageDialog(null,"Enter a number from 1 to " 
                                                    + validBricks.size() + "!");
                    }
                    else
                    {
                        brickLoop = false;
                    }
                }
                storeBricks.frame.dispose();
                Brick boughtBrick = validBricks.get(Integer.parseInt(brickChoice) - 1);
                        
                // Asking how many pallets the user wants   
                boolean palletLoop = true;
                String palletChoice = "a";
                while(palletLoop)
                {
                    palletChoice = JOptionPane.showInputDialog("\nHow many "
                            + "pallets would you like to buy? "
                            + "(Pallet = 100 bricks)");
                
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
                
                finalQuote.active = true;
                double overage = Math.round(Integer.parseInt(palletChoice) * .10);
                finalQuote.frame.setTitle("Final Quote");
                finalQuote.addColumns(new Object[]{"","Store", "Brick", 
                                                   "Pallets", "Cost"});
                finalQuote.addRow(new Object[]{"",selectedStore.name, 
                    selectedStore.bricks.get(Integer.parseInt(brickChoice)).name, 
                    palletChoice, String.format("$%.2f", boughtBrick.getPalletCost(1))
                    });
                finalQuote.addRow(new Object[]{"Pallets","","","",String.format("$%.2f",
                        boughtBrick.getPalletCost(Integer.parseInt(palletChoice)))});
                finalQuote.addRow(new Object[]{"10% Overage","","","",String.format("$%.2f",
                        boughtBrick.getPalletCost((int)overage))});
                finalQuote.addRow(new Object[]{"Total","","","",String.format("$%.2f",
                        boughtBrick.getPalletCost(Integer.parseInt(palletChoice) + (int)overage))});
                finalQuote.frame.setVisible(true);
              
                loop = true;
            }
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Real Method">
    public static void real(){
        //Brick customerBricks;
        Purchase cart = new Purchase();
        getCustomerName();
        cart.customerName = customerName;
        Table storeBricks = new Table();
        Scanner scnr = new Scanner(System.in);
        boolean loop = true;
        int storeIndex = -1;
        String choices;
        String answer;
        String menu = "Where would you like to get your order from?"
                    + "\n1. Home Depot"
                    + "\n2. Lowes"
                    + "\n3. The Buildclub"
                    + "\n4. Main Menu";
        
        
        
        while(loop)
        {
            choices = JOptionPane.showInputDialog(null, menu, "Store Picker",
                    JOptionPane.QUESTION_MESSAGE);
            if(choices == null)
            {
                exitDialog();
                real();
            }
            
            switch(choices)
            {
                case "1":
                    loop = false;
                    storeIndex = 0;
                    break;
                case "2":
                    loop = false;
                    storeIndex = 1;
                    break;
                case "3":
                    loop = false;
                    storeIndex = 2;
                    break;
                case "4":
                    loop = false;
                    menu();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Please choose 1-4");
                    break;
            }
        }
        
        loop = true;
        String brickIndex = "";
        while(loop)
        {
            switch(answer = JOptionPane.showInputDialog(""
                        + "What would you like to order"
                        + "\n1. Bricks"
                        + "\n2. Veneers"
                        + "\n3. Pavers"
                        + "\n4. Go back"))
            {
                case "1":
                    loop = false;
                    brickIndex = "Brick";
                    break;
                case "2":
                    loop = false;
                    brickIndex = "Veneer";
                    break;
                case "3":
                    loop = false;
                    brickIndex = "Paver";
                    break;
                case "4":
                    loop = false;
                    real();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Please choose 1-4");
                    break;         
            }
        }       
        
        // Showing user all avaiable bricks from their selected store
        List<Brick> validBricks = new ArrayList<>();
        int count = 0;
        BrickStore selectedStore = STORES.get(storeIndex);

        storeBricks.active = true;

        storeBricks.addColumns(new Object[] {"Id", "Name", "Length", 
                                            "Height", "Cost Per Brick"});
        storeBricks.frame.setTitle("All " + brickIndex + " at " 
                                    + selectedStore.name);
        storeBricks.frame.setBounds(100, 100, 710, 500);
        for(Brick brick : selectedStore.bricks)
        {                   
            if(brick.type.equals(brickIndex))
            {
                count++;
                validBricks.add(brick);
                storeBricks.addRow(new Object[]{count, brick.name, 
                        brick.length, brick.height, brick.costPerBrick});
            }
        }           
        storeBricks.frame.setVisible(true);

        boolean brickLoop = true;
        String brickChoice = "a";
        // Asking what bricks out of the avaliable 
        // bricks the user wants to buy
        while(brickLoop)
        {
            brickChoice = JOptionPane.showInputDialog("\nWhich " 
                                + brickIndex + " would you like to buy?");

            if(!isNumber(brickChoice))
            {
                JOptionPane.showMessageDialog(null,"Please enter a number!");
            }
            else if(Integer.parseInt(brickChoice) < 1 
                 || Integer.parseInt(brickChoice) > validBricks.size())
            {
                JOptionPane.showMessageDialog(null,"Enter a number from 1 to " 
                                            + validBricks.size() + "!");
            }
            else
            {
                brickLoop = false;
            }
        }
        storeBricks.frame.dispose();
        cart.brick = validBricks.get(Integer.parseInt(brickChoice) - 1);
        cart.quantity = getBricksNeeded(cart.brick);
        JOptionPane.showMessageDialog(null,cart.createReceipt());
        cart.printReceipt();
        real();
                
    }
       
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Custom Orders">
    public static void customOrders()
    {
        Scanner scnr = new Scanner(System.in);
        String choices;
        String answer;
        int storeIndex = -1;
        int windows;
        double windowSqInches;
        int doors;
        double doorWidth;
        double doorHeight;
        double doorSqInches;
        double wallLength;
        double wallHeight;
        double wallSqInches;
        int total;
        boolean loop = true;
        String menu = "Where would you like to get your order from?"
                    + "\n1. Lowes"
                    + "\n2. Home Depot"
                    + "\n3. The Buildclub"
                    + "\n4. Main Menu";
        while(loop)
        {
            Table storeBricks = new Table();
            //Brick customerBricks;
            Purchase cart = new Purchase();
            getCustomerName();
            cart.customerName = customerName;

            while (loop)
            {
                choices = JOptionPane.showInputDialog(null, menu, "Store Picker", 
                                                      JOptionPane.QUESTION_MESSAGE); 
                if(choices == null)
                {
                    exitDialog();
                    customOrders();
                }

                switch(choices)
                {
                    case "1":
                        loop = false;
                        storeIndex = 0;
                        break;
                    case "2":
                        loop = false;
                        storeIndex = 1;
                        break;
                    case "3":
                        loop = false;
                        storeIndex = 2;
                        break;
                    case "4":
                        loop = false;
                        menu();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Please choose 1-4");
                        break;
                }
            }

            loop = true;
            String brickIndex = "";
            while(loop)
            {
                switch(answer = JOptionPane.showInputDialog(""
                            + "What would you like to order"
                            + "\n1. Bricks"
                            + "\n2. Veneers"
                            + "\n3. Pavers"
                            + "\n4. Go back"))
                {
                    case "1":
                        loop = false;
                        brickIndex = "Brick";
                        break;
                    case "2":
                        loop = false;
                        brickIndex = "Veneer";
                        break;
                    case "3":
                        loop = false;
                        brickIndex = "Paver";
                        break;
                    case "4":
                        loop = false;
                        real();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Please choose 1-4");
                        break;         
                }
            }       

            // Showing user all avaiable bricks from their selected store
            List<Brick> validBricks = new ArrayList<>();
            int count = 0;
            BrickStore selectedStore = STORES.get(storeIndex);
            storeBricks.active = true;
            storeBricks.addColumns(new Object[] {"Id", "Name", "Length", 
                                                "Height", "Cost Per Brick"});
            storeBricks.frame.setTitle("All " + brickIndex + " at " 
                                        + selectedStore.name);
            storeBricks.frame.setBounds(100, 100, 710, 500);
            for(Brick brick : selectedStore.bricks)
            {                   
                if(brick.type.equals(brickIndex))
                {
                    count++;
                    validBricks.add(brick);
                    storeBricks.addRow(new Object[]{count, brick.name, 
                            brick.length, brick.height, brick.costPerBrick});
                }
            }           
            storeBricks.frame.setVisible(true);

            boolean brickLoop = true;
            String brickChoice = "a";
            // Asking what bricks out of the avaliable 
            // bricks the user wants to buy
            while(brickLoop)
            {
                brickChoice = JOptionPane.showInputDialog("\nWhich " 
                                    + brickIndex + " would you like to buy?");

                if(!isNumber(brickChoice))
                {
                    JOptionPane.showMessageDialog(null,"Please enter a number!");
                }
                else if(Integer.parseInt(brickChoice) < 1 
                     || Integer.parseInt(brickChoice) > validBricks.size())
                {
                    JOptionPane.showMessageDialog(null,"Enter a number from 1 to " 
                                                + validBricks.size() + "!");
                }
                else
                {
                    brickLoop = false;
                }
            }
            storeBricks.frame.dispose();
            cart.brick = validBricks.get(Integer.parseInt(brickChoice) - 1);
            //WallLength
            String temp = "";
            while (!isNumber(temp))
            {
                temp = JOptionPane.showInputDialog("What is the length of your wall "
                        + "in inches?");
                if (!isNumber(temp))
                {
                    JOptionPane.showMessageDialog(null, "Input a number!");
                }
            }
            wallLength = Double.parseDouble(temp);
            //WallHeight
            temp = "";
            while (!isNumber(temp))
            {
                temp = JOptionPane.showInputDialog("What is the height of your wall "
                        + "in inches?");
                if (!isNumber(temp))
                {
                    JOptionPane.showMessageDialog(null, "Input a number!");
                }
            }
            wallHeight = Double.parseDouble(temp);
            //Doors
            temp = "";
            while (!isInteger(temp))
            {
                temp = JOptionPane.showInputDialog("How many doors do you need?");
                if (!isInteger(temp))
                {
                    JOptionPane.showMessageDialog(null, "Input a whole number!");
                }
            }
            doors = Integer.parseInt(temp);
            //Doors Width
            temp = "";
            while (!isNumber(temp))
            {
                temp = JOptionPane.showInputDialog("What is the width of the "
                        + "doors in inches?");
                if (!isNumber(temp))
                {
                    JOptionPane.showMessageDialog(null, "Input a number!");
                }
            }
            doorWidth = Double.parseDouble(temp);
            //Doors Height
            temp = "";
            while (!isNumber(temp))
            {
                temp = JOptionPane.showInputDialog("What is the height of the "
                        + "doors in inches?");
                if (!isNumber(temp))
                {
                    JOptionPane.showMessageDialog(null, "Input a number!");
                }
            }
            doorHeight = Double.parseDouble(temp);
            //Door Sq Inches
            doorSqInches = doors * (doorWidth * doorHeight);
            //Windows
            temp = "";
            while (!isInteger(temp))
            {
                temp = JOptionPane.showInputDialog("How many windows will be installed?");
                if (!isInteger(temp))
                {
                    JOptionPane.showMessageDialog(null, "Input a whole number!");
                }
            }
            windows = Integer.parseInt(temp);
            //Window Sq Inches
            windowSqInches = windows * (24 * 36);
            //Wall Sq Inches
            wallSqInches = ((wallLength * wallHeight)- doorSqInches) - windowSqInches;
            cart.quantity = getBricksNeededCustom(cart.brick, wallSqInches);
            JOptionPane.showMessageDialog(null,cart.createReceipt());
            cart.printReceipt();
            loop = true;
        }
    }// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Methods">
    public static void getCustomerName()
    {
        Scanner keyboard = new Scanner(System.in);
        if(customerName.equals(""))
        {
            while (customerName.equals(""))
            {
                customerName = JOptionPane.showInputDialog("Hello, please "
                                                        + "enter your name: ");
                if (customerName.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Name can not be empty");
                }
            }     
        }      
    }
    
    // Gets the number of bricksNeeded for school
    public static Integer getBricksNeeded(Brick brick)
    { 
        double patternHeight = 16;
        double standardPatternHeight = 80;
        double wallsInInches = 2813; 
        
        double normalPatternBricks = (wallsInInches * standardPatternHeight)
                / ((brick.length + .5) * (brick.height+.5));
        double bricksNeeded = normalPatternBricks + ((wallsInInches * patternHeight)
                / ((brick.height + .5) * (brick.length + .5)));
        double overage = bricksNeeded * 0.1;
        
        JOptionPane.showMessageDialog(null,"You will need " + (int)(bricksNeeded + overage) 
                + " bricks for the project, including 10% overage for damaged bricks.");
        return (int)(overage + bricksNeeded);
    }
    
   // Bricks needed for customorder
   public static Integer getBricksNeededCustom(Brick brick, double wallSqInches)
   {
       double bricks =  wallSqInches  / ((brick.length + .5) *
               (brick.height + .5));
       bricks = bricks + (bricks * .1);
       return (int)bricks;
   }
    
    // Make a list of all the stores and their bricks for global use though
    // out the program
    public static List<BrickStore> createStores() // length height width cost
    { 
        // Making all bricks in Home Depot
        BrickStore homesDepot = new BrickStore("Homes Depot");
        homesDepot.addBrick(new Brick("Gray Castle Bricks", "Brick", 28, 10.50, 1.51)); 
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
            double t = Double.parseDouble(number);
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
    
    // Needed for some switch statement checks
    public static boolean isInteger(String number)
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
        int choice = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to exit?", "Exit?", JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }
    // </editor-fold>
}