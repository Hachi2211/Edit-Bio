package Boundary;

import ADT.ListInterface;
import Control.UserController;
import Entity.User;
import Utility.Validator;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class UserUI {
    private static Scanner scanner = new Scanner(System.in);
    private static UserController userController = UserController.getInstance();
    public static void Landing() {
        displayAllUsers();
        updateDonor();
    }

    private static void displayAllUsers() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current date and time: " + now);
        System.out.println("\nDisplaying user data");
        ListInterface<User> users = userController.getAllUsers();
        userFormattedTable(users);
    }

    private static void userFormattedTable(ListInterface<User> users) {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("| %-5s | %-40s | %-140s |","ID", "Username", "Bio"));
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 1; i <= users.getNumberOfEntries(); i++) {
            User user = users.getItem(i);
            System.out.println(String.format("| %-5s | %-40s | %-140s |",
                    user.getUserID(), user.getUsername(), user.getBio()));
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    }

    private static void updateDonor() {
        while (true) {
            System.out.println("Do you want to update your profile (Y/N)?");
            String choice = scanner.nextLine().trim();

            if (choice.equalsIgnoreCase("Y")) {
                updateDonorDetails();
            } else if (choice.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private static void updateDonorDetails() {
        User currentUser = userController.getCurrentUser();

        int choice = updateDonorMenu();
        if (choice == 0) {
            System.out.println("Update cancelled.");
            return;
        }

        boolean isUpdated = false;

        switch (choice) {
            case 1 -> { // Username update
                if (!userController.canUpdateUsername(currentUser)) {
                    System.out.println("You can only update your username once every 14 days. Please try again in " +
                            userController.getDaysUntilNextUpdate(currentUser) + " days.");
                    return;
                }

                System.out.println("Are you sure you want to update your username? You won't be able to update it again for 14 days. (Y/N)");
                String confirmation = scanner.nextLine().trim();

                if (!confirmation.equalsIgnoreCase("Y")) {
                    System.out.println("Username update cancelled.");
                    return;
                }

                String username = Validator.validateEmptyInput("Enter new username: ");
                isUpdated = userController.updateUsername(currentUser, username);
                if (isUpdated) {
                    System.out.println("Username updated successfully!");
                } else {
                    System.out.println("Username is the same as the previous one, no changes made.");
                }
            }
            case 2 -> { // Bio update
                String userBio = Validator.validateBioInput("Enter new bio: ");
                userController.updateBio(currentUser, userBio);
                System.out.println("Bio updated successfully!");
                isUpdated = true;
            }
        }

        if (isUpdated) {
            System.out.println("\nDonor updated successfully!");
            if (choice == 1) {
                System.out.println("You will be able to update your username again in 14 days.");
            }
            userFormattedTable(userController.getAllUsers());
        }
    }

    private static int updateDonorMenu() {
        int choice;
        while (true) {
            System.out.println("\nSelect which field to update:");
            System.out.println("1. Username");
            System.out.println("2. Bio");
            System.out.println("0. Cancel");
            System.out.print("Please input your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline left-over
                if (choice >= 0 && choice <= 2) {
                    break;
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return choice;
    }
}
