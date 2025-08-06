package org.example;


import java.util.Scanner;

public class SimpleInterestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter principal amount: ");
        int principal = scanner.nextInt();

        System.out.print("Enter yearly interest rate: ");
        double interestRate = scanner.nextDouble();

        System.out.print("Enter time period (e.g., 18m or 2.5y): ");
        String timeInput = scanner.next();

        double timeInYears = parseTime(timeInput);

        double interest = (principal * interestRate * timeInYears) / 100;

        System.out.println("\nCalculation Details:");
        System.out.println("Principal Amount: " + principal);
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Time Period: " + timeInput + " (" + timeInYears + " years)");
        System.out.println("Total Interest: " + interest);

        scanner.close();
    }

    public static double parseTime(String timeInput) {
        String timeUnit = timeInput.substring(timeInput.length() - 1);
        String timeValueStr = timeInput.substring(0, timeInput.length() - 1);
        double timeValue = Double.parseDouble(timeValueStr);

        if (timeUnit.equals("y")) {
            return timeValue;
        } else if (timeUnit.equals("m")) {
            return timeValue / 12.0;
        } else {
            System.out.println("Invalid time format. Using default 1 year.");
            return 1.0;
        }
    }
}