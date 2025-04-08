package pl.FalanaJ.PartsManagementService;


import org.junit.jupiter.api.Test;
import pl.FalanaJ.PartsManagementService.model.Part;
import pl.FalanaJ.PartsManagementService.model.PartId;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PartTest {

    @Test
    public void testEqualsAndHashCode(){
        Part p1_1 = new Part(new PartId("MAT-000", "SN-00000", "SUP-000"), 100);
        Part p1_2 = new Part(new PartId("MAT-000", "SN-00000", "SUP-000"), 100);
        Part p2 = new Part(new PartId("MAT-001", "SN-00001", "SUP-001"), 120);

        assertEquals(p1_1, p1_2);
        assertEquals(p1_1.hashCode(), p1_2.hashCode());

        assertNotEquals(p1_1, p2);
        assertNotEquals(p1_2.hashCode(), p2.hashCode());
    }
}
