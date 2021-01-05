package tn.iit.medicalFile.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.iit.medicalFile.dao.FileDao;
import tn.iit.medicalFile.dto.FileDto;
import tn.iit.medicalFile.mappers.FileMapper;

import java.util.Collection;

@Transactional
@Service
public class FileService {
    private final FileDao fileDao;
    private final TreatmentService treatmentService;

    @Autowired
    public FileService(FileDao fileDao, TreatmentService treatmentService) {
        this.fileDao = fileDao;
        this.treatmentService = treatmentService;
    }

    public FileDto save(FileDto fileDto) {
       this.fileDao.saveAndFlush (FileMapper.fileDtoToFile (fileDto));
       return fileDto;
    }

    public void deleteById(Long id) {
        this.fileDao.deleteById (id);
    }

    @Transactional(readOnly = true)
    public FileDto findOne(Long id) {

        FileDto fileDto= FileMapper.fileToFileDto (this.fileDao.getOne (id));
        fileDto.setTreatments (this.treatmentService.findAllByDossierId (id));
        return fileDto;
    }
    @Transactional(readOnly = true)
    public Collection<FileDto> findAll() {
        return FileMapper.filesToFileDtos (this.fileDao.findAll ());
    }
}
