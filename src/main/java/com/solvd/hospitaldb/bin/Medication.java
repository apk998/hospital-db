package com.solvd.hospitaldb.bin;

public class Medication {
    private int id;
    private Integer medicationID;
    private String medicationName;
    private String dosage;
    private String usageInstructions;

    public Medication(int id, Integer medicationID, String medicationName, String dosage, String usageInstructions) {
        this.id = id;
        this.medicationID = medicationID;
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.usageInstructions = usageInstructions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getMedicationID() {
        return medicationID;
    }

    public void setMedicationID(Integer medicationID) {
        this.medicationID = medicationID;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }
    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getUsageInstructions() {
        return usageInstructions;
    }

    public void setUsageInstructions(String usageInstructions) {
        this.usageInstructions = usageInstructions;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "id=" + id +
                ", medicationID=" + medicationID + '\'' +
                ", medicationName='" + medicationName + '\'' +
                ", dosage='" + dosage + '\'' +
                ", usageInstructions='" + usageInstructions + '\'' +
                '}';
    }
}
