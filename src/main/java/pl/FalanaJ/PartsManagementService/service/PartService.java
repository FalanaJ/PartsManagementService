package pl.FalanaJ.PartsManagementService.service;

import org.springframework.stereotype.Service;
import pl.FalanaJ.PartsManagementService.model.Part;
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
}
