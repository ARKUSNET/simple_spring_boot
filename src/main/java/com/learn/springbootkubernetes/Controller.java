package com.learn.springbootkubernetes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private StudentRepository studentRepo;

    @RequestMapping("/")
    public String index() {
        return "Hello Spring-Boot app successfully deployed and running on Minishift";
    }

    @GetMapping("/students")
    public String listAll(Model model) {
        List<Student> listStudents = studentRepo.findAll();
        model.addAttribute("listStudents", listStudents);
        StringBuilder student = new StringBuilder();
        for (Student std : listStudents) {
            student.append("ИМЯ - ").append(std.getName()).append(" ").append("EMAIL - ").append(std.getEmail());
        }
        return student.toString();
    }
}
