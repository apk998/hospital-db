package com.solvd.hospitaldb.bin;

public class Treatment {
    private int id;
    private int treatmentID;
    private String treatmentDescription;
    private String treatmentDate;
    private Appointment apptID;

    public Treatment(int id, int treatmentID, String treatmentDescription, String treatmentDate, Appointment apptID) {
        this.id = id;
        this.treatmentID = treatmentID;
        this.treatmentDescription = treatmentDescription;
        this.treatmentDate = treatmentDate;
        this.apptID = apptID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTreatmentID() {
        return treatmentID;
    }

    public void setTreatmentID(int treatmentID) {
        this.treatmentID = treatmentID;
    }

    public String getTreatmentDescription() {
        return treatmentDescription;
    }

    public void setTreatmentDescription(String treatmentDescription) {
        this.treatmentDescription = treatmentDescription;
    }

    public String getTreatmentDate() {
        return treatmentDate;
    }

    public void setTreatmentDate(String treatmentDate) {
        this.treatmentDate = treatmentDate;
    }

    public Appointment getApptID() {
        return apptID;
    }

    public void setApptID(Appointment apptID) {
        this.apptID = apptID;
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "id=" + id +
                ", treatmentID=" + treatmentID +
                ", treatmentDescription='" + treatmentDescription + '\'' +
                ", treatmentDate='" + treatmentDate + '\'' +
                ", apptID=" + apptID +
                '}';
    }
}
