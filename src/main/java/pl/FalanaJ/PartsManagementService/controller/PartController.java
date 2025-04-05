package pl.FalanaJ.PartsManagementService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.FalanaJ.PartsManagementService.model.Part;
import pl.FalanaJ.PartsManagementService.model.PartId;
import pl.FalanaJ.PartsManagementService.service.PartService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/parts")
public class PartController {
    private final PartService partService;

    public PartController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping
    public List<Part> getAllParts() {
        return partService.getAllParts();
    }

    @PostMapping
    public ResponseEntity<Part> addPart(@RequestBody Part part) {
        Part addedPart = partService.addPart(part);
        return new ResponseEntity<>(addedPart, HttpStatus.CREATED);
    }

    @DeleteMapping("/{materialNumber}/{serialNumber}/{supplierNumber}")
    public void deletePartById(
            @PathVariable String materialNumber,
            @PathVariable String serialNumber,
            @PathVariable String supplierNumber){

        PartId partId = new PartId(materialNumber, serialNumber, supplierNumber);
        partService.deletePartById(partId);
    }

    @PutMapping("/{materialNumber}/{serialNumber}/{supplierNumber}")
    public void updateQuantity(
            @PathVariable String materialNumber,
            @PathVariable String serialNumber,
            @PathVariable String supplierNumber,
            @RequestParam int quantity){

        PartId partId = new PartId(materialNumber, serialNumber, supplierNumber);
        partService.updateQuantity(partId, quantity);
    }
}
