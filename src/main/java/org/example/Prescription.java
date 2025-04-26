package org.example;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class Prescription {
    private String medication;
    private String instructions;
    private LocalDate dateIssued;
    private LocalDate expiryDate;

    public Prescription(String medication, String instructions, LocalDate expiryDate) {
        if (expiryDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("expiryDate cannot be before now");
        }

        this.medication = medication;
        this.instructions = instructions;
        this.dateIssued = LocalDate.now();
        this.expiryDate = expiryDate;
    }

    public void print() {
        System.out.println("Medication: " + medication
        + "\nInstructions: " + instructions
        + "\nDateIssued: " + dateIssued
        + "\nExpiryDate: " + expiryDate);
    }

    public static class PrescriptionComparator implements Comparator<Prescription> {
        private final String type;

        public PrescriptionComparator(String type) {
            this.type = type;
        }

        @Override
        public int compare(Prescription o1, Prescription o2) {
            return switch (type) {
                case "instructions" -> o1.instructions.compareTo(o2.instructions);
                case "dateIssued" -> o1.dateIssued.compareTo(o2.dateIssued);
                case "expiryDate" -> o1.expiryDate.compareTo(o2.expiryDate);
                default -> o1.medication.compareTo(o2.medication);
            };
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Prescription that = (Prescription) o;
        return Objects.equals(medication, that.medication) && Objects.equals(instructions, that.instructions) && Objects.equals(dateIssued, that.dateIssued) && Objects.equals(expiryDate, that.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medication, instructions, dateIssued, expiryDate);
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "medication='" + medication + '\'' +
                ", instructions='" + instructions + '\'' +
                ", dateIssued=" + dateIssued +
                ", expiryDate=" + expiryDate +
                '}';
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public LocalDate getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(LocalDate dateIssued) {
        this.dateIssued = dateIssued;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}
