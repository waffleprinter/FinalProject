package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Doctor extends User {
    private List<Appointment> appointments;

    public Doctor(String name, Sex sex) {
        super(name, sex);
        this.appointments = new ArrayList<>();
    }

    public Doctor(String name, Sex sex, List<Appointment> appointments) {
        super(name, sex);
        this.appointments = appointments;
    }

    /**
     * Prescribes a medical order to a patient
     * @param patient The patient in need of a medical order
     * @param medicalOrder The order to be prescribed
     */
    public void prescribeMedicalOrder(Patient patient, MedicalOrder medicalOrder) {
        if (patient == null) {
            throw new NullPointerException("Patient cannot be null");
        }

        if (medicalOrder == null) {
            throw new NullPointerException("Medical order cannot be null");
        }

        if (medicalOrder instanceof Prescription prescription) {
            patient.getPrescriptions().add(prescription);
        } else if (medicalOrder instanceof LabTest labTest) {
            patient.getLabTests().add(labTest);
        } else if (medicalOrder instanceof DonorRequest donorRequest) {
            patient.getDonorRequests().add(donorRequest);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(appointments, doctor.appointments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), appointments);
    }

    @Override
    public String toString() {
        return super.toString() +
                " Doctor{" +
                "appointments=" + appointments +
                '}';
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
