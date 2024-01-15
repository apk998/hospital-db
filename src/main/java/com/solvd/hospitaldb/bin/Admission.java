package com.solvd.hospitaldb.bin;

public class Admission {
    private int id;
    private int admitID;
    private Patient patientID;
    private String admitDate;
    private String dischargeDate;
    private Bed bedID;

    public Admission(int id, int admitID, Patient patientID, String admitDate, String dischargeDate, Bed bedID) {
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

    public Patient getPatientID() {
        return patientID;
    }

    public void setPatientID(Patient patientID) {
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

    public Bed getBedID() {
        return bedID;
    }

    public void setBedID(Bed bedID) {
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
