// Task 3 -- CURRENCY CONVERTER

import java.util.Scanner;

public class Currency {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            displayCurrencyOptions();
            System.out.print("Enter your choice (1-5): ");
            choice = getValidIntegerInput();
            if (choice >= 1 && choice <= 4) {
                double amount = getCurrencyAmount();
                double convertedAmount = convertCurrency(choice, amount);
                System.out.println("Converted Amount: " + convertedAmount);
            } else if (choice == 5) {
                System.out.println("\nExiting Currency Converter. Thank you!");
            } else {
                System.out.println("Invalid input, please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void displayCurrencyOptions() {
        System.out.println("\nCurrency Converter");
        System.out.println("1. US Dollar to Indian Rupees");
        System.out.println("2. Indian Rupees to US Dollar");
        System.out.println("3. European Euro to Indian Rupees");
        System.out.println("4. Japanese Yen to Indian Rupees");
        System.out.println("5. Exit");
    }

    private static int getValidIntegerInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input, please enter a valid integer.");
            scanner.next(); 
        }
        return scanner.nextInt();
    }

    private static double getCurrencyAmount() {
        System.out.print("\nEnter amount to convert: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount, please enter a valid number.");
            scanner.next(); 
        }
        return scanner.nextDouble();
    }

    private static double convertCurrency(int choice, double amount) {
        double conversionRate;
        switch (choice) {
            case 1:
                conversionRate = 83.5; 
                break;
            case 2:
                conversionRate = 0.012; 
                break;
            case 3:
                conversionRate = 91.12; 
                break;
            case 4:
                conversionRate = 0.58; 
                break;
            default:
                throw new IllegalArgumentException("Invalid conversion choice: " + choice);
        }
        return amount * conversionRate;
    }
}
