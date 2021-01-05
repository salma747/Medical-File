package tn.iit.medicalFile.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import tn.iit.medicalFile.models.File;
import tn.iit.medicalFile.dto.FileDto;
import tn.iit.medicalFile.mappers.PatientMapper;
import tn.iit.medicalFile.services.FileService;
import tn.iit.medicalFile.services.PatientService;

import javax.validation.Valid;
import java.util.Collection;

@CrossOrigin("*")
@RequestMapping(value = "/api/files")
@RestController()
public class FileController {

    private final Logger logger= LoggerFactory.getLogger (FileController.class);
    private final FileService fileService;
    private final PatientService patientService;

    public FileController(FileService fileService, PatientService patientService) {
        this.fileService = fileService;
        this.patientService = patientService;
    }

    @GetMapping("{id}")
    public FileDto findOne(@PathVariable("id") long id) {
        this.logger.debug ("Getting file {}",id);
        return this.fileService.findOne (id);
    }

    @GetMapping
    public Collection<FileDto> findAll(){
        this.logger.debug ("Getting all files");
        return this.fileService.findAll ();
    }

    @PostMapping
    public FileDto add(@Valid @RequestBody FileDto fileDto){
        this.logger.debug ("Adding new file {}",fileDto);
        File file = new File (PatientMapper.patientDtoToPatient (this.patientService.findOne (fileDto.getPatientId ())));
        return this.fileService.save (fileDto);
    }

    @PutMapping
    public FileDto update(@RequestBody FileDto fileDto){
        this.logger.debug ("Updating file {} with {}",fileDto.getId (),fileDto);
        return this.fileService.save (fileDto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id){
        this.logger.debug ("Deleting file {}",id);
        this.fileService.deleteById (id);
    }
}
