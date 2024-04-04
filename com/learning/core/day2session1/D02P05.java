package com.learning.core.day2session1;
import java.util.Scanner;

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
        boolean isaPalindrome = true;
        for (int i = 0; i < inputString.length() / 2; i++) {
            if (inputString.charAt(i) != inputString.charAt(inputString.length() - 1 - i)) {
                isaPalindrome = false;
                break;
            }
        }

        if (isaPalindrome) {
            System.out.println("It is a Palindrome.");
        } else {
            System.out.println("It is not a Palindrome.");
        }

        scanner.close();
    }
}

class Vowels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("Input string: ");
        String inputString = scanner.nextLine();

        // Number of last 'n' vowels
        System.out.print("Enter number of vowels to count: ");
        int n = scanner.nextInt();

        // Counting vowels from the end of the string
        int vowelCount = 0;
        StringBuilder lastNVowels = new StringBuilder();

        for (int i = inputString.length() - 1; i >= 0 && vowelCount < n; i--) {
            char ch = Character.toLowerCase(inputString.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                lastNVowels.append(ch);
                vowelCount++;
            }
        }
        // Output
        if (vowelCount < n) {
            System.out.println("Mismatch in Vowel Count");
        } else {
            System.out.println("Last " + n + " vowels: " + lastNVowels.reverse());
        }

        scanner.close();
    }
}


class Subsequences {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String str = scanner.nextLine();
        System.out.println("Output:");
        printSubsequences(str);
        scanner.close();
    }

    // Function to print all subsequences of a string
    public static void printSubsequences(String str) {
        int n = str.length();
        // Total possible subsequences = 2^n
        int total = (1 << n); // Using bitwise left shift instead of Math.pow()
        // Run a loop for total possible combinations
        for (int i = 1; i < total; i++) {
            // Convert the counter to binary
            String subsequence = "";
            for (int j = 0; j < n; j++) {
                // Check if jth bit in the counter is set, if yes then include the corresponding character from the input string
                if ((i & (1 << j)) > 0) {
                    subsequence += str.charAt(j);
                }
            }
            // Print the subsequence
            System.out.print(subsequence + ", ");
        }
    }
}

class DeletsForPalindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        int deletions = deletsForPalindrome(str);
        System.out.println("Min number of deletions to make palindrome: " + deletions);
        scanner.close();
    }

    public static int deletsForPalindrome(String str) {
        int length = str.length();
        int[][] dp = new int[length][length];

        for (int gap = 1; gap < length; gap++) {
            for (int start = 0; start + gap < length; start++) {
                int end = start + gap;
                if (str.charAt(start) == str.charAt(end)) {
                    dp[start][end] = dp[start + 1][end - 1];
                } else {
                    dp[start][end] = 1 + Math.min(dp[start + 1][end], dp[start][end - 1]);
                }
            }
        }

        return dp[0][length - 1];
    }
}

class StringCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of strings:");
        int n = Integer.parseInt(scanner.nextLine());
        String[] strings = new String[n];
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }

        String result = canFormCircle(strings) ? "Yes" : "No";
        System.out.println(result);

        scanner.close();
    }
    public static boolean canFormCircle(String[] strings) {
        boolean[] visited = new boolean[strings.length];
        return dfs(strings, 0, visited, strings[0].charAt(0));
    }

    private static boolean dfs(String[] strings, int index, boolean[] visited, char startChar) {
        if (index == strings.length - 1)
            return strings[index].charAt(strings[index].length() - 1) == startChar;

        visited[index] = true;

        for (int i = 0; i < strings.length; i++) {
            if (!visited[i] && strings[i].charAt(0) == strings[index].charAt(strings[index].length() - 1)) {
                if (dfs(strings, i, visited, startChar))
                    return true;
            }
        }
        visited[index] = false;
        return false;
    }
}