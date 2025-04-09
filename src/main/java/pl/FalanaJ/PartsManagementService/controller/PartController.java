package pl.FalanaJ.PartsManagementService.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.FalanaJ.PartsManagementService.model.Part;
import pl.FalanaJ.PartsManagementService.model.PartId;
import pl.FalanaJ.PartsManagementService.service.PartService;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("/api/v2/parts")
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

        log.info("New part was added: " + addedPart);
        return new ResponseEntity<>(addedPart, HttpStatus.CREATED);
    }

    @DeleteMapping("/{materialNumber}/{serialNumber}/{supplierNumber}")
    public ResponseEntity<Part> deletePartById(
            @PathVariable String materialNumber,
            @PathVariable String serialNumber,
            @PathVariable String supplierNumber){

        PartId partId = new PartId(materialNumber, serialNumber, supplierNumber);
        if(partService.isExists(partId)){
            partService.deletePartById(partId);
            log.info("Part with id: " + partId + " was deleted.");
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            log.info("Part with id: " + partId + " was not found.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{materialNumber}/{serialNumber}/{supplierNumber}")
    public ResponseEntity<Part> updateQuantity(
            @PathVariable String materialNumber,
            @PathVariable String serialNumber,
            @PathVariable String supplierNumber,
            @RequestParam int quantity){

        PartId partId = new PartId(materialNumber, serialNumber, supplierNumber);
        if(partService.isExists(partId)){
            partService.updateQuantity(partId, quantity);
            log.info("Quantity of part with id: " + partId + " was changed.");
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            log.info("Part with id: " + partId + " was not found.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
