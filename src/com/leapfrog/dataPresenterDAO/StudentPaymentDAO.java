/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.dataPresenterDAO;

import com.leapfrog.dataPresenter.Entity.StudentPayment;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface StudentPaymentDAO {

    boolean insert(StudentPayment sp);

    List<StudentPayment> getAll();

}
