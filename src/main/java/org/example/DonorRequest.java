package org.example;

import java.time.LocalDateTime;
import java.util.Objects;

public class DonorRequest extends MedicalOrder {
    private DonorType donorType;
    private BloodType bloodType;
    private LocalDateTime matchDate;
    private LocalDateTime fulfilledDate;

    public DonorRequest(Doctor doctor, Patient patient, DonorType donorType) {
        super(doctor, patient);
        this.donorType = donorType;
    }

    public DonorRequest(Doctor doctor, Patient patient, DonorType donorType, BloodType bloodType) {
        super(doctor, patient);
        this.donorType = donorType;
        this.bloodType = bloodType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DonorRequest that = (DonorRequest) o;
        return donorType == that.donorType && bloodType == that.bloodType && Objects.equals(matchDate, that.matchDate) && Objects.equals(fulfilledDate, that.fulfilledDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), donorType, bloodType, matchDate, fulfilledDate);
    }

    @Override
    public String toString() {
        return super.toString() +
                " DonorRequest{" +
                "donorType=" + donorType +
                ", bloodType=" + bloodType +
                ", matchDate=" + matchDate +
                ", fulfilledDate=" + fulfilledDate +
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
}
