package de.progex.WarehouseManagementSystem.tables;

import javax.persistence.*;

@Entity
@Table(name = "archive")
public class Archive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
