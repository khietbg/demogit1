package com.example.demogit1.service;

import com.example.demogit1.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    List<Teacher> listTeacher = new ArrayList<>();

    public List<Teacher> findAll() {
        return listTeacher;
    }
    public Teacher findById(int id) {
        for (Teacher t : listTeacher) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public Teacher save(Teacher teacher) {
        if (listTeacher.size() == 0) {
            teacher.setId(1);
            listTeacher.add(teacher);
            return teacher;
        }
        teacher.setId(listTeacher.get(listTeacher.size() - 1).getId() + 1);
        listTeacher.add(teacher);
        return teacher;
    }

    public Teacher update(Teacher teacher) {
        for (Teacher t : listTeacher) {
            if (t.getId() == teacher.getId()) {
                t.setName(teacher.getName());
                t.setAge(teacher.getAge());
                t.setSubject(teacher.getSubject());
                t.setStatus(teacher.isStatus());
                return t;
            }
        }
        return null;
    }
    public boolean delete(int id){
        for (int i = 0; i < listTeacher.size(); i++) {
            if (listTeacher.get(i).getId()==id){
                listTeacher.remove(i);
                return true;
            }
        }
        return false;
    }
    public List<Teacher> findByName(String name){
        List<Teacher> listSearch=new ArrayList<>();
        for (Teacher t: listTeacher) {
            if (t.getName().trim().toLowerCase().contains(name)){
            listSearch.add(t);}
        }
        return listSearch;
    }
}
