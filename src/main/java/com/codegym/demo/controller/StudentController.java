package com.codegym.demo.controller;

import com.codegym.demo.model.Student;
import com.codegym.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public String showStudent(Model model) {
        model.addAttribute("students", studentService.getStudents());
        return "showStudent";
    }

    @GetMapping("/editStudent")
    public String showEditStudent(@RequestParam int id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "editStudent";
    }

    @PostMapping("/editStudent")
    public String showEditStudent(@ModelAttribute Student student) {
        studentService.editStudents(student.getId(),student);
        return "redirect:/students";
    }

}
