package org.example;

import java.time.LocalDateTime;
import java.util.Objects;

public class Appointment implements Comparable<Appointment> {
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime date;
    private Status status;

    public Appointment(Patient patient, Doctor doctor, LocalDateTime date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.status = Status.REQUESTED;
    }

    /**
     * Cancel a requested/confirmed appointment. Does nothing if the appointment is already canceled or completed.
     * @return Whether the appointment was successfully canceled.
     */
    public boolean cancel()  {
        if (status == Status.REQUESTED || status == Status.CONFIRMED) {
            status = Status.CANCELED;
            return true;
        }

        return false;
    }

    /**
     * Confirm a requested appointment. Does nothing if the appointment is already confirmed, canceled
     * or completed.
     * @return Whether the appointment was successfully confirmed.
     */
    public boolean confirm()  {
        if (status == Status.REQUESTED) {
            status = Status.CONFIRMED;
            return true;
        }

        return false;
    }

    public void print() {
        System.out.println("Patient: " + patient.getName()
        + "\nDoctor: " + doctor
        + "\nDate: " + date
        + "\nStatus: " + status);
    }

    @Override
    public int compareTo(Appointment o) {
        return date.compareTo(o.date);
    }

    public enum Status {
        REQUESTED, CANCELED, CONFIRMED, COMPLETED
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(patient, that.patient) && Objects.equals(doctor, that.doctor) && Objects.equals(date, that.date) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient, doctor, date, status);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "patient=" + patient.getName() +
                ", doctor=" + doctor.getName() +
                ", date=" + date +
                ", status=" + status +
                '}';
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
