package com.solvd.hospitaldb.bin;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "prescription")
@XmlAccessorType(XmlAccessType.FIELD)
public class Prescription {
    @XmlAttribute(name = "id")
    private int id;
    @XmlAttribute(name = "prescription_id")
    private int prescriptionID;
    @XmlAttribute(name = "medication_id")
    private Medication medicationID;
    @XmlAttribute(name = "prescription_date")
    private String prescriptionDate;
    @XmlAttribute(name = "prescription_date")
    private Appointment apptID;

    public Prescription(int id, int prescriptionID, Medication medicationID, String prescriptionDate, Appointment apptID) {
        this.id = id;
        this.prescriptionID = prescriptionID;
        this.medicationID = medicationID;
        this.prescriptionDate = prescriptionDate;
        this.apptID = apptID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public Medication getMedicationID() {
        return medicationID;
    }

    public void setMedicationID(Medication medicationID) {
        this.medicationID = medicationID;
    }

    public String getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(String prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public Appointment getApptID() {
        return apptID;
    }

    public void setApptID(Appointment apptID) {
        this.apptID = apptID;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", prescriptionID=" + prescriptionID +
                ", medicationID=" + medicationID +
                ", prescriptionDate='" + prescriptionDate + '\'' +
                ", apptId=" + apptID +
                '}';
    }
}