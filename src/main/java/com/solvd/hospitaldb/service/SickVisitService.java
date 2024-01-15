package com.solvd.hospitaldb.service;

public interface SickVisitService {
    void scheduleSickVisit(int patientID, int doctorID, String reason, String apptDate);
    void cancelSickVisit(int id);
}
