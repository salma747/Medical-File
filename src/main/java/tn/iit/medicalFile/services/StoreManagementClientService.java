package tn.iit.medicalFile.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import tn.iit.medicalFile.dto.MedicationDto;
import tn.iit.medicalFile.utils.Links;

import java.util.List;

@Service
public class StoreManagementClientService {
    private Logger logger = LoggerFactory.getLogger (StoreManagementClientService.class);
    private final RestTemplate restTemplate;

    public StoreManagementClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<MedicationDto> getAllMedications(){
        logger.debug("Getting all medications");
        UriComponents uriComponents= UriComponentsBuilder.fromUriString (Links.MEDICATIONS).build ().encode ();
        return restTemplate.exchange (uriComponents.toUri (),
                HttpMethod.GET,
                new HttpEntity<> (null,new HttpHeaders ()),
                new ParameterizedTypeReference<List<MedicationDto>> (){}).getBody ();
    }

    public MedicationDto getMedicationById(Long id){
        logger.debug ("Getting Medication with id {}",id);
        UriComponents uriComponents= UriComponentsBuilder.fromUriString (Links.MEDICATIONS)
                .path ("/{id}")
                .build ()
                .expand (id)
                .encode ();
        return restTemplate.exchange (uriComponents.toUri (),
                HttpMethod.GET,
                new HttpEntity<> (null,new HttpHeaders ()),
                MedicationDto.class).getBody ();
    }

    public List<MedicationDto> getMedicationsByIds(List<Long> ids){
        this.logger.debug ("Getting medications with ids {}",ids);
        UriComponents uriComponents= UriComponentsBuilder.fromUriString (Links.MEDICATIONS+"/searches")
                .build ()
                .encode ();
        return restTemplate.exchange (uriComponents.toUri (),
                HttpMethod.POST,
                new HttpEntity<> (ids,new HttpHeaders ()),
                new ParameterizedTypeReference<List<MedicationDto>> (){}).getBody ();
    }
}
