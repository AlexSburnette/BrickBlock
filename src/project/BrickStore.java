package project;
import java.util.ArrayList;
import java.util.List;

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
}