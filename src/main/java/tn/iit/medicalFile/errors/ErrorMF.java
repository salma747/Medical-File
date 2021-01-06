package tn.iit.medicalFile.errors;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMF {
    private String message;
    private String conflict;

}
