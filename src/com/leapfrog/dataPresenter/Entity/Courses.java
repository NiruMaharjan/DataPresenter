/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.dataPresenter.Entity;

/**
 *
 * @author Lenovo
 */
public class Courses {
    private int id;
    private String  name;
    private int fees;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "Courses{" + "id=" + id + ", name=" + name + ", fees=" + fees + '}';
    }
    
    
    
    
}
