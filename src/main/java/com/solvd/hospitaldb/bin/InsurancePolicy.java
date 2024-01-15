package com.solvd.hospitaldb.bin;

public class InsurancePolicy {
    private int id;
    private int policyID;
    private String policyName;
    private Patient patientID;
    private InsuranceProvider providerID;
    private String coverageDetails;

    public InsurancePolicy(int id, int policyID, String policyName, Patient patientID, InsuranceProvider providerID, String coverageDetails) {
        this.id = id;
        this.policyID = policyID;
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
    public int getPolicyID() {
        return policyID;
    }
    public void setPolicyID(int policyID) {
        this.policyID = policyID;
    }
    public String getPolicyName() {
        return policyName;
    }
    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }
    public Patient getPatientID() {
        return patientID;
    }

    public void setPatientID(Patient patientID) {
        this.patientID = patientID;
    }

    public InsuranceProvider getProviderID() {
        return providerID;
    }

    public void setProviderID(InsuranceProvider providerID) {
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
                ", policyID=" + policyID + '\'' +
                ", policyName='" + policyName + '\'' +
                ", patientID=" + patientID +
                ", providerID=" + providerID +
                ", coverageDetails='" + coverageDetails + '\'' +
                '}';
    }
}
