package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HospitalManagementSystem {
    private static List<Patient> patients = new ArrayList<>();
    private static List<Donor> donors = new ArrayList<>();
    private static List<Doctor> doctors = new ArrayList<>();

    private static Map<Donor, DonorRequest> donorMatches = new HashMap<>();

    /**
     * Matches as many available donors to patients as possible, assuming they match the requirements
     */
    public static void matchPatientsToDonors() {
        for (Patient patient : patients) {;
            for (DonorRequest donorRequest : patient.getDonorRequests()) {
                if (donorRequest.getFulfilledDate() != null) continue;

                for (Donor donor : donors) {
                    if (!donor.isAvailable()) continue;
                    if (donor.getDonorType() != donorRequest.getDonorType()) continue;
                    // TODO: Actual blood types don't need to match one to one,
                    // TODO: e.g. O- should be able to donate to anyone, so implement actual blood type matching
                    if (donor.getDonorType() == DonorType.BLOOD && donor.getBloodType() != donorRequest.getBloodType()) continue;

                    donorRequest.setMatchDate(LocalDateTime.now());
                    donor.setAvailable(false);
                    donorMatches.put(donor, donorRequest);
                }
            }
        }
    }

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

    public static Map<Donor, DonorRequest> getDonorMatches() {
        return donorMatches;
    }

    public static void setDonorMatches(Map<Donor, DonorRequest> donorMatches) {
        HospitalManagementSystem.donorMatches = donorMatches;
    }
}
