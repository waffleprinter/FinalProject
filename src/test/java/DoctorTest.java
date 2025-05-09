import org.example.Doctor;
import org.example.Patient;
import org.example.Prescription;
import org.example.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class DoctorTest {

    @Test
    public void prescribeMedicationTest_normalCase() {
        Patient patient = new Patient("Nelson", User.Sex.MALE);
        Doctor doctor = new Doctor("Hippocrates", User.Sex.MALE);

        Prescription prescription = new Prescription(doctor, patient,
                "Advil", "1 tablet", "1 per 4 hours", LocalDateTime.now());

        doctor.prescribeMedication(patient, prescription);

        Assertions.assertEquals(patient.getPrescriptions().getLast(), prescription);
    }

    @Test
    public void prescribeMedicationTest_invalidArgumentsCase() {
        Patient patient = new Patient("Nelson", User.Sex.MALE);
        Doctor doctor = new Doctor("Hippocrates", User.Sex.MALE);

        Prescription prescription = new Prescription(doctor, patient,
                "Advil", "1 tablet", "1 per 4 hours", LocalDateTime.now());

        Assertions.assertThrows(NullPointerException.class,
                () -> doctor.prescribeMedication(null, prescription));

        Assertions.assertThrows(NullPointerException.class,
                () -> doctor.prescribeMedication(patient, null));
    }
}
