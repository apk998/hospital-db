package com.solvd.hospitaldb.bin;

public class Surgery {
    private int id;
    private int surgeryID;
    private String surgeryName;
    private String surgeryDate;
    private int apptID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getSurgeryDate() {
        return surgeryDate;
    }

    public void setSurgeryDate(String surgeryDate) {
        this.surgeryDate = surgeryDate;
    }

    public int getApptID() {
        return apptID;
    }

    public void setApptID(int apptID) {
        this.apptID = apptID;
    }
}
