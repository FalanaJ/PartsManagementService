package pl.FalanaJ.PartsManagementService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import pl.FalanaJ.PartsManagementService.controller.PartController;
import pl.FalanaJ.PartsManagementService.model.Part;
import pl.FalanaJ.PartsManagementService.model.PartId;
import pl.FalanaJ.PartsManagementService.service.PartService;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//TODO Do poprawy
@ExtendWith(SpringExtension.class)
@WebMvcTest(PartController.class)
public class PartControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PartService partService;

    @InjectMocks
    private PartController partController;


    @Test
    public void testGetAllParts() throws Exception {
        // Given
        List<Part> parts = List.of(
                new Part(new PartId("MAT-000", "SN-00000", "SUP-000"), 100),
                new Part(new PartId("MAT-001", "SN-00001", "SUP-001"), 200));
        when(partService.getAllParts()).thenReturn(parts);

        // When and Then
        //mockMvc.perform(get("/api/v2/parts"));
                //.andExpect(status().isOk())
                //.andExpect(jsonPath("$[0].quantity").value(100))
                //.andExpect(jsonPath("$[1].quantity").value(200));
    }

}
