import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Fixed exchange rates (example values, can be updated)
        double inrToUsd = 0.012; // 1 INR = 0.012 USD
        double inrToEur = 0.011; // 1 INR = 0.011 EUR
        double usdToInr = 83.25; // 1 USD = 83.25 INR
        double eurToInr = 91.50; // 1 EUR = 91.50 INR

        System.out.println("===== Currency Converter =====");

        while (true) {
            System.out.println("\n--- Conversion Menu ---");
            System.out.println("1. INR to USD");
            System.out.println("2. INR to EUR");
            System.out.println("3. USD to INR");
            System.out.println("4. EUR to INR");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 5) {
                System.out.println("Thank you for using Currency Converter!");
                break;
            }

            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();

            if (amount < 0) {
                System.out.println("Invalid amount! Please enter a positive value.");
                continue;
            }

            double result = 0;
            switch (choice) {
                case 1:
                    result = amount * inrToUsd;
                    System.out.printf("%.2f INR = %.2f USD%n", amount, result);
                    break;
                case 2:
                    result = amount * inrToEur;
                    System.out.printf("%.2f INR = %.2f EUR%n", amount, result);
                    break;
                case 3:
                    result = amount * usdToInr;
                    System.out.printf("%.2f USD = %.2f INR%n", amount, result);
                    break;
                case 4:
                    result = amount * eurToInr;
                    System.out.printf("%.2f EUR = %.2f INR%n", amount, result);
                    break;
                default:
                    System.out.println("Invalid choice! Please select from the menu.");
            }
        }

        sc.close();
    }
}