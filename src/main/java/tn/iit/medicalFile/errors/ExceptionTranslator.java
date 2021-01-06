package tn.iit.medicalFile.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionTranslator {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMF> processRessourceNotFound(ResourceNotFoundException exception){
        ResponseEntity.BodyBuilder builder = ResponseEntity.status (HttpStatus.NOT_FOUND);
        return builder.body (new ErrorMF ("NOT FOUND", exception.getMessage ()));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMF> processValidationError(MethodArgumentNotValidException exception){
        ResponseEntity.BodyBuilder builder = ResponseEntity.status (HttpStatus.BAD_REQUEST);
        return builder.body (new ErrorMF ("VALIDATION ERROR", exception.getMessage ()));
    }
}
