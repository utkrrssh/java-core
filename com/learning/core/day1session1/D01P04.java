package com.learning.core.day1session1;
import java.util.Scanner;
class Bingo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int[] array = {7,35,5,19,30,39,17,};

        if (checkBingo(num1, num2, array)) {
            System.out.println("Its Bingo");
        } else {
            System.out.println("Not Found");
        }

        scanner.close();
    }

    public static boolean checkBingo(int num1, int num2, int[] array) {
        boolean found1 = false;
        boolean found2 = false;

        for (int num : array) {
            if (num == num1) {
                found1 = true;
            }
            if (num == num2) {
                found2 = true;
            }
        }

        return found1 && found2;
    }
}