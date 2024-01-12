package com.solvd.hospitaldb.bin;

public class Admission {
    private int id;
    private int admitNumber;
    private int patientID;
    private String admitDate;
    private String dischargeDate;
    private int bedID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdmitNumber() {
        return admitNumber;
    }

    public void setAdmitNumber(int admitNumber) {
        this.admitNumber = admitNumber;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getAdmitDate() {
        return admitDate;
    }

    public void setAdmitDate(String admitDate) {
        this.admitDate = admitDate;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public int getBedID() {
        return bedID;
    }

    public void setBedID(int bedID) {
        this.bedID = bedID;
    }
}
