package com.solvd.hospitaldb.bin;

public class Appointment {
    private int id;
    private int apptID;
    private int patientID;
    private int doctorID;
    private String apptDate;

    public Appointment(int id, int apptID, int patientID, int doctorID, String apptDate) {
        this.id = id;
        this.apptID = apptID;
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.apptDate = apptDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApptID() {
        return apptID;
    }

    public void setApptID(int apptID) {
        this.apptID = apptID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getApptDate() {
        return apptDate;
    }

    public void setApptDate(String apptDate) {
        this.apptDate = apptDate;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", apptID=" + apptID +
                ", patientID=" + patientID +
                ", doctorID=" + doctorID +
                ", apptDate='" + apptDate + '\'' +
                '}';
    }
}
