/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.dataPresenterDAO;

import com.leapfrog.dataPresenter.Entity.Courses;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface CoursesDAO {
    boolean insert(Courses course);
    List<Courses> getAll();
    Courses getById(int id);
    
    
    
    
}
