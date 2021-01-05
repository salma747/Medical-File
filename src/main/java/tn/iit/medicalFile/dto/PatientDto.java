package tn.iit.medicalFile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    private long id;
    @NotNull
    @Size(min = 8,max = 8)
    private long cin;
    @NotNull
    @NotEmpty
    private String firstName;
    @NotNull
    @NotEmpty
    private String lastName;
    @NotNull
    private Date birthday;
    @NotNull
    @NotEmpty
    private String address;


    public PatientDto(long id)
    {
        this.id=id;
    }

}
