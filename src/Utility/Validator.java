package Utility;

import java.util.Scanner;

public class Validator {
    private static Scanner scanner = new Scanner(System.in);

    //empty input validation, and ask user to re-enter if input is empty
    public static String validateEmptyInput(String prompt){
        String input = "";
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a valid input.");
            } else {
                break;
            }
        }
        return input;
    }

    //validate bio input (1-80 char), and ask user to re-enter if input is invalid
    public static String validateBioInput(String prompt){
        String input = "";
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Bio cannot be empty. Please enter a valid input.");
            } else if (input.length() > 80) {
                System.out.println("Bio cannot exceed 80 characters. Please enter a valid input.");
            } else {
                break;
            }
        }
        return input;
    }
}
