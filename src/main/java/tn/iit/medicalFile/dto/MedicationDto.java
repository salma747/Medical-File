package tn.iit.medicalFile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MedicationDto {
    @NotNull
    private long id;
    @NotNull
    @Size(min = 3)
    @NotEmpty
    private String name;
    @NotNull
    private float posology;
    @NotNull
    private float price;
}
