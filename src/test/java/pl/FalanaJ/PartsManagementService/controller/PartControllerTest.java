package pl.FalanaJ.PartsManagementService.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.FalanaJ.PartsManagementService.controller.PartController;
import pl.FalanaJ.PartsManagementService.model.Part;
import pl.FalanaJ.PartsManagementService.model.PartId;
import pl.FalanaJ.PartsManagementService.service.PartService;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;

@WebMvcTest(PartController.class)
public class PartControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PartService partService;

    @Test
    void testGetAllParts() throws Exception {
        List<Part> parts = List.of(
                new Part(new PartId("MAT-000", "SN-00000", "SUP-000"), 100),
                new Part(new PartId("MAT-001", "SN-00001", "SUP-001"), 200)
        );

        Mockito.when(partService.getAllParts()).thenReturn(parts);

        mockMvc.perform(get("/api/v2/parts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(new PartId("MAT-000", "SN-00000", "SUP-000")))
                .andExpect(jsonPath("$[1].quantity").value(200));
    }

    @Test
    void testAddPart() throws Exception {
        Part part = new Part(new PartId("MAT-000", "SN-00000", "SUP-000"), 100);

        Mockito.when(partService.addPart(part)).thenReturn(part);

        mockMvc.perform(post("/api/v2/parts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(part)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.quantity").value(100));
    }

    @Test
    void testDeletePartByIdFound() throws Exception {
        String materialNumber = "MAT-000";
        String serialNumber = "SN-00000";
        String supplierNumber = "SUP-000";
        PartId partId = new PartId(materialNumber, serialNumber, supplierNumber);

        when(partService.isExists(partId)).thenReturn(true);

        mockMvc.perform(delete("/api/v2/parts/{materialNumber}/{serialNumber}/{supplierNumber}",
                        materialNumber, serialNumber, supplierNumber))
                .andExpect(status().isOk());

        verify(partService, times(1)).isExists(partId);
        verify(partService, times(1)).deletePartById(partId);
    }

    @Test
    void testDeletePartByIdDoesNotFound() throws Exception {
        String materialNumber = "MAT-000";
        String serialNumber = "SN-00000";
        String supplierNumber = "SUP-000";
        PartId partId = new PartId(materialNumber, serialNumber, supplierNumber);

        when(partService.isExists(partId)).thenReturn(false);

        mockMvc.perform(delete("/api/v2/parts/{materialNumber}/{serialNumber}/{supplierNumber}",
                        materialNumber, serialNumber, supplierNumber))
                .andExpect(status().isNotFound());

        verify(partService, times(1)).isExists(partId);
    }

    @Test
    void testUpdateQuantityFound() throws Exception {
        String materialNumber = "MAT-000";
        String serialNumber = "SN-00000";
        String supplierNumber = "SUP-000";
        int quantity = 10;
        PartId partId = new PartId(materialNumber, serialNumber, supplierNumber);

        when(partService.isExists(partId)).thenReturn(true);

        mockMvc.perform(put("/api/v2/parts/{materialNumber}/{serialNumber}/{supplierNumber}?quantity={quantity}",
                        materialNumber, serialNumber, supplierNumber, quantity))
                .andExpect(status().isOk());

        verify(partService, times(1)).isExists(partId);
        verify(partService, times(1)).updateQuantity(partId, quantity);
    }

    @Test
    void testUpdateQuantityDoesNotFound() throws Exception {
        String materialNumber = "MAT-000";
        String serialNumber = "SN-00000";
        String supplierNumber = "SUP-000";
        int quantity = 10;
        PartId partId = new PartId(materialNumber, serialNumber, supplierNumber);

        when(partService.isExists(partId)).thenReturn(false);

        mockMvc.perform(put("/api/v2/parts/{materialNumber}/{serialNumber}/{supplierNumber}?quantity={quantity}",
                        materialNumber, serialNumber, supplierNumber, quantity))
                .andExpect(status().isNotFound());

        verify(partService, times(1)).isExists(partId);
    }


}
