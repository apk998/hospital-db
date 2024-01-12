package com.solvd.hospitaldb.bin;

public class Department {
    private int id;
    private int deptID;
    private String deptName;
    private String deptWing;

    public Department(int id, int deptID, String deptName, String deptWing) {
        this.id = id;
        this.deptID = deptID;
        this.deptName = deptName;
        this.deptWing = deptWing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeptID() {
        return deptID;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

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
}
