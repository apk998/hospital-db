package com.solvd.hospitaldb.bin;

public class Surgery {
    private int id;
    private int surgeryID;
    private String surgeryName;
    private String surgeryDate;
    private Appointment apptID;

    public Surgery(int id, int surgeryID, String surgeryName, String surgeryDate, Appointment apptID) {
        this.id = id;
        this.surgeryID = surgeryID;
        this.surgeryName = surgeryName;
        this.surgeryDate = surgeryDate;
        this.apptID = apptID;
    }

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

    public Appointment getApptID() {
        return apptID;
    }

    public void setApptID(Appointment apptID) {
        this.apptID = apptID;
    }

    @Override
    public String toString() {
        return "Surgery{" +
                "id=" + id +
                ", surgeryID=" + surgeryID +
                ", surgeryName='" + surgeryName + '\'' +
                ", surgeryDate='" + surgeryDate + '\'' +
                ", apptID=" + apptID +
                '}';
    }
}
