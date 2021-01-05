package tn.iit.medicalFile.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
public class Treatment implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @ManyToOne
    private File folder;
    @NotNull
    private long medicationId;
    @NotNull
    private long duration;

    public Treatment(File folder, long medicationId, long duration) {
        this.folder = folder;
        this.medicationId = medicationId;
        this.duration = duration;
    }
}
