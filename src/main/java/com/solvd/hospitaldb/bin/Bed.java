package com.solvd.hospitaldb.bin;

public class Bed {
    private int id;
    private int bedID;
    private int wardNumber;
    private boolean availability;

    public Bed(int id, int bedID, int wardNumber, boolean availability) {
        this.id = id;
        this.bedID = bedID;
        this.wardNumber = wardNumber;
        this.availability = availability;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBedID() {
        return bedID;
    }

    public void setBedID(int bedID) {
        this.bedID = bedID;
    }

    public int getWardNumber() {
        return wardNumber;
    }

    public void setWardNumber(int wardNumber) {
        this.wardNumber = wardNumber;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Bed{" +
                "id=" + id +
                ", bedID=" + bedID +
                ", wardNumber=" + wardNumber +
                ", availability=" + availability +
                '}';
    }
}
