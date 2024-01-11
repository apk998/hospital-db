package com.solvd.hospitaldb.bin;

import java.sql.Timestamp;

public class Admission {
    private int admitNumber;
    private int patientID;
    private Timestamp admitDate;
    private Timestamp dischargeDate;
    private int bedID;

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

    public Timestamp getAdmitDate() {
        return admitDate;
    }

    public void setAdmitDate(Timestamp admitDate) {
        this.admitDate = admitDate;
    }

    public Timestamp getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Timestamp dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public int getBedID() {
        return bedID;
    }

    public void setBedID(int bedID) {
        this.bedID = bedID;
    }
}
