
package project;
import java.util.Scanner;
public class Project {
    public static void main(String[] args)
    {
        menu();
    }
    
    public static void menu(){
        Scanner scnr = new Scanner(System.in); 
        int choice;
        System.out.println("Welcome to Brick Block."
                + "\n========================"
                + "\n1. Places to buy bricks"
                + "\n2. Quotes"
                + "\n3. Real Deal"
                + "\n4. Exit");
        choice=scnr.nextInt();
        switch(choice)
        {
            case 1:
                type();
                break;
            case 2:
                quote();
                break;
            case 3:
                real(); 
                break;
            case 4:
                System.out.println("Have a nice day!!");
                break;
            default:
                break;
        }
    }
    public static void type(){
        Scanner scnr = new Scanner(System.in); 
        int choice;
        System.out.println("Different places for bricks?"
                + "\n=============================="
                + "\n1. Lowes"
                + "\n2. Home Depot"
                + "\n3. The BuildClub"
                + "\n4. Exit");
        choice=scnr.nextInt();
        switch(choice)
        {
            case 1:
                System.out.println("Lowes bricks are $0.65 per brick. ");
                type();
                break;
            case 2:
                System.out.println("Home Depot bricks are $0.70 per brick.");
                type();
                break;
            case 3:
                System.out.println("The Buildclub bricks are $0.59 per brick.");
                type();
                break;
            case 4:
                menu();
                break;
            default:
                    break;
        }
    }
    public static void quote(){
        Scanner scnr = new Scanner(System.in);
        int choice;
        System.out.println("Bricks are sold with 500 per pallet");
        
    }
    public static void real(){
        
    }
    
    
}
