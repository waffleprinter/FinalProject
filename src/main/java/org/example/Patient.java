package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Patient extends User {
    private List<Appointment> appointments = new ArrayList<>();
    private List<Prescription> prescriptions = new ArrayList<>();
    private List<DonationType> donorRequests = new ArrayList<>();
    private MedicalRecord medicalRecord; // TODO: Implement MedicalRecord class

    public Patient(String name, Sex sex) {
        super(name, sex);
    }

    public void bookAppointment(Doctor doctor, LocalDateTime time) {
        Appointment appointment = new Appointment(this, doctor, time);
        this.appointments.add(appointment);
        doctor.getAppointments().add(appointment);
    }

    public void viewMedicalRecords() {
        // TODO: Implement
    }

    public void viewPrescriptions() {
        for (Prescription prescription : prescriptions) {
            prescription.print();
            System.out.println();
        }
    }

    public void requestDonor(DonationType type) {
        donorRequests.add(type);
    }

    @Override
    public void displayDashboard() {
        System.out.println("=== Patient Dashboard ===");
        System.out.println("Name: " + getName());
        System.out.println("Sex: " + getSex());
        System.out.println();

        System.out.println("=== Appointments ===");
        if (appointments.isEmpty()) {
            System.out.println("You have no appointments");
        } else {
            for (Appointment appointment : appointments) {
                System.out.println("Appointment at " + appointment.getTime()
                        + "with Dr. " + appointment.getDoctor().getName()
                        + ". Confirmed: " + appointment.isConfirmed());
            }
        }

        System.out.println("=== Prescriptions ===");
        if (prescriptions.isEmpty()) {
            System.out.println("You have no prescriptions");
        } else {
            for (Prescription prescription : prescriptions) {
                prescription.print();
                System.out.println();
            }
        }

        System.out.println("=== Donor Requests ===");
        if (donorRequests.isEmpty()) {
            System.out.println("You have no donor requests");
        } else {
            for (DonationType donorRequest : donorRequests) {
                System.out.println(donorRequest);
            }
        }

        // TODO: Implement medicalRecord summary
    }

    public enum DonationType {
        BLOOD, EYE
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(appointments, patient.appointments) && Objects.equals(prescriptions, patient.prescriptions) && Objects.equals(donorRequests, patient.donorRequests) && Objects.equals(medicalRecord, patient.medicalRecord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), appointments, prescriptions, donorRequests, medicalRecord);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Patient{" +
                "appointments=" + appointments +
                ", prescriptions=" + prescriptions +
                ", medicalRecord=" + medicalRecord +
                ", donorRequests=" + donorRequests +
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

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public List<DonationType> getDonorRequests() {
        return donorRequests;
    }

    public void setDonorRequests(List<DonationType> donorRequests) {
        this.donorRequests = donorRequests;
    }
}
