package de.progex.WarehouseManagementSystem.resources;

import de.progex.WarehouseManagementSystem.Service.impl.ArchiveServiceImpl;
import de.progex.WarehouseManagementSystem.Service.impl.WarehouseServiceImpl;
import de.progex.WarehouseManagementSystem.tables.Archive;
import de.progex.WarehouseManagementSystem.tables.Warehouse;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(path = "/archive")
public class ArchiveController {

    ArchiveServiceImpl archiveService;

    @Autowired
    public ArchiveController(ArchiveServiceImpl archiveService) {
        this.archiveService = archiveService;
    }


    @GetMapping("all")
    public ResponseEntity<List> getAllItem(){
        List<Archive> allItems = new ArrayList<>();
        allItems = archiveService.getAllItemFromArchive();
        return new ResponseEntity<>(allItems, HttpStatus.ACCEPTED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Archive> getItem(@PathVariable int id) throws NotFoundException {
        Archive item = archiveService.getItemByIdFromArchive(id);
        return new ResponseEntity<>(item, HttpStatus.ACCEPTED);
    }

    @GetMapping("byEmplId/{skuCode}")
    public ResponseEntity<Archive> getItemBySkuCode(@PathVariable int skuCode) throws NotFoundException {
        Archive item = archiveService.getItemBySkuCodeFromArchive(skuCode);
        return new ResponseEntity<>(item, HttpStatus.ACCEPTED);
    }

}
