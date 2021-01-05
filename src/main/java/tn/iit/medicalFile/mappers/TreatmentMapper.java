package tn.iit.medicalFile.mappers;

import tn.iit.medicalFile.models.Treatment;
import tn.iit.medicalFile.dto.FileDto;
import tn.iit.medicalFile.dto.TreatmentDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TreatmentMapper {

    public static TreatmentDto treatmentToTreatmentDto(Treatment treatment)
    {
        TreatmentDto treatmentDto = new TreatmentDto ();
        treatmentDto.setId (treatment.getId ());
        treatmentDto.setFolderId (treatment.getFolder ().getId ());
        treatmentDto.setMedicationId(treatment.getMedicationId ());
        return treatmentDto;
    }
    public static Treatment treatmentDtoToTreatment(TreatmentDto treatmentDto)
    {
        Treatment treatment = new Treatment ();
        treatment.setId (treatmentDto.getId ());
        treatment.setFolder (FileMapper.fileDtoToFile(new FileDto(treatmentDto.getFolderId ())));
        treatment.setMedicationId (treatmentDto.getMedicationId ());
        return treatment;
    }

    public static Collection<TreatmentDto> treatmentsToTreatmentDtos(Collection<Treatment> treatments)
    {
        List<TreatmentDto> treatmentDtoList = new ArrayList<>();
        treatments.forEach(treatment -> {
            treatmentDtoList.add (treatmentToTreatmentDto (treatment));
        });
        return treatmentDtoList;
    }
}
