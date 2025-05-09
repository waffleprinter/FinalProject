package org.example;

import java.time.LocalDateTime;
import java.util.Objects;

public class Prescription extends MedicalOrder {
    private String medication;
    private String dosage;
    private String frequency;
    private LocalDateTime expiryDate;

    public Prescription(Doctor doctor, Patient patient, String medication, String dosage, String frequency, LocalDateTime expiryDate) {
        super(doctor, patient);
        this.medication = medication;
        this.dosage = dosage;
        this.frequency = frequency;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Prescription that = (Prescription) o;
        return Objects.equals(medication, that.medication) && Objects.equals(dosage, that.dosage) && Objects.equals(frequency, that.frequency) && Objects.equals(expiryDate, that.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), medication, dosage, frequency, expiryDate);
    }

    @Override
    public String toString() {
        return super.toString() +
                " Prescription{" +
                "medication='" + medication + '\'' +
                ", dosage='" + dosage + '\'' +
                ", frequency='" + frequency + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }
}
