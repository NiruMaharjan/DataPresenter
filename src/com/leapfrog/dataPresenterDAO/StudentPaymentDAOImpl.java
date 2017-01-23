/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.dataPresenterDAO;

import com.leapfrog.dataPresenter.Entity.StudentPayment;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class StudentPaymentDAOImpl implements StudentPaymentDAO{
    List<StudentPayment> paymentList=new ArrayList<>();
    
    @Override
    public boolean insert(StudentPayment sp) {
        return paymentList.add(sp);
    }

    @Override
    public List<StudentPayment> getAll() {
       return paymentList;
    }
    
}
