package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Patient extends User {
    private List<Appointment> appointments;
    private List<Prescription> prescriptions;
    private List<LabTest> labTests;
    private BloodType bloodType;
    private List<DonorRequest> donorRequests;

    public Patient(String name, Sex sex) {
        super(name, sex);
        this.appointments = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
        this.labTests = new ArrayList<>();
        this.bloodType = null;
        this.donorRequests = new ArrayList<>();

        HospitalManagementSystem.getPatients().add(this);
    }

    /**
     * Schedules an appointment with a doctor. The doctor must still confirm the appointment.
     * @param doctor The doctor that the appointment should be scheduled with
     */
    public void scheduleAppointment(Doctor doctor, LocalDateTime time) {
        if (doctor == null) {
            throw new NullPointerException("Doctor cannot be null");
        }

        if (time.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("The time must be after the current time");
        }

        Appointment appointment = new Appointment(this, doctor, time);

        this.appointments.add(appointment);
        doctor.getAppointments().add(appointment);
    }

    public void viewPrescriptions() {
        for (Prescription prescription : prescriptions) {
            prescription.print();
        }
    }

    public void viewLabTests() {
        for (LabTest labTest : labTests) {
            labTest.print();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(appointments, patient.appointments) && Objects.equals(prescriptions, patient.prescriptions) && Objects.equals(labTests, patient.labTests) && bloodType == patient.bloodType && Objects.equals(donorRequests, patient.donorRequests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), appointments, prescriptions, labTests, bloodType, donorRequests);
    }

    @Override
    public String toString() {
        return super.toString() +
                " Patient{" +
                "appointments=" + appointments +
                ", prescriptions=" + prescriptions +
                ", labTests=" + labTests +
                ", bloodType=" + bloodType +
                ", donorRequest=" + donorRequests +
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

    public List<DonorRequest> getDonorRequests() {
        return donorRequests;
    }

    public void setDonorRequests(List<DonorRequest> donorRequests) {
        this.donorRequests = donorRequests;
    }
}
