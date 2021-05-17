package de.progex.WarehouseManagementSystem.tables;

import javax.persistence.*;

@Entity
@Table(name = "warehouse",
        uniqueConstraints = {
                @UniqueConstraint(name = "warehouse_skuCode_unique", columnNames = "skuCode")
        }
)
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "skuCode",
            nullable = false
    )
    private Long skuCode;

    @Column(name = "productName",
            nullable = false
    )
    private String productName;

    @Column(name = "quantity",
            nullable = false
    )
    private int quantity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "regal_id", referencedColumnName = "id")
    private Regal regal;
}
