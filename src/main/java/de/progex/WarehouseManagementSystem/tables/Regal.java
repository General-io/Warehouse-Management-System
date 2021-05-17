package de.progex.WarehouseManagementSystem.tables;

import javax.persistence.*;


@Entity
@Table
public class Regal {

    @Id
    private Long id;

    @Column(name = "skuCode",
            nullable = false
    )
    private Long skuCode;

    @Column(name = "storageRackNumber",
            nullable = false
    )
    private int storageRackNumber;

    @Column(name = "levelStorageRack",
            nullable = false
    )
    private int levelStorageRack;

    @Column(name = "spaceStorageRack",
            nullable = false
    )
    private int spaceStorageRack;

    @OneToOne(mappedBy = "regal")
    private Warehouse warehouse;
}
