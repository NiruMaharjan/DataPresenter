/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.main;

import com.leapfrog.dataPresenter.Entity.Courses;
import com.leapfrog.dataPresenterDAO.CourseDAOImpl;
import com.leapfrog.dataPresenterDAO.CoursesDAO;
import com.leapfrog.dataPresenterDAO.StudentDAO;
import com.leapfrog.dataPresenterDAO.StudentDAOImpl;
import com.leapfrog.dataPresenterDAO.StudentPaymentDAO;
import com.leapfrog.dataPresenterDAO.StudentPaymentDAOImpl;
import com.leapfrog.utility.DataLoader;
import com.leapfrog.utility.FileHelper;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class DataPresenter2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String coursefileName = "c:/Users/Lenovo/Desktop/N/Courses.txt";
        String studentfileName = "c:/Users/Lenovo/Desktop/N/Student.txt";
        String paymentfileName = "c:/Users/Lenovo/Desktop/N/StudentPayment.txt";
        CoursesDAO courseDAO = new CourseDAOImpl();
        StudentDAO studentDAO = new StudentDAOImpl();
        StudentPaymentDAO studentPaymentDAO = new StudentPaymentDAOImpl();
        DataLoader loader = new DataLoader();
        try {

            loader.setCourseDAO(courseDAO);
            loader.loadCourses(coursefileName);
               // loader.showCourses();

            loader.setStudentDAO(studentDAO);
            loader.loadStudents(studentfileName);
               // loader.showStudents();

            loader.setStudentPaymentDAO(studentPaymentDAO);
            loader.loadPayments(paymentfileName);
            loader.showPayments();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
