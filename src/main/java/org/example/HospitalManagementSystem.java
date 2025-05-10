package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HospitalManagementSystem {
    private static List<Patient> patients = new ArrayList<>();
    private static List<Donor> donors = new ArrayList<>();
    private static List<Doctor> doctors = new ArrayList<>();

    public static List<Patient> getPatients() {
        return patients;
    }

    public static void setPatients(List<Patient> patients) {
        HospitalManagementSystem.patients = patients;
    }

    public static List<Donor> getDonors() {
        return donors;
    }

    public static void setDonors(List<Donor> donors) {
        HospitalManagementSystem.donors = donors;
    }

    public static List<Doctor> getDoctors() {
        return doctors;
    }

    public static void setDoctors(List<Doctor> doctors) {
        HospitalManagementSystem.doctors = doctors;
    }
}
