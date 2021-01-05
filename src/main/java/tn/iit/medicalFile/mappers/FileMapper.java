package tn.iit.medicalFile.mappers;

import tn.iit.medicalFile.dto.FileDto;
import tn.iit.medicalFile.models.File;
import tn.iit.medicalFile.dto.PatientDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileMapper {

    public static FileDto fileToFileDto(File file)
    {
        FileDto fileDto = new FileDto();
        fileDto.setId (file.getId ());
        fileDto.setPatientId (file.getPatient ().getId ());
        fileDto.setPatientFirstName (file.getPatient ().getFirstName ());
        fileDto.setPatientLastName (file.getPatient ().getLastName ());
        return fileDto;
    }

    public static File fileDtoToFile(FileDto fileDto)
    {
        File file = new File();
        file.setId (fileDto.getId ());
        file.setPatient (PatientMapper.patientDtoToPatient (new PatientDto (fileDto.getPatientId ())));
        return file;
    }

    public static Collection<FileDto> filesToFileDtos(Collection<File> categories)
    {
        List<FileDto> fileDtoList = new ArrayList<>();
        categories.forEach(file -> {
            fileDtoList.add (fileToFileDto (file));
        });
        return fileDtoList;
    }
}
