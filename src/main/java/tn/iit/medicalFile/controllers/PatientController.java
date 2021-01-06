package tn.iit.medicalFile.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import tn.iit.medicalFile.dto.PatientDto;
import tn.iit.medicalFile.services.PatientService;

import javax.validation.Valid;
import java.util.Collection;

@CrossOrigin("*")
@RequestMapping(value = "/api/patients")
@RestController()
public class PatientController {

    private final PatientService patientService;
    private final Logger logger= LoggerFactory.getLogger (PatientController.class);

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("{id}")
    public PatientDto findOne(@PathVariable("id") long id) {
        this.logger.debug ("Getting patient {}",id);
        return this.patientService.findOne (id);
    }

    @GetMapping
    public Collection<PatientDto> findAll(){
        this.logger.debug ("Getting all patients");
        return this.patientService.findAll ();
    }

    @PostMapping
    public PatientDto add(@Valid @RequestBody PatientDto patientDto){
        this.logger.debug ("Adding new patient {}",patientDto);
        return this.patientService.save (patientDto);
    }

    @PutMapping
    public PatientDto update(@Valid @RequestBody PatientDto patientDto){
        this.logger.debug ("Updating patient {} with {}",patientDto.getId (),patientDto);
        return this.patientService.save (patientDto);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id){
        this.logger.debug ("Deleting patient {}",id);
        this.patientService.deleteById (id);
    }
}
