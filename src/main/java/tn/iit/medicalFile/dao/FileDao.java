package tn.iit.medicalFile.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iit.medicalFile.models.File;

@Repository
public interface FileDao extends JpaRepository<File, Long> {
}
