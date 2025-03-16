package main;

import java.util.Scanner;
import core.Trivium;

public class Main {
    public static void main(String[] args) {
        testData();

        mandatoryStreamCipher();

        TUI();
    }

    private static void testData(){
        Trivium testTrivium = new Trivium(Generator.testIVMaker(), Generator.testKeyMaker());
        testTrivium.run(50);
        System.out.println("\nThe test data trivium result. This was to test our solution for the mandatory assignment: ");
        System.out.println(testTrivium.getStream());
    }

    private static void mandatoryStreamCipher(){
        Trivium mandatoryTrivium = new Trivium(Generator.mandatoryIVMaker(), Generator.mandatoryKeyMaker());
        mandatoryTrivium.run(1000);
        System.out.println("\nThis should be the 1000 bit stream cipher using the key and IV provided in the mandatory note. (See README): ");
        System.out.println(mandatoryTrivium.getStream());
    }

    private static void TUI() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Stream Cipher TUI Menu ===");
            System.out.println("1. Create your own Stream cipher");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    createStreamCipher(scanner);
                    break;
                case 2:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void createStreamCipher(Scanner scanner) {
        String stringIV = "";
        String stringKey = "";
        boolean validInput = false;

        while (!validInput) {
            // Get IV
            System.out.println("\nEnter IV (Initialization Vector) - maximum 93 digits (numbers only):");
            System.out.println("(Type 'exit' to return to main menu)");
            stringIV = scanner.nextLine();

            if (stringIV.equalsIgnoreCase("exit")) {
                return;
            }

            // Check if IV contains only digits
            if (!stringIV.matches("\\d+")) {
                System.out.println("Error: IV must contain only numbers. Please try again.");
                continue;
            }

            if (stringIV.length() > 93) {
                System.out.println("Error: IV cannot be longer than 93 digits. Please try again.");
                continue;
            }

            // Get Key
            System.out.println("\nEnter Key - maximum 84 digits (numbers only):");
            System.out.println("(Type 'exit' to return to main menu)");
            stringKey = scanner.nextLine();

            if (stringKey.equalsIgnoreCase("exit")) {
                return;
            }

            // Check if Key contains only digits
            if (!stringKey.matches("\\d+")) {
                System.out.println("Error: Key must contain only numbers. Please try again.");
                continue;
            }

            if (stringKey.length() > 84) {
                System.out.println("Error: Key cannot be longer than 84 digits. Please try again.");
                continue;
            }

            validInput = true;
        }

        // At this point, both IV and Key are valid
        System.out.println("\nStream cipher created successfully!");
        System.out.println("IV: " + stringIV);
        System.out.println("Key: " + stringKey);

        // Convert string inputs to int arrays
        int[] iv = convertStringToIntArray(stringIV, 93);
        int[] key = convertStringToIntArray(stringKey, 84);

        // Create Trivium instance with the converted arrays
        Trivium trivium = new Trivium(Generator.customIVMaker(iv), Generator.customKeyMaker(key));
        customStreamCipher(scanner, trivium);
    }

    // Helper method to convert a string of digits to an int array
    private static int[] convertStringToIntArray(String str, int length) {
        int[] result = new int[length];
        for (int i = 0; i < str.length(); i++) {
            result[i] = Character.getNumericValue(str.charAt(i));
        }
        return result;
    }

    private static void customStreamCipher(Scanner scanner, Trivium trivium) {
        boolean validInput = false;
        int steps = 0;

        while (!validInput) {
            System.out.println("\nHow many steps do you want the Trivium cipher to take?");
            System.out.println("(Enter a positive number, or type 'exit' to return to main menu)");

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                return;
            }

            // Check if input contains only digits
            if (!input.matches("\\d+")) {
                System.out.println("Error: Please enter only numbers. Try again.");
                continue;
            }

            try {
                steps = Integer.parseInt(input);

                // Ensure steps is positive
                if (steps <= 0) {
                    System.out.println("Error: Number of steps must be positive. Try again.");
                    continue;
                }

                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format. Try again.");
            }
        }

        // Execute the cipher with the specified number of steps
        System.out.println("\nExecuting Trivium cipher for " + steps + " steps...");

        // Run the cipher for the specified number of steps
        trivium.run(steps);

        // Display output using the existing getStream method
        System.out.println("\nCipher output:");
        System.out.println(trivium.getStream());

        System.out.println("\nStream cipher operation completed successfully.");
    }
}
