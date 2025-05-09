package org.example;

import java.time.LocalDateTime;

public class MedicalOrder {
    private int id;
    private Doctor doctor;
    private Patient patient;
    private LocalDateTime issueDate;
    private Status status;

    public enum Status {
        PENDING, IN_PROGRESS, COMPLETED, CANCELLED, EXPIRED, FAILED
    }
}
