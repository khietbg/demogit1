package com.example.demogit1.controller;

import com.example.demogit1.entity.Student;
import com.example.demogit1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("studentList");
        modelAndView.addObject("listStudent", studentService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView showCreateForm(@RequestParam("name") String name,
                                       @RequestParam("age") int age,
                                       @RequestParam("mail") String mail,
                                       @RequestParam("lop") String lop) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setMail(mail);
        student.setLop(lop);
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("studentList");
        modelAndView.addObject("listStudent", studentService.findAll());
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView upDate(@RequestParam("id") int id,
                               @RequestParam("name") String name,
                               @RequestParam("age") int age,
                               @RequestParam("mail") String mail,
                               @RequestParam("lop") String lop) {
        Student student = new Student(id, name, age, mail, lop, true);
        studentService.update(student);
        ModelAndView modelAndView = new ModelAndView("studentList");
        modelAndView.addObject("listStudent", studentService.findAll());
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")int id){
        ModelAndView modelAndView=new ModelAndView("updateStudent");
        modelAndView.addObject("editStudent",studentService.findById(id));
        return modelAndView;
    }
    @GetMapping ("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {
        studentService.delete(id);
        ModelAndView modelAndView = new ModelAndView("studentList");
        modelAndView.addObject("listStudent", studentService.findAll());
        return modelAndView;
    }
}
