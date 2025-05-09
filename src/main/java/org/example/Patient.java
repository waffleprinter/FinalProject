package org.example;

import java.util.List;
import java.util.Objects;

public class Patient extends User {
    private List<Appointment> appointments;
    private List<Prescription> prescriptions;
    private List<LabTest> labTests;
    private BloodType bloodType;
    private DonorRequest donorRequest;

    public Patient(String name, Sex sex) {
        super(name, sex);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(appointments, patient.appointments) && Objects.equals(prescriptions, patient.prescriptions) && Objects.equals(labTests, patient.labTests) && bloodType == patient.bloodType && Objects.equals(donorRequest, patient.donorRequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), appointments, prescriptions, labTests, bloodType, donorRequest);
    }

    @Override
    public String toString() {
        return super.toString() +
                " Patient{" +
                "appointments=" + appointments +
                ", prescriptions=" + prescriptions +
                ", labTests=" + labTests +
                ", bloodType=" + bloodType +
                ", donorRequest=" + donorRequest +
                '}';
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public List<LabTest> getLabTests() {
        return labTests;
    }

    public void setLabTests(List<LabTest> labTests) {
        this.labTests = labTests;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public DonorRequest getDonorRequest() {
        return donorRequest;
    }

    public void setDonorRequest(DonorRequest donorRequest) {
        this.donorRequest = donorRequest;
    }
}
