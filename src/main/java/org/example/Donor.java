package org.example;

import java.util.Objects;

public class Donor extends User {
    private DonorType donorType;
    private BloodType bloodType;
    private boolean isAvailable;

    public Donor(String name, Sex sex, DonorType donorType, boolean isAvailable) {
        this(name, sex, donorType, null, isAvailable);
    }

    public Donor(String name, Sex sex, DonorType donorType, BloodType bloodType, boolean isAvailable) {
        super(name, sex);
        this.donorType = donorType;
        this.bloodType = bloodType;
        this.isAvailable = isAvailable;

        DonationManagementSystem.getDonors().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Donor donor = (Donor) o;
        return isAvailable == donor.isAvailable && donorType == donor.donorType && bloodType == donor.bloodType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), donorType, bloodType, isAvailable);
    }

    @Override
    public String toString() {
        return super.toString() +
                " Donor{" +
                "donorType=" + donorType +
                ", bloodType=" + bloodType +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public DonorType getDonorType() {
        return donorType;
    }

    public void setDonorType(DonorType donorType) {
        this.donorType = donorType;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
