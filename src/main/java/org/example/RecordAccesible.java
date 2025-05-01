package org.example;

public interface RecordAccesible {
    void viewMedicalRecords(Patient patient);
    void updateMedicalRecords(Patient patient, MedicalRecord medicalRecord);
}
