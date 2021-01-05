package tn.iit.medicalFile.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FileDto {
    private long id;
    @NotNull
    private long patientId;
    private String patientFirstName;
    private String patientLastName;
    private Collection<TreatmentDto> treatments;
    //HETHA USELESSSSSSSSSSSSSSSSSSSSSSSSSSSSS
    public FileDto(Long id){
        this.id=id;
    }
}
