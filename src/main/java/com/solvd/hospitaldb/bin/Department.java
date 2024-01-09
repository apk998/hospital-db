package com.solvd.hospitaldb.bin;

import java.util.List;

public class Department {
    private String deptName;
    private String deptWing;
    private List<Doctor> doctors;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptWing() {
        return deptWing;
    }

    public void setDeptWing(String deptWing) {
        this.deptWing = deptWing;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
