package tn.iit.medicalFile.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import tn.iit.medicalFile.dto.TreatmentDto;
import tn.iit.medicalFile.services.TreatmentService;

import javax.validation.Valid;
import java.util.Collection;

@CrossOrigin("*")
@RequestMapping(value = "/api/treatments")
@RestController()
public class TreatmentController {

    private final TreatmentService treatmentService;
    private final Logger logger = LoggerFactory.getLogger (TreatmentController.class);

    public TreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping("{id}")
    public TreatmentDto findOne(@PathVariable("id") long id) {
        this.logger.debug ("Getting treatment {}", id);
        return this.treatmentService.findOne (id);

    }

    @GetMapping
    public Collection<TreatmentDto> findAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "2") int pageSize
    ) {
        this.logger.debug ("Getting all treatments");
        return this.treatmentService.findAll (PageRequest.of (pageNo,pageSize));
    }

    @PostMapping
    public TreatmentDto add(@Valid @RequestBody TreatmentDto treatmentDto) {
        this.logger.debug ("Adding new treatment {}", treatmentDto);
        return this.treatmentService.save (treatmentDto);
    }

    @PutMapping
    public TreatmentDto update(@Valid @RequestBody TreatmentDto treatmentDto) {
        this.logger.debug ("Updating treatment {} with {}", treatmentDto.getId (), treatmentDto);
        return this.treatmentService.save (treatmentDto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id) {
        this.logger.debug ("Deleting treatment {}", id);
        this.treatmentService.deleteById (id);
    }
}
