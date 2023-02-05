/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springboot.studentmanagementsystem.controller;

import com.springboot.studentmanagementsystem.entity.Student;
import com.springboot.studentmanagementsystem.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/students")
public class StudentController {
    private final IStudentService studentService;
    
    @GetMapping
    public String listStudents(Model model)
    {
        model.addAttribute("students", studentService.getAllStudents());
        
        return "students";
    }
    
    @GetMapping("/new")
    public String createStudentForm(Model model)
    {
        Student student = new Student();
        model.addAttribute("student", student);
        
        return "create_student_form";
    }
    
    @PostMapping
    public String saveStudent(@ModelAttribute("student") Student student)
    {
        studentService.saveStudent(student);
        
        return "redirect:/api/v1/students";
    }
    
    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model)
    {
        model.addAttribute("student", studentService.findById(id));
        
        return "edit_student_form";
    }
    
    @PostMapping("/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute Student student)
    {
        studentService.updateStudent(student, id);
        
        return "redirect:/api/v1/students";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id)
    {
        studentService.deleteStudent(id);
        
        return "redirect:/api/v1/students";
    }
}
