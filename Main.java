import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create ArrayList for Kombucha Objects
        ArrayList<Kombucha> kombuchas = new ArrayList<>();
        kombuchas.add(new Kombucha("Lemon", 10, 3, "K0001"));
        kombuchas.add(new Kombucha("Mint", 20, 5, "K0002"));
        kombuchas.add(new Kombucha("Lime", 30, 2, "K0003"));
        kombuchas.add(new Kombucha("Grape", 40, 10, "K0004"));
        kombuchas.add(new Kombucha("Orange", 50, 6, "K0005"));

        // Create ArrayList for inventory
        ArrayList<String> inventory = new ArrayList<>();

        double initialBudget = 100;
        double budget = 100;

        System.out.println("Budget: €" + budget);

        System.out.println("Kombucha Shop");

        // Call buyKombucha method
        buyKombucha(kombuchas, budget, inventory, initialBudget);
    }

    public static void buyKombucha(ArrayList<Kombucha> kombuchas, double budget, ArrayList<String> inventory, double initialBudget) {

        System.out.println("Type \"buy [Product code]\" to buy a product or \"exit\" to exit\n");

        // For loop to print the menu
        for(Kombucha kombucha : kombuchas){
            System.out.println(kombucha.getType() + " Kombucha - Price: €" + kombucha.getPrice() + " - Quantity: " + kombucha.getQuantity() + " - Product code: " + kombucha.getProductCode());
        }

        // Set up Scanner
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        // If Scanner input starts with "buy"
        if(input.startsWith("buy")){
            // For loop to go through all kombuchas items
            for(Kombucha kombucha : kombuchas){
                // If product code matches the Scanner input
                if(kombucha.getProductCode().equals(input.split(" ")[1])){
                    // If quantity is higher than 0
                    if(kombucha.getQuantity() > 0){
                        // If the budget is higher or equal the price
                        if(budget >= kombucha.getPrice()){
                            // Decrease quantity, add to inventory, decrease budget, print results, run method again
                            kombucha.setQuantity(kombucha.getQuantity() - 1);
                            inventory.add(kombucha.getType());
                            budget -= kombucha.getPrice();
                            System.out.println("You bought " + kombucha.getType() + " Kombucha for €" + kombucha.getPrice());
                            System.out.println("Budget: €" + budget);
                            System.out.println("Would you like to buy more Kombucha?");
                            buyKombucha(kombuchas, budget, inventory, initialBudget);
                        } else {
                            // Decline buy, print budget, run method again
                            System.out.println("You don't have enough money.");
                            System.out.println("Remaining budget: " + budget);
                            buyKombucha(kombuchas, budget, inventory, initialBudget);
                        }
                    } else {
                        // Decline buy, run method again
                        System.out.println("Product not in stock");
                        buyKombucha(kombuchas, budget, inventory, initialBudget);
                    }
                }
            }
        // If Scanner input is "exit"
        } else if(input.equals("exit")){
            // Print inventory, items amount, money spent, remaining budget
            System.out.println("\nInventory");
            System.out.println("Items amount: " + inventory.size());
            System.out.println(inventory);
            System.out.println("Money spent: €" + (initialBudget-budget));
            System.out.println("Remaining budget: €" + budget);
        } else {
            // Decline input, run method again
            System.out.println("Invalid input");
            buyKombucha(kombuchas, budget, inventory, initialBudget);
        }
    }
}