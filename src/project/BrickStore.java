package project;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

// This class will hold a collections of all bricks for a store, to access a 
// a brick you will need to type Store.get(bricks).get(brickIndex)
public class BrickStore {
    
    String name;
    List<Brick> bricks = new ArrayList<>();
      
    public BrickStore(String Name)
    {
        name = Name;  
    }
    
    public void addBrick(Brick brick)
    {
        bricks.add(brick);
    }
    
    // Displays bricks a store have by a specified type
    public void printBrickByType(String brickType)
    {
        Brick currentBrick;
        System.out.println(brickType + " Selection\n"
                +"=============================="
                +"==============================");
        int index = 1;
        for(int i = 0; i < bricks.size(); i++)
        {
            currentBrick = bricks.get(i);
            if(currentBrick.type.equals(brickType))
            {
                System.out.printf("%s. ", (index++));
<<<<<<< HEAD
                System.out.println(currentBrick.getInfo());
=======
                currentBrick.getInfo();
>>>>>>> Alex-update
            }
        }
        System.out.println();
    }
    
    // Gets input for what brick they want
    public void getBrickSelectionInput(Purchase cart, String brickType)
    {
        Scanner scnr = new Scanner(System.in);
<<<<<<< HEAD
        System.out.println("Which one would you like to purchase?");
        String selection = scnr.next(); // TODO - more validation 
=======
        String selection = JOptionPane.showInputDialog("Which one would you like to purchase?");
        // TODO - more validation 
>>>>>>> Alex-update
        if(Integer.parseInt(selection) == 1 || Integer.parseInt(selection) == 2)
        {
            if(brickType == "Brick")
            {
                cart.brick = (bricks.get(Integer.parseInt(selection) - 1)); 
            }
            else if(brickType == "Veneer")
            {
                cart.brick = (bricks.get(Integer.parseInt(selection) + 1)); 
            }
            else
            {
                cart.brick = (bricks.get(Integer.parseInt(selection) + 3)); 
            }
        }
        else
        {
            System.out.println("Invalid input. Please enter 1 or 2");
        }
    }
}