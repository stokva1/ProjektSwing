package com.example.projektswing.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "pilots")
public class Pilot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 4, max = 30, message = "Name must be between 4 and 30 characters.")
    @NotBlank(message = "Name cannot be empty.")
    private String name;


    @Min(value = 18, message = "Age must be at least 18 years old.")
    @Max(value = 65, message = "Age cannot be greater than 65 years old.")
    private int age;


    @Min(value = 30000, message = "Minimum salary for pilots is 30,000.")
    @Max(value = 300000, message = "Maximum salary for pilots is 300,000.")
    private int salary;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
