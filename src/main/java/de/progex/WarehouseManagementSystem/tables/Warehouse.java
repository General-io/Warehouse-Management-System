package de.progex.WarehouseManagementSystem.tables;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@SequenceGenerator(name = "port_gen", sequenceName = "port_gen",  initialValue = 1000000)
@Entity
@Table(name = "warehouse",
        uniqueConstraints = {
                @UniqueConstraint(name = "warehouse_skuCode_unique", columnNames = "skuCode")
        }
)
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "port_gen")
    @Column(name = "id")
    private Integer id;

    @Column(name = "skuCode",
            nullable = false
    )
    private Long skuCode;

    @Column(name = "brand",
            nullable = false
    )
    private String brand;

    @Column(name = "model",
            nullable = false
    )
    private String model;

    @Column(name = "productCondition",
            nullable = false
    )
    private String productCondition;

    @Column(name = "category",
            nullable = false
    )
    private String category;

    @Column(name = "quantity",
            nullable = false
    )
    private int quantity;

    @Column(name = "storageRack",
            nullable = false
    )
    private int storageRack;

    @Column(name = "floorNumber",
            nullable = false
    )
    private int floorNumber;

    @Column(name = "placeNumber",
            nullable = false
    )
    private int placeNumber;

    public Warehouse(Long skuCode, String brand, String model, String productCondition, String category, int quantity, int storageRack, int floorNumber, int placeNumber) {
        this.skuCode = skuCode;
        this.brand = brand;
        this.model = model;
        this.productCondition = productCondition;
        this.category = category;
        this.quantity = quantity;
        this.storageRack = storageRack;
        this.floorNumber = floorNumber;
        this.placeNumber = placeNumber;
    }

}
