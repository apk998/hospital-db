package com.solvd.hospitaldb.bin;

import java.sql.Timestamp;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "prescription")
@XmlType(propOrder = {"prescriptionId", "medicationName", "prescriptionDate", "apptId"})
public class Prescription {
    private int prescriptionId;
    private String medicationName;
    private Timestamp prescriptionDate;
    private int apptId;
    private List<Prescription> prescriptionList;

    @XmlElement(name = "prescription_id")
    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    @XmlElement(name = "medication_name")
    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    @XmlElement(name = "prescription_date")
    public Timestamp getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(Timestamp prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    @XmlElement(name = "appt_id")
    public int getApptId() {
        return apptId;
    }

    public void setApptId(int apptId) {
        this.apptId = apptId;
    }

    @XmlElement(name = "prescription")
    public List<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public void setPrescriptionList(List<Prescription> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }
}