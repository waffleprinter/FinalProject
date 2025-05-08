# Classes

- User
  - Patient
  - Doctor

- MedicalOrder
  - Prescription
  - Lab

- Appointment
- MedicalRecord

# Implementation

- **User (abstract)**
  - int id
  - String name
  - Sex sex

- Patient extends User
  - List\<Appointment\> appointments
  - List\<Prescription\> prescriptions
  - List\<LabTest\> labTests
  - MedicalRecord medicalRecord

- Doctor extends User
  - List\<Appointment\> appointments

- **MedicalOrder (abstract)**
  - int id
  - Doctor issuedBy
  - Patient patient
  - LocalDateTime dateIssued
  - Status status

- Prescription extends MedicalOrder
  - String medication
  - String dosage
  - String frequency
  - int duration

- LabTest extends MedicalOrder
  - String testName
  - LocalDateTime collectionDate
  - LocalDateTime resultDate
  - String resultsSummary

- **Appointment**
  - int id
  - Patient patient
  - Doctor doctor
  - LocalDateTime date
  - Status status

- **MedicalRecord**
  - int id
  - Patient patient
  - List\<Prescription\> prescriptions
  - List\<LabTest\> labTests
  - List\<String\> allergies
  - List\<String\> pastIllnesses
  - List\<String\> surgeries
  - LocalDate lastUpdated