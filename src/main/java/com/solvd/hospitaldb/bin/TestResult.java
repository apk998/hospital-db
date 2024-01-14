package com.solvd.hospitaldb.bin;

public class TestResult {
    private int id;
    private int resultID;
    private int patientID;
    private int testID;
    private String resultDetails;
    private String testDate;

    public TestResult(int id, int resultID, int patientID, int testID, String resultDetails, String testDate) {
        this.id = id;
        this.resultID = resultID;
        this.patientID = patientID;
        this.testID = testID;
        this.resultDetails = resultDetails;
        this.testDate = testDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResultID() {
        return resultID;
    }

    public void setResultID(int resultID) {
        this.resultID = resultID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public String getResultDetails() {
        return resultDetails;
    }

    public void setResultDetails(String resultDetails) {
        this.resultDetails = resultDetails;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "id=" + id +
                ", resultID=" + resultID +
                ", patientID=" + patientID +
                ", testID=" + testID +
                ", resultDetails='" + resultDetails + '\'' +
                ", testDate='" + testDate + '\'' +
                '}';
    }
}
