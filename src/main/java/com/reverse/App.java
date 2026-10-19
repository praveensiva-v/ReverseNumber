package com.reverse;

public class App {

    public static int reverseNumber(int num) {
        int reverse = 0;

        while (num != 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num = num / 10;
        }

        return reverse;
    }

    public static void checkInput(String input) {
        System.out.println("Enter an integer: " + input);

        if (input.matches("-?\\d+")) {
            try {
                int number = Integer.parseInt(input);

                System.out.println(
                    "Reversed integer: " + reverseNumber(number)
                );

                System.out.println("Result: PASS");

            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Number is too large.");
            }
        } else {
            System.out.println("Invalid input! Please enter integers only.");
        }
    }

    public static void main(String[] args) {

        String correctInput = "12345";
        String incorrectInput = "12a45";

        checkInput(correctInput);

        System.out.println();

        checkInput(incorrectInput);
    }
}