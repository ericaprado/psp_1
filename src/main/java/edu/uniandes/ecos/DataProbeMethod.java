/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos;

import java.util.LinkedList;

/**
 *
 * @author ASUS-PC
 */
public class DataProbeMethod {
    
    LinkedList<Double> dataset1;
    LinkedList<Double> dataset2;
    
    double b0;
    double b1;
    double rxy;
    double r2;
    double yk;
    
    

    public void setDataset1(LinkedList<Double> dataset1) {
        this.dataset1 = dataset1;
    }

    public void setDataset2(LinkedList<Double> dataset2) {
        this.dataset2 = dataset2;
    }

    public void setB0(double b0) {
        this.b0 = b0;
    }

    public void setB1(double b1) {
        this.b1 = b1;
    }

    public void setRxy(double rxy) {
        this.rxy = rxy;
    }

    public void setR2(double r2) {
        this.r2 = r2;
    }

    public void setYk(double yk) {
        this.yk = yk;
    }
    
    
    public LinkedList<Double> getDataset1() {
        return dataset1;
    }

    public LinkedList<Double> getDataset2() {
        return dataset2;
    }

    public double getB0() {
        return b0;
    }

    public double getB1() {
        return b1;
    }

    public double getRxy() {
        return rxy;
    }

    public double getR2() {
        return r2;
    }

    public double getYk() {
        return yk;
    }
    
    
    
}
