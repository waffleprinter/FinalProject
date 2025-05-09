package org.example;

import java.time.LocalDateTime;
import java.util.Objects;

public class LabTest extends MedicalOrder {
    private String labName;
    private LocalDateTime collectionDate;
    private LocalDateTime resultDate;
    private String summary;

    public LabTest(Doctor doctor, Patient patient, String labName) {
        super(doctor, patient);
        this.labName = labName;
    }

    /**
     * Simply prints the relevant information
     */
    public void print() {
        System.out.println("Lab Name: " + labName
        + "\nCollection Date: " + collectionDate
        + "\nResult Date: " + resultDate
        + "\nSummary: " + summary
        + "\nStatus: " + this.getStatus());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LabTest labTest = (LabTest) o;
        return Objects.equals(labName, labTest.labName) && Objects.equals(collectionDate, labTest.collectionDate) && Objects.equals(resultDate, labTest.resultDate) && Objects.equals(summary, labTest.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), labName, collectionDate, resultDate, summary);
    }

    @Override
    public String toString() {
        return super.toString() +
                " LabTest{" +
                "labName='" + labName + '\'' +
                ", collectionDate=" + collectionDate +
                ", resultDate=" + resultDate +
                ", summary='" + summary + '\'' +
                '}';
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public LocalDateTime getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(LocalDateTime collectionDate) {
        this.collectionDate = collectionDate;
    }

    public LocalDateTime getResultDate() {
        return resultDate;
    }

    public void setResultDate(LocalDateTime resultDate) {
        this.resultDate = resultDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
