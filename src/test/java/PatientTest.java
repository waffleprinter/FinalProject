import org.example.Appointment;
import org.example.Doctor;
import org.example.Patient;
import org.example.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class PatientTest {

    @Test
    public void scheduleAppointmentTest_normalCase() {
        Patient patient = new Patient("Nelson", User.Sex.MALE);
        Doctor doctor = new Doctor("Hippocrates", User.Sex.MALE);
        LocalDateTime time  = LocalDateTime.of(2025, 12, 16, 23, 56);

        patient.scheduleAppointment(doctor, time);

        Assertions.assertEquals(patient.getAppointments(), doctor.getAppointments());
    }

    @Test
    public void scheduleAppointmentTest_invalidArgumentsCase() {
        Patient patient = new Patient("Nelson", User.Sex.MALE);
        Doctor doctor = new Doctor("Hippocrates", User.Sex.MALE);
        LocalDateTime time  = LocalDateTime.of(460, 1, 1, 1, 1);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> patient.scheduleAppointment(doctor, time));

        Assertions.assertThrows(NullPointerException.class,
                () -> patient.scheduleAppointment(null, time));
    }
}
