package tn.iit.medicalFile.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iit.medicalFile.models.Patient;

@Repository
public interface PatientDao extends JpaRepository<Patient, Long> {
}
