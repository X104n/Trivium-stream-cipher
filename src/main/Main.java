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
        String iv = "";
        String key = "";
        boolean validInput = false;

        while (!validInput) {
            // Get IV
            System.out.println("\nEnter IV (Initialization Vector) - maximum 50 characters:");
            System.out.println("(Type 'exit' to return to main menu)");
            iv = scanner.nextLine();

            if (iv.equalsIgnoreCase("exit")) {
                return;
            }

            if (iv.length() > 50) {
                System.out.println("Error: IV cannot be longer than 50 characters. Please try again.");
                continue;
            }

            // Get Key
            System.out.println("\nEnter Key - maximum 60 characters:");
            System.out.println("(Type 'exit' to return to main menu)");
            key = scanner.nextLine();

            if (key.equalsIgnoreCase("exit")) {
                return;
            }

            if (key.length() > 60) {
                System.out.println("Error: Key cannot be longer than 60 characters. Please try again.");
                continue;
            }

            validInput = true;
        }

        // At this point, both IV and Key are valid
        System.out.println("\nStream cipher created successfully!");
        System.out.println("IV: " + iv);
        System.out.println("Key: " + key);
    }
}
