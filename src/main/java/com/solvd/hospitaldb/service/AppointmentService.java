package com.solvd.hospitaldb.service;

import com.solvd.hospitaldb.bin.Appointment;
import java.util.List;

public interface AppointmentService {
    void scheduleAppt(Appointment appointment);
    void cancelAppt(int id);
    List<Appointment> getApptsForPatient(Integer patientID);
}
