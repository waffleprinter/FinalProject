package org.example;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class MedicalOrder {
    private static int nextId = 0;

    private int id;
    private Doctor doctor;
    private Patient patient;
    private LocalDateTime issueDate;
    private Status status;

    public MedicalOrder(Doctor doctor, Patient patient) {
        this.id = nextId++;
        this.doctor = doctor;
        this.patient = patient;
        this.issueDate = LocalDateTime.now();
        this.status = Status.IN_PROGRESS;
    }

    public enum Status {
        IN_PROGRESS, CANCELLED, COMPLETED
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MedicalOrder that = (MedicalOrder) o;
        return id == that.id && Objects.equals(doctor, that.doctor) && Objects.equals(patient, that.patient) && Objects.equals(issueDate, that.issueDate) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctor, patient, issueDate, status);
    }

    @Override
    public String toString() {
        return "MedicalOrder{" +
                "id=" + id +
                ", doctor=" + doctor +
                ", patient=" + patient +
                ", issueDate=" + issueDate +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
