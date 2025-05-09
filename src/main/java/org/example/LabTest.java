package org.example;

import java.time.LocalDateTime;

public class LabTest extends MedicalOrder {
    private String labName;
    private LocalDateTime collectionDate;
    private LocalDateTime resultDate;
    private String summary;

    public LabTest(Doctor doctor, Patient patient, String labName) {
        super(doctor, patient);
        this.labName = labName;
    }


}
