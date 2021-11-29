package project;

// This class hold all of the infomation about each individual brick
public class Brick {
    String name;
    String type;  
    double length;
    double height;
    double width;
    
    double costPerBrick;
    
    public Brick()
    {
        name = "";
        type = "";
        length = 0;
        height = 0;
        width = 0;
    }
    // Need to add Width in due to my stupidity
    public Brick(String Name, String Type, double Length, double Height, double CostPerBrick)
    {
        name = Name;
        type = Type;
        length = Length;
        height = Height;
        costPerBrick = CostPerBrick;        
    }
    
    public Brick(String Name, String Type, double Length, double Height, double Width, double CostPerBrick)
    {
        name = Name;
        type = Type;
        length = Length;
        height = Height;
        width = Width;
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
    public double getWidth()
    {
        return width;
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
    
<<<<<<< HEAD
    public String getInfo()
    {
        return String.format("\n%-40s%8s%11sin. x %8sin.$%.2f",name,type,length,height,costPerBrick);
=======
    public void getInfo()
    {
        System.out.printf("%-40s%8s%11sin. x %8sin.$%.2f\n",name,type,length,height,costPerBrick);
>>>>>>> Alex-update
    }
}   


// "\n%-40s%-8s%11sin. x %8sin.$%.2f",name,type,length,height,costPerBrick