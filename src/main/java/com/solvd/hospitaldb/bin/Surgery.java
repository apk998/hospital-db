package com.solvd.hospitaldb.bin;

import java.sql.Timestamp;

public class Surgery {
    private int surgeryID;
    private String surgeryName;
    private Timestamp surgeryDate;
    private int apptID;

    public int getSurgeryID() {
        return surgeryID;
    }

    public void setSurgeryID(int surgeryID) {
        this.surgeryID = surgeryID;
    }

    public String getSurgeryName() {
        return surgeryName;
    }

    public void setSurgeryName(String surgeryName) {
        this.surgeryName = surgeryName;
    }

    public Timestamp getSurgeryDate() {
        return surgeryDate;
    }

    public void setSurgeryDate(Timestamp surgeryDate) {
        this.surgeryDate = surgeryDate;
    }

    public int getApptID() {
        return apptID;
    }

    public void setApptID(int apptID) {
        this.apptID = apptID;
    }
}
