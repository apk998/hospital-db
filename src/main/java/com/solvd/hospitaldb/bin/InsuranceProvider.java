package com.solvd.hospitaldb.bin;

public class InsuranceProvider {
    private int id;
    private String providerName;
    private String contactNumber;
    private String address;

    public InsuranceProvider(int id, String providerName, String contactNumber, String address) {
        this.id = id;
        this.providerName = providerName;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "InsuranceProvider{" +
                "id=" + id +
                ", providerName='" + providerName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
