package tn.iit.medicalFile.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.iit.medicalFile.dao.TreatmentDao;
import tn.iit.medicalFile.dto.MedicationDto;
import tn.iit.medicalFile.dto.TreatmentDto;
import tn.iit.medicalFile.mappers.TreatmentMapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class TreatmentService {
    public Logger logger = LoggerFactory.getLogger (TreatmentService.class);
    private final TreatmentDao treatmentDao;
    private final StoreManagementClientService storeManagementClientService;

    public TreatmentService(TreatmentDao treatmentDao, StoreManagementClientService storeManagementClientService) {
        this.treatmentDao = treatmentDao;
        this.storeManagementClientService = storeManagementClientService;
    }

    public TreatmentDto save(TreatmentDto treatmentDto) {
        this.treatmentDao.saveAndFlush (TreatmentMapper.treatmentDtoToTreatment (treatmentDto));
        return treatmentDto;
    }

    public void deleteById(Long id) {
        this.treatmentDao.deleteById (id);
    }
    @Transactional(readOnly = true)
    public TreatmentDto findOne(Long id) {
        TreatmentDto treatmentDto= TreatmentMapper.treatmentToTreatmentDto (this.treatmentDao.getOne (id));
        MedicationDto medicationDto = this.storeManagementClientService.getMedicationById (treatmentDto.getMedicationId());
        treatmentDto.setMedicationName(medicationDto.getName ());
        treatmentDto.setMedicationPosology(medicationDto.getPosology ());
        treatmentDto.setMedicationPrice(medicationDto.getPrice ());
        return treatmentDto;
    }
    @Transactional(readOnly = true)
    public Collection<TreatmentDto> findAll(Pageable pageable) {
        Collection<TreatmentDto> treatmentDtos = TreatmentMapper.treatmentsToTreatmentDtos (this.treatmentDao.findAll (pageable).getContent ());
        treatmentDtos.forEach (treatmentDto -> {
            MedicationDto medicationDto = this.storeManagementClientService.getMedicationById (treatmentDto.getMedicationId());
            treatmentDto.setMedicationName(medicationDto.getName ());
            treatmentDto.setMedicationPosology(medicationDto.getPosology ());
            treatmentDto.setMedicationPrice(medicationDto.getPrice ());
        });
        return treatmentDtos;
    }
    @Transactional(readOnly = true)
    public Collection<TreatmentDto> findAllByDossierId(Long dossierId){
        this.logger.debug ("Getting All Treatments By Dossier id {}",dossierId);
        Collection<TreatmentDto> treatmentDtos = TreatmentMapper.treatmentsToTreatmentDtos (this.treatmentDao.findAllByFolder_Id (dossierId));
        List<Long> ids = treatmentDtos.stream ().map (TreatmentDto::getMedicationId).collect(Collectors.toList());
        List<MedicationDto> medications=this.storeManagementClientService.getMedicationsByIds (ids);
        treatmentDtos.forEach (treatmentDto -> {
            MedicationDto medicationDto = medications.stream ()
                    .filter (medicationDto1 -> medicationDto1.getId () == treatmentDto.getMedicationId())
                    .findFirst ()
                    .orElseThrow (() -> new RuntimeException ("NOT FOUND"));
            treatmentDto.setMedicationName(medicationDto.getName ());
            treatmentDto.setMedicationPosology(medicationDto.getPosology ());
            treatmentDto.setMedicationPrice(medicationDto.getPrice ());
        });
        return treatmentDtos;
    }
}
