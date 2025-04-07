package pl.FalanaJ.PartsManagementService.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode
@Data
@Entity
public class Part {

    @EmbeddedId
    private PartId Id;

    private int quantity;
}
