package org.example;

import java.time.LocalDateTime;
import java.util.Objects;

public class DonorRequest extends MedicalOrder {
    private DonorType donorType;
    private BloodType bloodType;
    private LocalDateTime matchDate;
    private LocalDateTime fulfilledDate;
    private Donor donor;

    public DonorRequest(Doctor doctor, Patient patient, DonorType donorType) {
        this(doctor, patient, donorType, null);
    }

    public DonorRequest(Doctor doctor, Patient patient, DonorType donorType, BloodType bloodType) {
        super(doctor, patient);
        this.donorType = donorType;
        this.bloodType = bloodType;
        this.matchDate = null;
        this.fulfilledDate = null;
        this.donor = null;
    }

    /**
     * Simply print the relevant information
     */
    @Override
    public void print() {
        System.out.println("Donor Type: " + donorType
        + "\nBlood Type: " + bloodType
        + "\nMatch Date: " + matchDate
        + "\nFulfilled Date: " + fulfilledDate
        + "\nDonor: " + donor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DonorRequest that = (DonorRequest) o;
        return donorType == that.donorType && bloodType == that.bloodType && Objects.equals(matchDate, that.matchDate) && Objects.equals(fulfilledDate, that.fulfilledDate) && Objects.equals(donor, that.donor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), donorType, bloodType, matchDate, fulfilledDate, donor);
    }

    @Override
    public String toString() {
        return super.toString() +
                " DonorRequest{" +
                "donorType=" + donorType +
                ", bloodType=" + bloodType +
                ", matchDate=" + matchDate +
                ", fulfilledDate=" + fulfilledDate +
                ", donor=" + donor +
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

    public LocalDateTime getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDateTime matchDate) {
        this.matchDate = matchDate;
    }

    public LocalDateTime getFulfilledDate() {
        return fulfilledDate;
    }

    public void setFulfilledDate(LocalDateTime fulfilledDate) {
        this.fulfilledDate = fulfilledDate;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }
}
