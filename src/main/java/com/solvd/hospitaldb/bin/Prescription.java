package com.solvd.hospitaldb.bin;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "prescription")
@XmlType(propOrder = {"prescriptionId", "medicationName", "prescriptionDate", "apptId"})
public class Prescription {
    private int id;
    private int prescriptionID;
    private Medication medicationID;
    private String prescriptionDate;
    private Appointment apptID;
    private List<Prescription> prescriptionList;

    public Prescription(int id, int prescriptionID, Medication medicationID, String prescriptionDate, Appointment apptID, List<Prescription> prescriptionList) {
        this.id = id;
        this.prescriptionID = prescriptionID;
        this.medicationID = medicationID;
        this.prescriptionDate = prescriptionDate;
        this.apptID = apptID;
        this.prescriptionList = prescriptionList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "prescription_id")
    public int getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    @XmlElement(name = "medication_name")
    public Medication getMedicationID() {
        return medicationID;
    }

    public void setMedicationID(Medication medicationID) {
        this.medicationID = medicationID;
    }

    @XmlElement(name = "prescription_date")
    public String getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(String prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    @XmlElement(name = "appt_id")
    public Appointment getApptID() {
        return apptID;
    }

    public void setApptID(Appointment apptID) {
        this.apptID = apptID;
    }

    @XmlElement(name = "prescription")
    public List<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public void setPrescriptionList(List<Prescription> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", prescriptionID=" + prescriptionID +
                ", medicationID=" + medicationID +
                ", prescriptionDate='" + prescriptionDate + '\'' +
                ", apptId=" + apptID +
                ", prescriptionList=" + prescriptionList +
                '}';
    }
}