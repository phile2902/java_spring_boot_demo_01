/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.springboot.studentmanagementsystem.service;

import com.springboot.studentmanagementsystem.entity.Student;
import java.util.List;

public interface IStudentService {
    public List<Student> getAllStudents();
    public Student saveStudent(Student student);
    public Student updateStudent(Student student, Long id);
    public void deleteStudent(Long id);
    public Student findById(Long id);
}
