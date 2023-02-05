/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springboot.studentmanagementsystem.service.impl;

import com.springboot.studentmanagementsystem.entity.Student;
import com.springboot.studentmanagementsystem.exception.ResourceNotFoundException;
import com.springboot.studentmanagementsystem.repository.IStudentRepository;
import com.springboot.studentmanagementsystem.service.IStudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {
    
    private final IStudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student", "id", id)
        );
        
        studentRepository.delete(existingStudent);
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student", "id", id)
        );
        
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        
        return studentRepository.save(existingStudent);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }
    
}
