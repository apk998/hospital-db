package com.solvd.hospitaldb.bin;

import java.sql.Timestamp;

public class Appointment {
    private int apptID;
    private int patientID;
    private int doctorID;
    private Timestamp apptDate;

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

    public Timestamp getApptDate() {
        return apptDate;
    }

    public void setApptDate(Timestamp apptDate) {
        this.apptDate = apptDate;
    }
}
