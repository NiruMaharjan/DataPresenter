/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.dataPresenterDAO;

import com.leapfrog.dataPresenter.Entity.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class StudentDAOImpl implements StudentDAO {

    List<Student> studentList = new ArrayList<>();

    public boolean insert(Student student) {
        return studentList.add(student);

    }

    @Override
    public List<Student> getAll() {
        return studentList;
    }

    @Override
    public Student getById(int id) {
        for (Student s : studentList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;

    }

    @Override
    public String check(String s) {
        return s;
    }

}
