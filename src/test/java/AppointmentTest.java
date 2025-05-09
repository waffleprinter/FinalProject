import org.example.Appointment;
import org.example.Doctor;
import org.example.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class AppointmentTest {

    @Test
    public void cancelTest_normalCase() {
        Patient patient = null;
        Doctor doctor = null;
        LocalDateTime date = LocalDateTime.of(2025, 12, 16, 23, 56);

        Appointment appointment = new Appointment(patient, doctor, date);

        Assertions.assertTrue(appointment.cancel());
        Assertions.assertEquals(Appointment.Status.CANCELED, appointment.getStatus());
    }

    @Test
    public void cancelTest_cancelIsImpossibleCase() {
        Patient patient = null;
        Doctor doctor = null;
        LocalDateTime date = LocalDateTime.of(2025, 12, 16, 23, 56);

        Appointment appointment = new Appointment(patient, doctor, date);
        appointment.setStatus(Appointment.Status.COMPLETED);

        Assertions.assertFalse(appointment.cancel());
        Assertions.assertEquals(Appointment.Status.COMPLETED, appointment.getStatus());
    }

    @Test
    public void confirmTest_normalCase() {
        Patient patient = null;
        Doctor doctor = null;
        LocalDateTime date = LocalDateTime.of(2025, 12, 16, 23, 56);

        Appointment appointment = new Appointment(patient, doctor, date);

        Assertions.assertTrue(appointment.confirm());
        Assertions.assertEquals(Appointment.Status.CONFIRMED, appointment.getStatus());
    }

    @Test
    public void confirmTest_confirmIsImpossibleCase() {
        Patient patient = null;
        Doctor doctor = null;
        LocalDateTime date = LocalDateTime.of(2025, 12, 16, 23, 56);

        Appointment appointment = new Appointment(patient, doctor, date);
        appointment.setStatus(Appointment.Status.CONFIRMED);

        Assertions.assertFalse(appointment.confirm());
        Assertions.assertEquals(Appointment.Status.CONFIRMED, appointment.getStatus());
    }
}
