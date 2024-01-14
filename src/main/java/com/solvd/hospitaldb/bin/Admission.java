package com.solvd.hospitaldb.bin;

public class Admission {
    private int id;
    private int admitID;
    private int patientID;
    private String admitDate;
    private String dischargeDate;
    private int bedID;

    public Admission(int id, int admitID, int patientID, String admitDate, String dischargeDate, int bedID) {
        this.id = id;
        this.admitID = admitID;
        this.patientID = patientID;
        this.admitDate = admitDate;
        this.dischargeDate = dischargeDate;
        this.bedID = bedID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdmitID() {
        return admitID;
    }

    public void setAdmitID(int admitID) {
        this.admitID = admitID;
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

    @Override
    public String toString() {
        return "Admission{" +
                "id=" + id +
                ", admitNumber=" + admitID +
                ", patientID=" + patientID +
                ", admitDate='" + admitDate + '\'' +
                ", dischargeDate='" + dischargeDate + '\'' +
                ", bedID=" + bedID +
                '}';
    }
}
