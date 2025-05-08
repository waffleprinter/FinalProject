# Classes

- User
  - Patient
  - Doctor

- MedicalOrder
  - Prescription
  - Lab

- Appointment

# Implementation

## User Hierarchy
- **User (abstract)**
  - int id
  - String name
  - Sex sex

- Patient extends User
  - List\<Appointment\> appointments
  - List\<Prescription\> prescriptions
  - List\<LabTest\> labTests
  - List\<DonorMatch\> donorMatches

- Doctor extends User
  - List\<Appointment\> appointments

## MedicalOrder Hierarchy
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

## Single Classes
  
- **Appointment**
  - int id
  - Patient patient
  - Doctor doctor
  - LocalDateTime date
  - AppointmentStatus status
  - 