package de.progex.WarehouseManagementSystem.tables;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "archive")
public class Archive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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


/*    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "regal_id", referencedColumnName = "id")
    private Regal regal;*/

    public Archive(Long skuCode, String brand, String model, String productCondition, String category, int quantity) {
        this.skuCode = skuCode;
        this.brand = brand;
        this.model = model;
        this.productCondition = productCondition;
        this.category = category;
        this.quantity = quantity;
    }
}
