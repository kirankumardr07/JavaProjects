package org.example.controller;

import org.example.dao.StudentDao;
import org.example.dto.StudentDto;

import java.util.Scanner;

public class StudentController {
    public static void main(String[] args) {
        StudentDto dto=new StudentDto();
        StudentDao dao=new StudentDao();
        dto.setName("Cristiano Ronaldo");
        dto.setPlace("Portugal");
        dto.setRollno("CR7");
        dao.addStudent(dto);
        System.out.println("Data inserted Successfully");
    }
}












