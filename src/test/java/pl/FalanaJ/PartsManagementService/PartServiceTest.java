package pl.FalanaJ.PartsManagementService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.FalanaJ.PartsManagementService.model.Part;
import pl.FalanaJ.PartsManagementService.model.PartId;
import pl.FalanaJ.PartsManagementService.repository.PartRepository;
import pl.FalanaJ.PartsManagementService.service.PartService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PartServiceTest {
    @Mock
    private PartRepository partRepository;

    @InjectMocks
    private PartService partService;

    @Test
    public void testGetAllParts(){
        //Given
        Part p1 = new Part(new PartId("MAT-000", "SN-00000", "SUP-000"), 100);
        Part p2 = new Part(new PartId("MAT-001", "SN-00001", "SUP-001"), 200);
        List<Part> partsList = List.of(p1, p2);
        when(partRepository.findAll()).thenReturn(partsList);

        //When
        List<Part> result = partService.getAllParts();

        //Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(100, result.get(0).getQuantity());
        assertEquals(new PartId("MAT-001", "SN-00001", "SUP-001"), result.get(1).getId());
    }

    @Test
    public void testAddPart(){
        //Given
        Part p1 = new Part(new PartId("MAT-000", "SN-00000", "SUP-000"), 100);
        when(partRepository.save(p1)).thenReturn(p1);

        //When
        Part result = partService.addPart(p1);

        //Then
        assertNotNull(result);
        assertEquals(p1.getQuantity(), result.getQuantity());
        assertEquals(p1.getId(), result.getId());

        verify(partRepository, times(1)).save(p1);
    }

    @Test
    public void testDeletePartByIdWhenExists(){
        //Given
        PartId p1Id = new PartId("MAT-000", "SN-00000", "SUP-000");
        when(partRepository.existsById(p1Id)).thenReturn(true);

        //When
        partService.deletePartById(p1Id);

        //Then
        verify(partRepository, times(1)).deleteById(p1Id);
    }

    @Test
    public void testDeletePartByIdWhenDoesNotExists(){
        //Given
        PartId p1Id = new PartId("MAT-000", "SN-00000", "SUP-000");
        when(partRepository.existsById(p1Id)).thenReturn(false);

        // When and Then
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            partService.deletePartById(p1Id);
        });

        assertEquals("[ Part with id: " + p1Id + " not found ]", exception.getMessage());
    }

    @Test
    public void testUpdateQuantityWhenPartExists(){
        //Given
        PartId p1Id = new PartId("MAT-000", "SN-00000", "SUP-000");
        Part p1 = new Part(p1Id, 100);
        when(partRepository.findById(p1Id)).thenReturn(Optional.of(p1));

        //When
        partService.updateQuantity(p1Id, 45);

        //Then
        assertEquals(45, p1.getQuantity());
        verify(partRepository, times(1)).save(p1);
    }

    @Test
    public void testUpdateQuantityWhenPartDoesNotExists(){
        //Given
        PartId p1Id = new PartId("MAT-000", "SN-00000", "SUP-000");
        when(partRepository.findById(p1Id)).thenReturn(Optional.empty());

        //When and Then
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            partService.updateQuantity(p1Id, 45);
        });

        assertEquals("[ Part with id: " + p1Id + " not found ]", exception.getMessage());
    }
}
