import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HospitalManagementSystemTest {

    @Test
    public void matchPatientsToDonorsTest() {
        Doctor doctor = new Doctor("doctor", User.Sex.FEMALE);

        Patient patient1 = new Patient("patient1", User.Sex.MALE);
        DonorRequest donorRequest1 = new DonorRequest(doctor, patient1, DonorType.EYE);
        DonorRequest donorRequest2 = new DonorRequest(doctor, patient1, DonorType.BLOOD, BloodType.A_NEGATIVE);
        doctor.prescribeMedicalOrder(patient1, donorRequest1);
        doctor.prescribeMedicalOrder(patient1, donorRequest2);

        Patient patient2 = new Patient("patient2", User.Sex.MALE);
        DonorRequest donorRequest3 = new DonorRequest(doctor, patient2, DonorType.BLOOD, BloodType.O_NEGATIVE);
        doctor.prescribeMedicalOrder(patient2, donorRequest3);

        Donor donor1 = new Donor("donor1", User.Sex.MALE, DonorType.BLOOD, BloodType.A_NEGATIVE, true);
        Donor donor2 = new Donor("donor2", User.Sex.MALE, DonorType.EYE, true);
        Donor donor3 = new Donor("donor3", User.Sex.FEMALE, DonorType.BLOOD, BloodType.O_NEGATIVE, true);

        HospitalManagementSystem.matchPatientsToDonors();

        Assertions.assertEquals(HospitalManagementSystem.getDonorMatches().get(donor1), donorRequest2);
        Assertions.assertEquals(HospitalManagementSystem.getDonorMatches().get(donor2), donorRequest1);
        Assertions.assertEquals(HospitalManagementSystem.getDonorMatches().get(donor3), donorRequest3);
    }
}
