import java.util.Scanner;

class TenDollarStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalCost = 0.0;

        do {
            double itemPrice = getRangedDouble(scanner, "Enter the price of your item ($0.50 to $10.00): ", 0.5, 10.0);
            totalCost += itemPrice;

            char moreItems = getYNConfirm(scanner, "Do you have more items to add (Y/N)? ");
            if (moreItems != 'Y' && moreItems != 'y') {
                break;
            }
        } while (true);

        System.out.printf("Total cost of items: $%.2f%n", totalCost);

        scanner.close();
    }

    public static double getRangedDouble(Scanner scanner, String prompt, double min, double max) {
        double value = 0.0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);

            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value >= min && value <= max) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a value between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid double.");
                scanner.next();
            }
        }

        return value;
    }

    public static char getYNConfirm(Scanner scanner, String prompt) {
        char response = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);

            String input = scanner.next().trim();
            if (input.length() == 1) {
                response = input.charAt(0);
                if (response == 'Y' || response == 'y' || response == 'N' || response == 'n') {
                    validInput = true;
                }
            }

            if (!validInput) {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        }

        return Character.toUpperCase(response);
    }
}
