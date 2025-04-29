package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Patient extends User {
    private List<Appointment> appointments = new ArrayList<>();
    private List<Prescription> prescriptions = new ArrayList<>();
    private MedicalRecord medicalRecord; // TODO: Implement MedicalRecord class

    public Patient(String name, Sex sex) {
        super(name, sex);
    }

    public void bookAppointment(Doctor doctor, LocalDateTime time) {
        // TODO: Implement Doctor class
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

    public void requestDonor(String type) {
        // TODO: Implement
    }

    @Override
    public void displayDashboard() {
        // TODO: Implement
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(appointments, patient.appointments) && Objects.equals(prescriptions, patient.prescriptions) && Objects.equals(medicalRecord, patient.medicalRecord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), appointments, prescriptions, medicalRecord);
    }

    @Override
    public String toString() {
        return super.toString() +
                " Patient{" +
                "appointments=" + appointments +
                ", prescriptions=" + prescriptions +
                ", medicalRecord=" + medicalRecord +
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
}
