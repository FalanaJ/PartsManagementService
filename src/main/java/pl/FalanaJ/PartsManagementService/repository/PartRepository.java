package pl.FalanaJ.PartsManagementService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.FalanaJ.PartsManagementService.model.Part;
import pl.FalanaJ.PartsManagementService.model.PartId;

@Repository
public interface PartRepository extends JpaRepository<Part, PartId> {}
