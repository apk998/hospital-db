package com.solvd.hospitaldb.bin;

public class InsurancePolicy {
    private int id;
    private String policyName;
    private int patientID;
    private int providerID;
    private String coverageDetails;

    public InsurancePolicy(int id, String policyName, int patientID, int providerID, String coverageDetails) {
        this.id = id;
        this.policyName = policyName;
        this.patientID = patientID;
        this.providerID = providerID;
        this.coverageDetails = coverageDetails;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPolicyName() {
        return policyName;
    }
    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }
    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public String getCoverageDetails() {
        return coverageDetails;
    }

    public void setCoverageDetails(String coverageDetails) {
        this.coverageDetails = coverageDetails;
    }

    @Override
    public String toString() {
        return "InsurancePolicy{" +
                "id=" + id +
                ", policyName='" + policyName + '\'' +
                ", patientID=" + patientID +
                ", providerID=" + providerID +
                ", coverageDetails='" + coverageDetails + '\'' +
                '}';
    }
}
