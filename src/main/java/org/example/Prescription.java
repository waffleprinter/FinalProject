package org.example;

import java.time.LocalDateTime;

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
}
