package pl.FalanaJ.PartsManagementService.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode
@Data
@Entity
@Table(name = "parts")
public class Part {

    @EmbeddedId
    private PartId Id;

    private int quantity;
}
