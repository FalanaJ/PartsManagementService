package pl.FalanaJ.PartsManagementService.service;

import org.springframework.stereotype.Service;
import pl.FalanaJ.PartsManagementService.model.Part;
import pl.FalanaJ.PartsManagementService.model.PartId;
import pl.FalanaJ.PartsManagementService.repository.PartRepository;

import java.util.List;

@Service
public class PartService {
    private final PartRepository partRepository;

    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    public List<Part> getAllParts() {
        return partRepository.findAll();
    }

    public Part addPart(Part part) {
        return partRepository.save(part);
    }

    public void deletePartById(PartId partId){
        if(partRepository.existsById(partId))
            partRepository.deleteById(partId);
        else
            throw new RuntimeException("[ Part with id: " + partId + " not found ]");
    }

    public void updateQuantity(PartId partId, int quantity) {
        Part part = partRepository.findById(partId)
                .orElseThrow(() -> new RuntimeException("[ Part with id " + partId + " not found ]"));

        part.setQuantity(quantity);
        partRepository.save(part);
    }
}
