package org.example.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class EmployeeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double salary;
    private String role;

    public EmployeeDto() {
        // Default constructor required by JPA
    }

    public EmployeeDto(String name, Double salary, String role) {
        this.name=name;
        this.salary=salary;
        this.role=role;
    }

    public EmployeeDto(int id, String name, Double salary, String role) {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString(){
        return "[ id:"+id+", Name:"+name+",Salary:"+salary+", Role:"+role+"]";
    }

}










