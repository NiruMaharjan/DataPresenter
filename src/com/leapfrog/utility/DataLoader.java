/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.utility;

import com.leapfrog.dataPresenter.Entity.Courses;
import com.leapfrog.dataPresenter.Entity.Student;
import com.leapfrog.dataPresenter.Entity.StudentPayment;
import com.leapfrog.dataPresenterDAO.CoursesDAO;
import com.leapfrog.dataPresenterDAO.StudentDAO;
import com.leapfrog.dataPresenterDAO.StudentPaymentDAO;
import com.leapfrog.dataPresenterDAO.StudentPaymentDAOImpl;
import java.io.IOException;

/**
 *
 * @author Lenovo
 */
public class DataLoader {

    private CoursesDAO courseDAO;
    private StudentDAO studentDAO;
    private StudentPaymentDAO studentPaymentDAO;

    public void setCourseDAO(CoursesDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void setStudentPaymentDAO(StudentPaymentDAO studentPaymentDAO) {
        this.studentPaymentDAO = studentPaymentDAO;
    }

    public void loadCourses(String coursefileName) throws IOException {

        for (String s : FileHelper.readLines(coursefileName)) {
            String[] tokens = s.split(",");
            Courses course = new Courses();
            course.setId(Integer.parseInt(tokens[0]));
            course.setName(tokens[1]);
            course.setFees(Integer.parseInt(tokens[2]));
            courseDAO.insert(course);

        }
    }

    public void showCourses() {
        for (Courses c : courseDAO.getAll()) {
            System.out.println(c);
        }
    }

    /*For half of the day i was worried about this.Because when i run the code
     it threw ArrayIndexOutOfBound exception 3.This expxeption was thrown because of the missing "," in the  Student.txt
     1,Niru,Maharjan,984327263
     2,Srisha Maharjan,98484822//notice the missing of comma here
     3,Mili Maharjan,98438222//missing , here.So this makes only
     3 tokens but we actually need 4 tokens.Hence when it tried to access 4th token which was not there,it threw ArrayIndexOutOfBoundException p.s// mistakes teach you many things
     */
    public void loadStudents(String studentfileName) throws IOException {
        for (String s : FileHelper.readLines(studentfileName)) {
            String[] tokens = s.split(",");
            Student student = new Student();
            student.setId(Integer.parseInt(tokens[0]));
            student.setFirstName(tokens[1]);
            student.setLastName(tokens[2]);
            student.setContact_no(tokens[3]);
            studentDAO.insert(student);
        }
    }

    public void showStudents() {
        for (Student s : studentDAO.getAll()) {
            System.out.println(s);
        }
    }

    public void loadPayments(String paymentfileName) throws IOException {
        for (String p : FileHelper.readLines(paymentfileName)) {
            String[] tokens = p.split(",");
            if (tokens.length > 2) {
               // System.out.println("aa");
                Student student = studentDAO.getById(Integer.parseInt(tokens[0]));

               // System.out.println(student.getId());
                if (student != null) {
                    Courses course = courseDAO.getById(Integer.parseInt(tokens[1]));
                    if (course != null) {
                        StudentPayment spp = new StudentPayment();
                        spp.setStudent(student);
                        spp.setCourse(course);
                        spp.setAmount(Integer.parseInt(tokens[2]));
                        studentPaymentDAO.insert(spp);

                    }
                }

            }
        }
    }

    public void showPayments() {
        //System.out.println("sssss");
     
        for (StudentPayment sp : studentPaymentDAO.getAll()) {
                   int remaining=sp.getCourse().getFees()-sp.getAmount();
                   double vat=(sp.getAmount()*Config.VAT_PERCENTAGE)/100;
            //System.out.println(sp.getStudent().getFirstName()+" "+sp.getStudent().getId() + " " + sp.getCourse().getId() + " " + sp.getAmount());
            String line=sp.getStudent().getFirstName()+" "+sp.getStudent().getLastName()+" "+sp.getCourse().getName()
                    +" "+sp.getCourse().getFees()+" "+sp.getAmount()+" "+remaining+" "+vat;
            System.out.println(line);

        }
    }

}
