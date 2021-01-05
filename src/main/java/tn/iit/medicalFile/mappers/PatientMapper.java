package tn.iit.medicalFile.mappers;

import tn.iit.medicalFile.models.Patient;
import tn.iit.medicalFile.dto.PatientDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PatientMapper {
    public static PatientDto patientToPatientDto(Patient patient)
    {
        PatientDto patientDto = new PatientDto ();
        patientDto.setId (patient.getId ());
        patientDto.setCin (patient.getCin ());
        patientDto.setFirstName (patient.getFirstName ());
        patientDto.setLastName (patient.getLastName ());
        patientDto.setBirthday (patient.getBirthday ());
        patientDto.setAddress (patient.getAddress ());
        return patientDto;
    }

    public static Patient patientDtoToPatient(PatientDto patientDto)
    {
        Patient patient = new Patient ();
        patient.setId (patientDto.getId ());
        patient.setCin (patientDto.getCin ());
        patient.setFirstName (patientDto.getFirstName ());
        patient.setLastName (patientDto.getLastName ());
        patient.setBirthday (patientDto.getBirthday ());
        patient.setAddress (patientDto.getAddress ());
        return patient;
    }

    public static Collection<PatientDto> patientsToPatientDtos(Collection<Patient> patients)
    {
        List<PatientDto> patientDtoList = new ArrayList<>();
        patients.forEach(patient -> {
            patientDtoList.add (patientToPatientDto (patient));
        });
        return patientDtoList;
    }
}
