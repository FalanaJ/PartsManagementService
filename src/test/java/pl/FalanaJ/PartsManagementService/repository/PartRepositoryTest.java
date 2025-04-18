package pl.FalanaJ.PartsManagementService.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.FalanaJ.PartsManagementService.model.Part;
import pl.FalanaJ.PartsManagementService.model.PartId;
import pl.FalanaJ.PartsManagementService.repository.PartRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PartRepositoryTest {

    @Autowired
    private PartRepository partRepository;

    @Test
    public void testSavePart(){
        PartId partId = new PartId("MAT-000", "SN-00000", "SUP-00");
        Part part = new Part(partId, 100);

        partRepository.save(part);

        assertThat(partRepository.existsById(partId)).isTrue();
    }

    @Test
    public void testFindPart(){
        PartId partId = new PartId("MAT-000", "SN-00000", "SUP-00");
        Part part = new Part(partId, 100);

        partRepository.save(part);

        Part found = partRepository.findById(partId).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getQuantity()).isEqualTo(100);
    }
}
