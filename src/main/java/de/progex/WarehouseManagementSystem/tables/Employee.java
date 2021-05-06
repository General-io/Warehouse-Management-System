package de.progex.WarehouseManagementSystem.tables;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "employee",
       uniqueConstraints = {
            @UniqueConstraint(name = "student_employeeId_unique", columnNames = "employeeId")
       }
)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",
            updatable = false
    )
    private Integer id;

    @Column( name = "employeeId",
             nullable = false
    )
    private Long employeeId;

    @Column( nullable = false)
    private String firstname;

    @Column( nullable = false)
    private String lastName;

    @Column( nullable = false)
    private int age;

    @Column( nullable = false)
    private String gender;

    @Column( nullable = false)
    private int telephone;

    @Column( nullable = false)
    private String ort;

    @Column( nullable = false)
    private String street;

    @Column( nullable = false)
    private int streetNo;

    @Column( nullable = false)
    private String country;


    public Employee(Long employeeId, String name, String lastName, int age, String gender, int telephone, String ort, String street, int streetNo, String country) {
        this.employeeId = employeeId;
        this.firstname = name;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.telephone = telephone;
        this.ort = ort;
        this.street = street;
        this.streetNo = streetNo;
        this.country = country;
    }
}
