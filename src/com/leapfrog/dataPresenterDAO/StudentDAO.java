/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.dataPresenterDAO;

import com.leapfrog.dataPresenter.Entity.Courses;
import com.leapfrog.dataPresenter.Entity.Student;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface StudentDAO {
     boolean insert(Student student);
    List<Student> getAll();
    Student getById(int id);
   String check(String s);
}
