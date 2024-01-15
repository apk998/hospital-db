package com.solvd.hospitaldb.service;

public interface CheckupService {
    void scheduleCheckup(int patientID, int doctorID, String apptDate);
    void cancelCheckup(int id);
}
