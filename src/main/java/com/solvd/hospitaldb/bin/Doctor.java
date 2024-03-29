package com.solvd.hospitaldb.bin;

public class Doctor {
    private int id;
    private Integer doctorID;
    private String firstName;
    private String lastName;
    private Department department;
    private String contactNumber;

    public Doctor(int id, Integer doctorID, String firstName, String lastName, Department department, String contactNumber) {
        this.id = id;
        this.doctorID = doctorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.contactNumber = contactNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Integer doctorID) {
        this.doctorID = doctorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", doctorID=" + doctorID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
