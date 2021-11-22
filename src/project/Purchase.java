// Purchase/shopping cart
package project;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class Purchase {
    final private double TAX_RATE = .07;
    private String customerName;
    private Brick brick;
    private Integer quantity;
    private double purchaseTotal;
    
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
    
    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }
    public String getCustomerName()
    {
        return customerName;
    }
    public void setBrick(Brick brick)
    {
        this.brick = brick;
    }
    public Brick getBrick()
    {
        return brick;
    }
    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }
    public Integer getQuantity()
    {
        return quantity;
    }
    public void setTotal(double purchaseTotal)
    {
        this.purchaseTotal = purchaseTotal;
    }
    public double getTotal()
    {
        return purchaseTotal;
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
