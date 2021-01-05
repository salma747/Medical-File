package tn.iit.medicalFile.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentDto {

    @NotNull
    private long id;
    @NotNull
    private long folderId;
    private String medicationName;
    private float medicationPosology;
    private float medicationPrice;
    @NotNull
    private long medicationId;
}
