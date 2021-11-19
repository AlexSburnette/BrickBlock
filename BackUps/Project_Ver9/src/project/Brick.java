package project;

// This class hold all of the infomation about each individual brick
public class Brick {
    String name;
    String type;  
    double length;
    double height;
    double costPerBrick;
    
    public Brick(String Name, String Type, double Length, double Height, double CostPerBrick)
    {
        name = Name;
        type = Type;
        length = Length;
        height = Height;
        costPerBrick = CostPerBrick;        
    }

    public double getLength()
    {
        return length;
    }

    public double getHeight()
    {
        return height;
    }

    public double getCostPerBrick()
    {
        return costPerBrick;
    }
    
    public String getType()
    {
        return type;
    }
    
    public double getPalletCost(int pallets)
    {
        return (costPerBrick * 100) * pallets;
    }
    
    public void getInfo()
    {
        System.out.printf("%-21s",name);
        System.out.printf("%-7s",type);
        System.out.printf("%5sin. x ",length);
        System.out.printf("%5sin.",height);
        System.out.printf(" $%.2f",costPerBrick);
        System.out.println();
    }
}   