package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {
    static void main(String[] args) {
        Scanner myScanner  = new Scanner(System.in);
        System.out.println("Welcome to the Sandwich Shop");

        // User input Size
        String size = "";
        boolean isLarge = false;
        float price = 0f;
        System.out.println("(R)egular: $5.45");
        System.out.println("(L)arge: $8.95");
        System.out.println("Enter the sandwich size:");

        // While 'size' isn't regular or large
        while (!(size.equals("r") || size.equals("regular") ||
                 size.equals("l")|| size.equals("large"))) {
            size = myScanner.nextLine();
            size = size.toLowerCase();

            // if regular, set price to 5.45
            if (size.equals("r") || size.equals("regular")) {
                price = 5.45f;

            // if large, set price to 8.95
            } else if (size.equals("l") || size.equals("large")) {
                price = 8.95f;
                isLarge = true;

            // if not viable size, reprompt
            } else {
                System.out.println("That wasn't a valid size!");
            }
        }

        System.out.println("Would you like your sandwich loaded?");
        System.out.println("Regular: Additional $1.00");
        System.out.println("Large: Additional $1.75");
        System.out.println("(Y)es / (N)o");
        String loadedInput = "";
        while (!(loadedInput.equals("n") || loadedInput.equals("no") ||
                loadedInput.equals("y")  || loadedInput.equals("yes") )) {
            loadedInput = myScanner.nextLine();
            loadedInput = loadedInput.toLowerCase();

            // if regular, set price to 5.45
            if (loadedInput.equals("n") || loadedInput.equals("no")) {
                price += 0;

                // if large, set price to 8.95
            } else if (loadedInput.equals("y") || loadedInput.equals("yes")) {
                if (isLarge) {
                    price += 1.75f;
                } else {
                    price += 1f;
                }
            } else {
                System.out.println("That wasn't a valid response!");
            }
        }

        // User input Age
        float age = 0;
        System.out.println("Students 17 years old or younger receive a 10% discount");
        System.out.println("Seniors 65 years old or older receive a 20% discount");
        System.out.println("Enter your age:");

        while (age <= 0) {

            // If user inputs valid number
            if (myScanner.hasNextFloat()) {
                age = myScanner.nextFloat();
                if (age <= 0) {
                    System.out.println("Please enter an age greater than 0");
                }
            // If user did not input a valid number
            }  else {
                System.out.println("That wasn't a valid age");
                // Eats the invalid input
                myScanner.next();
            }
        }

        // Determine discount based on age
        float discount = 0;
        if (age < 18) {
            discount = 0.9f;
        } else if (age >= 65) {
            discount = 0.8f;
        } else {
            discount = 1.0f;
        }

        price *= discount;
        System.out.println("The price of your sandwich is: $" + String.format("%.2f", price));

    }
}
