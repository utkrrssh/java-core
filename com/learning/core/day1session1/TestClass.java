package com.learning.core.day1session1;
public class TestClass {
    public static void main(String[] args) {
        // Create instances of different medicines
        MedicineInfo medicine1 = new Tablet();
        MedicineInfo medicine2 = new Syrup();
        MedicineInfo medicine3 = new Ointment();

        // Polymorphic behavior of displayLabel() method
        System.out.println(medicine1.displayLabel());
        System.out.println(medicine2.displayLabel());
        System.out.println(medicine3.displayLabel());
    }
}