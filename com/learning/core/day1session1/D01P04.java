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
    public static boolean checkBingo(int num1, int num2, int[] array){
        boolean foundyes = false;
        boolean foundYes = false;

        for (int num : array) {
            if (num == num1) {
                foundyes = true;
            }
            if (num == num2) {
                foundYes = true;
            }
        }
        return foundyes && foundYes;
    }
}

class ArraySumOfElements {

    // a. Compute the sum of elements from index 0 to 14 and stores it at element 15
    public static void main(String[] args) {
        int[] A = {3, 2, 4, 5, 6, 4, 5, 7, 3, 2, 3, 4, 7, 1, 2, 0, 0, 0};

        int sum = 0;
        for (int i = 0; i < 15; i++) {
            sum += A[i];
        }
        A[15] = sum;

        // Print the output array
        System.out.println("Output:");
        for (int num : A) {
            System.out.print(num + " ");
        }
    }
}

     //b. Compute the average of all numbers and stores it at element 16.
class ArrayAverage {
        public static void main(String[] args) {
            int[] A = {3, 2, 4, 5, 6, 4, 5, 7, 3, 2, 3, 4, 7, 1, 2, 0, 0, 0};

            // Compute the sum of all numbers in the array
            int sum = 0;
            for (int num : A) {
                sum += num;
            }
            // Compute the average
            int average = (int) sum / A.length;

            // Store the average at element 16
            A[16] = (int) average;

            // Print the average
            System.out.println("Average of all numbers: " + average);

            // Print the updated array
            System.out.println("Output:");
            for (int num : A) {
                System.out.print(num + " ");
            }
        }
    }

    //c. Identifies the smallest value from the array and stores it at element 17.
    class ArraySmallestValue {
        public static void main(String[] args) {
            int[] A = {3, -2, 4, 5, 6, 4, 5, 7, 3, 2, 3, 4, 7, 1, 2, 0, 0, 0};

            // Find the smallest value in the array
            int smallest = A[0]; // Assume the first element is the smallest
            for (int i = 1; i < A.length; i++) {
                if (A[i] < smallest) {
                    smallest = A[i]; // Update smallest if a smaller value is found
                }
            }
            // Store the smallest value at element 17
            A[17] = smallest;

            // Print the smallest value
            System.out.println("Smallest value from the array: " + smallest);

            // Print the updated array
            System.out.println("Output :");
            for (int num : A) {
                System.out.print(num + " ");
            }
        }
    }

class FirstRepeatingElementIndex {
    public static void main(String[] args) {
        int[] arr = {10, 9, 3, 4, 1, 5, 5};
        int N = arr.length;

        int firstRepeatingIndex = -1; // Initialize the index of first repeating element

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] == arr[j]) {
                    firstRepeatingIndex = i; // Update first repeating index
                    break;
                }
            }
            if (firstRepeatingIndex != -1) {
                break; // Break out of the outer loop if repeating element is found
            }
        }

        // Print the index of the first repeating element
        if (firstRepeatingIndex != -1) {
            System.out.println("Index of the first repeating element: " + firstRepeatingIndex);
        } else {
            System.out.println("No repeating element found.");
        }
    }
}

class DistinctCombinations {
    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        int k = 2;
        System.out.println("Output:");
        findCombinations(input, k);
    }

    static void findCombinations(int[] nums, int k) {
        backtrack(nums, k, 0, new int[k], 0);
    }

    static void backtrack(int[] nums, int k, int start, int[] combination, int index) {
        if (index == k) {
            printCombination(combination);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            combination[index] = nums[i];
            backtrack(nums, k, i + 1, combination, index + 1);
        }
    }

    static void printCombination(int[] combination) {
        for (int num : combination) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}


