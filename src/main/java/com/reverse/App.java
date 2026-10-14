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

    public static void main(String[] args) {
        int number = 12345;
        System.out.println("Reversed Number: " + reverseNumber(number));
    }
}
