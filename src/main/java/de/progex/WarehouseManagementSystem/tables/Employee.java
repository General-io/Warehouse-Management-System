package de.progex.WarehouseManagementSystem.tables;

import de.progex.WarehouseManagementSystem.enumeration.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;


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

    @Transient  // wird in der datenbank nicht abgespeichert
    private int age;

    @Column( nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column( nullable = false)
    private int telephone;

    @Column( nullable = false)
    private String department;

    @Column( nullable = false)
    private String ort;

    @Column( nullable = false)
    private String street;

    @Column( nullable = false)
    private int streetNo;

    @Column( nullable = false)
    private String country;

    @Column(nullable = false)
    LocalDate birthday;





    public Employee(Long employeeId, String name, String lastName, int age, Gender gender, int telephone, String ort, String street, int streetNo, String country, LocalDate birthday) {
        this.employeeId = employeeId;
        this.firstname = name;
        this.lastName = lastName;
        this.age = getAge();
        this.gender = gender;
        this.telephone = telephone;
        this.ort = ort;
        this.street = street;
        this.streetNo = streetNo;
        this.country = country;
        this.birthday = birthday;
    }

    public int getAge() {
       return Period.between(birthday, LocalDate.now()).getYears();
    }
}
