package com.example.demogit1.service;

import com.example.demogit1.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    List<Student> listStudent = new ArrayList<>();

    public List<Student> findAll() {
        return listStudent;
    }

    public Student findById(int id) {
        for (Student t : listStudent) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public Student save(Student student) {
        if (listStudent.size() == 0) {
            student.setId(1);
            listStudent.add(student);
            return student;
        }
        student.setId(listStudent.get(listStudent.size() - 1).getId() + 1);
        listStudent.add(student);
        return student;
    }

    public Student update(Student student) {
        for (Student t : listStudent) {
            if (t.getId() == student.getId()) {
                t.setName(student.getName());
                t.setAge(student.getAge());
                t.setMail(student.getMail());
                t.setLop(student.getLop());
                t.setStatus(student.isStatus());
                return t;
            }
        }
        return null;
    }

    public boolean delete(int id) {
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getId() == id) {
                listStudent.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Student> findByName(String name) {
        List<Student> listSearch = new ArrayList<>();
        for (Student t : listStudent) {
            if (t.getName().trim().toLowerCase().contains(name)) {
                listSearch.add(t);
            }
        }
        return listSearch;
    }
}
