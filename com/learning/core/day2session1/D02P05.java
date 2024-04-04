package com.learning.core.day2session1;
import java.util.Scanner;

//1. Write a program that takes a String as input and display the length of the string. Also display the
//string into uppercase and check whether it is a palindrome or not. (Refer Java API Documentation)

//Input:
//madam
//teaching

//Output:
//It is a Palindrome
//It is not a Palindrome.

class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string as Input: ");
        String inputString = scanner.nextLine();

        // Length of the string
        System.out.println("String Length: " + inputString.length());

        // Uppercase string
        System.out.println("Uppercase: " + inputString.toUpperCase());

        // Check if it's a palindrome
        boolean isPalindrome = true;
        for (int i = 0; i < inputString.length() / 2; i++) {
            if (inputString.charAt(i) != inputString.charAt(inputString.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("It is a Palindrome.");
        } else {
            System.out.println("It is not a Palindrome.");
        }

        scanner.close();
    }
}

