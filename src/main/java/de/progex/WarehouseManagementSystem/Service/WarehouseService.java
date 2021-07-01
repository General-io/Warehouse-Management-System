package de.progex.WarehouseManagementSystem.Service;

import de.progex.WarehouseManagementSystem.tables.Warehouse;
import javassist.NotFoundException;

import java.util.List;

public interface WarehouseService {

    public Warehouse getItemById(int id) throws NotFoundException;

    public Warehouse getItemBySkuCode(long skuCode) throws NotFoundException;

    public List<Warehouse> getAllItem();

    public void addItem(Warehouse warehouse);

    public void updateItem(int id, Warehouse item) throws NotFoundException;

    public void deleteItemById(int id);

    public void changeQuantity(int id, int quantity) throws NotFoundException;

}
