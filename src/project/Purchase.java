package project;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class Purchase {
    final private double TAX_RATE = .07;
    public String customerName;
    public Brick brick;
    public Integer quantity;
    public double purchaseTotal;
    
    public Purchase()
    {
        customerName = "";
        brick = new Brick();
        quantity = 0;
        purchaseTotal = 0;
    }
    public Purchase(String customerName)
    {
        this.customerName = customerName;
        brick = new Brick();
        quantity = 0;
        purchaseTotal = 0;
    }
    public Purchase(Brick brick, String customerName, Integer quantity, double purchaseTotal)
    {
        this.brick = brick;
        this.customerName = customerName;
        this.quantity = quantity;
        this.purchaseTotal = purchaseTotal;
    }
    
    // Writes receipt to file
    public void printReceipt()
    {
        DecimalFormat format = new DecimalFormat("$#,###.00");
        
        try
        {
            PrintWriter writer = new PrintWriter(customerName + "Bill.txt");
            writer.print(createReceipt());
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
    
    // Creates the receipt
    public String createReceipt()
    {
        DecimalFormat format = new DecimalFormat("$#,###.00");
        purchaseTotal = quantity * brick.costPerBrick;
        double tax = purchaseTotal * TAX_RATE;
        
        String bill = "Bill for " + customerName + "\n"
                + "==============================" + "\n"
                + brick.name + " " + brick.type + " " + brick.length + "x" + brick.height
                + "\nx " + quantity + " @ " + format.format(brick.costPerBrick) + "\n"
                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + "\n"
                + "Subtotal: " + format.format(purchaseTotal) +"\n"
                + "Tax: " + format.format(tax) + "\n"
                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + "\n"
                + "Total: " + format.format(tax + purchaseTotal);
        return bill;
    }
     
}