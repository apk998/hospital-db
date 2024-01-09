package com.solvd.hospitaldb.bin;

import java.sql.Timestamp;

public class Treatment {
    private int treatmentID;
    private String treatmentDescription;
    private Timestamp treatmentDate;
    private int apptID;

    public int getTreatmentID() {
        return treatmentID;
    }

    public void setTreatmentID(int treatmentID) {
        this.treatmentID = treatmentID;
    }

    public String getTreatmentDescription() {
        return treatmentDescription;
    }

    public void setTreatmentDescription(String treatmentDescription) {
        this.treatmentDescription = treatmentDescription;
    }

    public Timestamp getTreatmentDate() {
        return treatmentDate;
    }

    public void setTreatmentDate(Timestamp treatmentDate) {
        this.treatmentDate = treatmentDate;
    }

    public int getApptID() {
        return apptID;
    }

    public void setApptID(int apptID) {
        this.apptID = apptID;
    }
}
