package tn.iit.medicalFile.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iit.medicalFile.models.Treatment;

import java.util.List;

@Repository
public interface TreatmentDao extends JpaRepository<Treatment, Long> {
    List<Treatment> findAllByFolder_Id(long folder_id);
}
