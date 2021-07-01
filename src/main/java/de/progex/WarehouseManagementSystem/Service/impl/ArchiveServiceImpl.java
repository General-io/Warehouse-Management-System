package de.progex.WarehouseManagementSystem.Service.impl;


import de.progex.WarehouseManagementSystem.Service.ArchiveService;
import de.progex.WarehouseManagementSystem.repository.ArchiveRepository;
import de.progex.WarehouseManagementSystem.repository.WarehouseRepository;
import de.progex.WarehouseManagementSystem.tables.Archive;
import de.progex.WarehouseManagementSystem.tables.Warehouse;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Qualifier("ArchiveService")
public class ArchiveServiceImpl implements ArchiveService {


    Logger LOGGER = LoggerFactory.getLogger(ArchiveServiceImpl.class);



    ArchiveRepository archiveRepository;

    @Autowired
    public ArchiveServiceImpl(ArchiveRepository archiveRepository) {
        this.archiveRepository = archiveRepository;
    }

    @Override
    public Archive getItemByIdFromArchive(long id) throws NotFoundException {
        Archive archive = archiveRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Item with id " + id + " does not exists"

                ));
        return archive;
    }

    @Override
    public Archive getItemBySkuCodeFromArchive(long skuCode) {
        Archive archive = archiveRepository.findItemBySkuCode(skuCode);
        if (archive  == null) {
            LOGGER.error("Item Not Found By skuCode: " + skuCode);
        }else return archive;
        return null;
    }

    @Override
    public List<Archive> getAllItemFromArchive() {
        return archiveRepository.findAll();
    }

    @Override
    public void addItemToArchive(Archive archive) {
        archiveRepository.save(archive);
    }



    //muss noch gemacht werden
    @Override
    @Transactional
    // durch transactional wird das Employeeobject das hier benutzt wird auch direkt in der datenbank veränderrt
    public void updateItemBySku(long id, Archive item) throws NotFoundException {
        Archive archive = archiveRepository.findItemBySkuCode(item.getSkuCode());
        if (archive != null){
            int value = item.getQuantity() + archive.getQuantity();
            archive.setQuantity(value);
        }

    }
}
