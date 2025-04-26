package org.example;

import java.time.LocalDateTime;
import java.util.Objects;

public class Appointment implements Comparable<Appointment> {
    private Patient patient; // TODO: Implement Patient class
    private Doctor doctor; // TODO: Implement Doctor class
    private LocalDateTime time;
    private boolean confirmed;

    public Appointment(Patient patient, Doctor doctor, LocalDateTime time) {
        if (time.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("The time must be after the current time");
        }

        this.patient = patient;
        this.doctor = doctor;
        this.time = time;
        this.confirmed = false;
    }

    public void confirm() {
        this.confirmed = true;
    }

    public void cancel() {
        // TODO: Figure out how to do this, idk what to do
    }

    @Override
    public int compareTo(Appointment o) {
        return this.time.compareTo(o.time);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return confirmed == that.confirmed && Objects.equals(patient, that.patient) && Objects.equals(doctor, that.doctor) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient, doctor, time, confirmed);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "patient=" + patient +
                ", doctor=" + doctor +
                ", time=" + time +
                ", confirmed=" + confirmed +
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}
