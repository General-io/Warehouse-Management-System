package de.progex.WarehouseManagementSystem.Service;

import de.progex.WarehouseManagementSystem.tables.Archive;
import de.progex.WarehouseManagementSystem.tables.Warehouse;
import javassist.NotFoundException;

import java.util.List;

public interface ArchiveService {

    public Archive getItemByIdFromArchive(long id) throws NotFoundException;

    public Archive getItemBySkuCodeFromArchive(long skuCode) throws NotFoundException;

    public List<Archive> getAllItemFromArchive();

    public void addItemToArchive(Archive warehouse);

    public void updateItemBySku(long id, Archive item) throws NotFoundException;

}
