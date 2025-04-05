package pl.FalanaJ.PartsManagementService.controller;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.FalanaJ.PartsManagementService.model.Part;
import pl.FalanaJ.PartsManagementService.model.PartId;
import pl.FalanaJ.PartsManagementService.service.PartService;

import java.util.List;

@RestController
@RequestMapping("/api/v2/parts")
public class PartController {
    private final PartService partService;
    Logger log = LoggerFactory.getLogger(PartController.class);

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

        log.info("New part was added: " + addedPart);
        return new ResponseEntity<>(addedPart, HttpStatus.CREATED);
    }

    @DeleteMapping("/{materialNumber}/{serialNumber}/{supplierNumber}")
    public void deletePartById(
            @PathVariable String materialNumber,
            @PathVariable String serialNumber,
            @PathVariable String supplierNumber){

        PartId partId = new PartId(materialNumber, serialNumber, supplierNumber);
        partService.deletePartById(partId);
        log.info("Part with id: " + partId + " was deleted.");
    }

    @PutMapping("/{materialNumber}/{serialNumber}/{supplierNumber}")
    public void updateQuantity(
            @PathVariable String materialNumber,
            @PathVariable String serialNumber,
            @PathVariable String supplierNumber,
            @RequestParam int quantity){

        PartId partId = new PartId(materialNumber, serialNumber, supplierNumber);
        partService.updateQuantity(partId, quantity);
        log.info("Ouantity of part with id: " + partId + " was changed.");
    }
}
