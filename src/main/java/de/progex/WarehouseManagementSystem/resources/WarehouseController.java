package de.progex.WarehouseManagementSystem.resources;

import de.progex.WarehouseManagementSystem.Service.impl.ArchiveServiceImpl;
import de.progex.WarehouseManagementSystem.Service.impl.EmployeeServiceImpl;
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
@RequestMapping("item")
public class WarehouseController {

    WarehouseServiceImpl warehouseService;
    ArchiveServiceImpl archiveService;

    @Autowired
    public WarehouseController(WarehouseServiceImpl warehouseService, ArchiveServiceImpl archiveService) {
        this.warehouseService = warehouseService;
        this.archiveService = archiveService;
    }



    @GetMapping("all")
    public ResponseEntity<List> getAllItem(){
        List<Warehouse> allItems = new ArrayList<>();
        allItems = warehouseService.getAllItem();
        return new ResponseEntity<>(allItems, HttpStatus.ACCEPTED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Warehouse> getItem(@PathVariable int id) throws NotFoundException {
        Warehouse item = warehouseService.getItemById(id);
        return new ResponseEntity<>(item, HttpStatus.ACCEPTED);
    }

    @GetMapping("byEmplId/{skuCode}")
    public ResponseEntity<Warehouse> getItemBySkuCode(@PathVariable int skuCode) throws NotFoundException {
        Warehouse item = warehouseService.getItemBySkuCode(skuCode);
        return new ResponseEntity<>(item, HttpStatus.ACCEPTED);
    }


    @PostMapping("add")
    public HttpStatus addItem(@RequestBody Warehouse item){
        warehouseService.addItem(item);
        return HttpStatus.ACCEPTED;
    }

    @PutMapping("put/{id}")
    public HttpStatus updateItem(@PathVariable int id,
                                     @RequestBody Warehouse item) throws NotFoundException {  // put/1&firstname=beispiel
        warehouseService.updateItem(id, item);
        return HttpStatus.ACCEPTED;
    }

    @PutMapping("changeQuantity/{id}/{quantity}")
    public HttpStatus changeQuantity(@PathVariable("id") int id,
                                     @PathVariable("quantity") int quantity) throws NotFoundException {
        Warehouse item = warehouseService.getItemById(id);

        if (item.getQuantity() > quantity){
            if (archiveService.getItemBySkuCodeFromArchive(item.getSkuCode()) == null){
                Archive archive = new Archive(item.getSkuCode(), item.getBrand(), item.getModel(), item.getProductCondition(), item.getCategory(), item.getQuantity());
                int value = item.getQuantity() - quantity;
                archive.setQuantity(value);
                archiveService.addItemToArchive(archive);
            }else{
                Archive archive = new Archive(item.getSkuCode(), item.getBrand(), item.getModel(), item.getProductCondition(), item.getCategory(), item.getQuantity());
                int value = item.getQuantity() - quantity;
                archive.setQuantity(value);
                archiveService.updateItemBySku(item.getSkuCode(), archive);
            }
        }

        warehouseService.changeQuantity(id, quantity);
        return HttpStatus.ACCEPTED;
    }


    @DeleteMapping("delete/{id}")
    public HttpStatus deleteItem(@PathVariable int id) throws NotFoundException {
        Warehouse item = warehouseService.getItemById(id);
        Archive temp = archiveService.getItemBySkuCodeFromArchive(item.getSkuCode());
        Archive archive = new Archive(item.getSkuCode(), item.getBrand(), item.getModel(), item.getProductCondition(), item.getCategory(), item.getQuantity());
        if(temp == null){
            archiveService.addItemToArchive(archive);
        }else if(temp.getModel().equals(item.getModel())){
            archiveService.updateItemBySku(item.getSkuCode(), archive);
        }else {
            archiveService.addItemToArchive(archive);
        }
        warehouseService.deleteItemById(id);
        return HttpStatus.ACCEPTED;
    }
}
