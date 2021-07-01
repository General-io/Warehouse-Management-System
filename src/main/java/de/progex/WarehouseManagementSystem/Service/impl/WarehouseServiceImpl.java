package de.progex.WarehouseManagementSystem.Service.impl;

import de.progex.WarehouseManagementSystem.Service.WarehouseService;
import de.progex.WarehouseManagementSystem.repository.WarehouseRepository;
import de.progex.WarehouseManagementSystem.tables.Warehouse;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Qualifier("WarehouseService")
public class WarehouseServiceImpl implements WarehouseService {

    Logger LOGGER = LoggerFactory.getLogger(WarehouseServiceImpl.class);


    WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public Warehouse getItemById(int id) throws NotFoundException {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Item with id " + id + " does not exists"

                ));
        return warehouse;
    }

    @Override
    public Warehouse getItemBySkuCode(long skuCode) throws NotFoundException {
        Warehouse warehouse = warehouseRepository.findItemBySkuCode(skuCode);
        if (warehouse  == null) {
            LOGGER.error("Item Not Found By skuCode: " + skuCode);
            throw new NotFoundException("");
        }else return warehouse;
    }

    @Override
    public List<Warehouse> getAllItem() {
        return warehouseRepository.findAll();
    }

    @Override
    public void addItem(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }



    //muss noch gemacht werden
    @Override
    @Transactional
    // durch transactional wird das Employeeobject das hier benutzt wird auch direkt in der datenbank veränderrt
    public void updateItem(int id, Warehouse item) throws NotFoundException {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Employee with id " + id + " does not exists"
                ));
        warehouse = item;
    }


    //muss noch gemacht werden
    @Override
    @Transactional
    // durch transactional wird das Employeeobject das hier benutzt wird auch direkt in der datenbank veränderrt
    public void changeQuantity(int id, int quantity) throws NotFoundException {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Employee with id " + id + " does not exists"
                ));
        warehouse.setQuantity(quantity);
    }

    @Override
    public void deleteItemById(int id) {
        Warehouse item = warehouseRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Employee with id " + id + " does not exists"
                ));
        warehouseRepository.delete(item);
    }
}
