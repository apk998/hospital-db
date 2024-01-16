package com.solvd.hospitaldb.dao;

import com.solvd.hospitaldb.bin.Appointment;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

public interface AppointmentDAO extends BaseDAO<Appointment> {
    void create(Appointment appointment);

    Optional<Appointment> findByID(int id);

    void updateByID(@Param("appointment") Appointment appointment, @Param("id") int id);

    void deleteByID(Appointment appointment);

    List<Appointment> getApptsForPatient(Integer patientID);
}
