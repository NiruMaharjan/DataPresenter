/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.dataPresenterDAO;

import com.leapfrog.dataPresenter.Entity.Courses;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class CourseDAOImpl implements CoursesDAO {

    List<Courses> courseList = new ArrayList<>();

    @Override
    public boolean insert(Courses course) {
        return courseList.add(course);
    }

    @Override
    public List<Courses> getAll() {
        return courseList;
    }

    @Override
    public Courses getById(int id) {
        for (Courses c : getAll()) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

}
