package com.solvd.hospitaldb.bin;

public class LabTest {
    private int id;
    private Integer testID;
    private String testName;
    private String testDescription;

    public LabTest(int id, Integer testID, String testName, String testDescription) {
        this.id = id;
        this.testID = testID;
        this.testName = testName;
        this.testDescription = testDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getTestID() {
        return testID;
    }

    public void setTestID(Integer testID) {
        this.testID = testID;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public void setTestDescription(String testDescription) {
        this.testDescription = testDescription;
    }

    @Override
    public String toString() {
        return "LabTest{" +
                "id=" + id +
                ", testID=" + testID +
                ", testName='" + testName + '\'' +
                ", testDescription='" + testDescription + '\'' +
                '}';
    }
}
