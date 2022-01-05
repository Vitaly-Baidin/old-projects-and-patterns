package models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int Salary;
    private int age;
}
