package com.example.demogit1.controller;

import com.example.demogit1.entity.Teacher;
import com.example.demogit1.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @GetMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView=new ModelAndView("teacherList");
        modelAndView.addObject("listTeacher",teacherService.findAll());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@RequestParam("name")String name,
                       @RequestParam("subject")String sub,
                       @RequestParam("age")int age){
        Teacher teacher=new Teacher();
        teacher.setName(name);
        teacher.setSubject(sub);
        teacher.setAge(age);
        teacherService.save(teacher);
        ModelAndView modelAndView=new ModelAndView("teacherList");
        modelAndView.addObject("listTeacher",teacherService.findAll());
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id")int id){
        teacherService.delete(id);
        ModelAndView modelAndView=new ModelAndView("teacherList");
        modelAndView.addObject("listTeacher",teacherService.findAll());
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")int id){
        ModelAndView modelAndView=new ModelAndView("updateTeacher");
        modelAndView.addObject("editTeacher",teacherService.findById(id));
        return modelAndView;
    }
    @PostMapping("/update")
    public ModelAndView upDate(@RequestParam("id")int id,
                               @RequestParam("name")String name,
                               @RequestParam("subject")String sub,
                               @RequestParam("age")int age){
        Teacher teacher=new Teacher(id,name,sub,age,true);
        teacherService.update(teacher);
        ModelAndView modelAndView=new ModelAndView("teacherList");
        modelAndView.addObject("listTeacher",teacherService.findAll());
        return modelAndView;
    }
}
