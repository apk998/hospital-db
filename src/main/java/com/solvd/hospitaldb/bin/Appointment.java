package com.solvd.hospitaldb.bin;

public class Appointment {
    private int id;
    private Integer apptID;
    private Patient patientID;
    private Doctor doctorID;
    private String apptDate;

    public Appointment(int id, Integer apptID, Patient patientID, Doctor doctorID, String apptDate) {
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

    public Integer getApptID() {
        return apptID;
    }

    public void setApptID(Integer apptID) {
        this.apptID = apptID;
    }

    public Patient getPatientID() {
        return patientID;
    }

    public void setPatientID(Patient patientID) {
        this.patientID = patientID;
    }

    public Doctor getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Doctor doctorID) {
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
