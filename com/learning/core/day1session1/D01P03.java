package com.learning.core.day1session1;

import java.util.Scanner;

class Month {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a number between 1 to 12: ");
            int monthNumber = scanner.nextInt();

            if (monthNumber >= 1 && monthNumber <= 12) {
                String monthName = getMonthName(monthNumber);
                System.out.println(monthName);
                break;
            } else {
                System.out.println("Invalid Input");
            }
        }
    }
    public static String getMonthName(int monthNumber) {
        String monthName;
        switch (monthNumber) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
            default:
                monthName = "Invalid Input";
        }
        return monthName;
    }
}

class Weekday {
    public static void main(String[] args) {
        int[] input = {2, -4, 9};

        for (int week : input) {
            String weekday = getWeekday(week);
            System.out.println("Input: " + week + "  Output: " + weekday);
        }
    }

    public static String getWeekday(int week) {
        if (week == 1) {
            return "Monday";
        } else if (week == 2) {
            return "Tuesday";
        } else if (week == 3) {
            return "Wednesday";
        } else if (week == 4) {
            return "Thursday";
        } else if (week == 5) {
            return "Friday";
        } else if (week == 6) {
            return "Saturday";
        } else if (week == 7) {
            return "Sunday";
        } else {
            return "Invalid Input";
        }
    }
}

class Grade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input %: ");
        int marks = scanner.nextInt();
        String grade = Grade(marks);
        System.out.println("Output: " + grade);
    }
    public static String Grade(int marks) {
        if (marks >= 60) {
            return "A Grade";
        } else if (marks >= 45) {
            return "B Grade";
        } else if (marks >= 35) {
            return "C Grade";
        } else {
            return "Fail";
        }
    }
}

class TrianglePattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input: ");
        int number = scanner.nextInt();
        triangle(number);
    }
    public static void triangle(int number) {
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}


class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input: ");
        int num = sc.nextInt();
        int i = 1, factorial = 1;
        while (i <= num) {
            factorial = factorial * i;
            i++;
        }

        System.out.println("Factorial of " + num + " is " + factorial);
    }
}