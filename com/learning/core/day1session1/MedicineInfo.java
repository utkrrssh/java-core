package com.learning.core.day1session1;
public interface MedicineInfo {
    String displayLabel();
}
class Tablet implements MedicineInfo {
    public String displayLabel() {
        return "Store Tablets in a cool dry place.";
    }
}
class Syrup implements MedicineInfo {
    public String displayLabel() {
        return "Syrup is consumable only on prescription.";
    }
}
class Ointment implements MedicineInfo {
    public String displayLabel() {
        return "Ointment is for external use only.";
    }
}

