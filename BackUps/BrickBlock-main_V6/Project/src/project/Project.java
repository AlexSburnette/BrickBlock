
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
                + "\n1. Types of Brick"
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
        System.out.println("Bricks are sold 500 per pallet.");
        System.out.println("How would you like your bricks?"
                + "\n=============================="
                + "\n1. Type 1"
                + "\n2. Type 2"
                + "\n3. Type 3"
                + "\n4. Exit");
        choice=scnr.nextInt();
        switch(choice)
        {
            case 1:
                System.out.println("Price is $200");
                break;
            case 2:
                System.out.println("Price is $300");
                break;
            case 3:
                System.out.println("Price is $400");
                break;
            case 4:
                menu();
                break;
            default:
                    break;
        }
    }
    public static void quote(){
        
    }
    public static void real(){
        
    }
    
    
}
