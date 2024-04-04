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


class LongestPrefixSuffix {

    public static int longestPrefixSuffix(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps[n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        int result = longestPrefixSuffix(input);
        System.out.println("Length of the longest prefix that is also a suffix: " + result);
    }
}

class SpecificPattern {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user for the dictionary
        System.out.print("Enter words separated by spaces: ");
        String[] dictionary = scanner.nextLine().split("\\s+");

        System.out.print("Enter Input pattern: ");
        String pattern = scanner.nextLine();

        System.out.println("Output:");
        for (String word : dictionary) {
            if (matchesPattern(word, pattern)) {
                System.out.println(word);
            }
        }

        scanner.close();
    }

    public static boolean matchesPattern(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            if (pattern.charAt(i) != 'x' && pattern.charAt(i) != word.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}

class SplitString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input: ");
        String input = scanner.nextLine();

        System.out.println("Output:");
        if (canSplitIntoFourDistinctStrings(input)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        scanner.close();
    }

    public static boolean canSplitIntoFourDistinctStrings(String s) {
        int n = s.length();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    String first = s.substring(0, i);
                    String second = s.substring(i, j);
                    String third = s.substring(j, k);
                    String fourth = s.substring(k);

                    if (!first.equals(second) && !first.equals(third) && !first.equals(fourth) &&
                            !second.equals(third) && !second.equals(fourth) &&
                            !third.equals(fourth)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class ReplaceSpaces {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Input string: ");
        String input = scanner.nextLine();

        String result = replaceSpaces(input);
        System.out.println("Output:");
        System.out.println(result);

        scanner.close();
    }

    public static String replaceSpaces(String input) {
        String replacedString = "";

        for (char c : input.toCharArray()) {
            if (c == ' ') {
                replacedString += "%20";
            } else {
                replacedString += c;
            }
        }

        return replacedString;
    }
}
