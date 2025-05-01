# Classes

- User
  - Patient
  - Doctor

- MedicalOrder
  - Prescription
  - Lab

- 

# Implementation

- **User (abstract)**
  - int id
  - String name
  - Sex sex

- Patient
  - TreeSet\<Prescription\> (otherwise use List\<Prescription\>)
  - 

- **MedicalOrder (abstract)**
  - Doctor issuedBy
  - Patient patient
  - LocalDateTime dateIssued
  - Status status

- Prescription
  - String medication
  - String dosage
  - String frequency
  - int duration

- LabTest
  - String testName
  - LocalDateTime collectionDate
  - LocalDateTime resultDate
  - String resultsSummary
