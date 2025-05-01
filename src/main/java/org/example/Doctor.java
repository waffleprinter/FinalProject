package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Doctor extends User {
    private List<Appointment> appointments = new ArrayList<>();

    public Doctor(String name, Sex sex) {
        super(name, sex);
    }

    public void viewAppointments() {
        for (Appointment appointment : appointments) {
            Patient patient = appointment.getPatient();
            LocalDateTime time = appointment.getTime();
            boolean confirmed = appointment.isConfirmed();

            System.out.println("Patient: " + patient
                    + "\nTime: " + time
                    + "\nConfirmed?: " + confirmed
                    + "\n");
        }
    }

    public void viewPrescriptions(Patient patient) {
        patient.viewPrescriptions();
    }

    public void viewMedicalRecords(Patient patient) {
        patient.viewMedicalRecords();
    }

    public void provideConsultation(Patient patient, String consultation) {
        // TODO: Implement medicalRecord class to be able to provide consultation
        // (medicalRecord class is not included in the deliverable 2 requirements that I set last time)
    }

    public void providePrescription(Patient patient, Prescription prescription) {
        patient.getPrescriptions().add(prescription);
    }

    public void updateMedicalRecords(Patient patient, MedicalRecord medicalRecord) {
        patient.setMedicalRecord(medicalRecord);
    }

    @Override
    public void displayDashboard() {
        System.out.println("=== Doctor Dashboard ===");
        System.out.println("Name: " + getName());
        System.out.println("Sex: " + getSex());
        System.out.println();

        System.out.println("=== Appointments ===");
        if (appointments.isEmpty()) {
            System.out.println("You have no appointments");
        } else {
            for (Appointment appointment : appointments) {
                System.out.println("Appointment at " + appointment.getTime()
                        + "with " + appointment.getPatient().getName()
                        + ". Confirmed: " + appointment.isConfirmed());
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(appointments, doctor.appointments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), appointments);
    }

    @Override
    public String toString() {
        return super.toString() +
                " Doctor{" +
                "appointments=" + appointments +
                '}';
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
