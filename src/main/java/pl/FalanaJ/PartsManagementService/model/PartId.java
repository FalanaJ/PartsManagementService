package pl.FalanaJ.PartsManagementService.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

//@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PartId implements Serializable {
    private String materialNumber;
    private String serialNumber;
    private String supplierNumber;

}
