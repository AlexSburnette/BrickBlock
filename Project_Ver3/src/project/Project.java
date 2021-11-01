
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
        double lowes = 0.65;
        double home = 0.70;
        double build = 0.59;
        double per = 500;
        double total, pallet;
        String ans;
        System.out.println("Which one would you like to choose?"
                + "\n====================================="
                + "\n Bricks are sold with 500 per pallet?"
                + "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                + "\n1. Lowes"
                + "\n2. Home Depot"
                + "\n3. The Buildclub"
                + "\n4. Main Menu");
        choice=scnr.nextInt();
        switch(choice)
        {
            case 1:
                System.out.println("You have chosen Lowes for your bricks");
                System.out.println("How many pallets do you need?");
                pallet = scnr.nextInt();
                System.out.println("You have entered "+pallet+".");
                total=lowes*per*pallet;
                System.out.println("Your quote is $"+total+".");
                break;
            case 2:
                System.out.println("You have chosen Home Depot for your bricks");
                System.out.println("How many pallets do you need?");
                pallet = scnr.nextInt();
                System.out.println("You have entered "+pallet+".");
                total=home*per*pallet;
                System.out.println("Your quote is $"+total+".");
                break;
            case 3:
                System.out.println("You have chosen The Buildclub for your bricks");
                System.out.println("How many pallets do you need?");
                pallet = scnr.nextInt();
                System.out.println("You have entered "+pallet+".");
                total=build*per*pallet;
                System.out.println("Your quote is $"+total+".");
                break;
            case 4:
                menu();
                break;
            default:
                System.out.println("Please choose between 1 - 4.");
                quote();
                break;
        }
    }
    public static void real(){
        
    }
    
    
}
