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
public class LinearRegression {
    
    public double CalculateB1(LinkedList<Double> dataset1, LinkedList<Double> dataset2){
    
        BasicOperations basicOperations = new BasicOperations();
                
        double b1 = 0;
        double xAvg = basicOperations.CalculateAverage(dataset1);
        
        try {
            
            b1 = (basicOperations.SumItemTimesItem(dataset1, dataset2)) - (dataset1.size() * xAvg * basicOperations.CalculateAverage(dataset2));        
            b1 =  b1/((basicOperations.SumItemPow2(dataset1))-(dataset1.size() * Math.pow(xAvg, 2)));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
      
        return b1;
    }
    
    
    public double CalculateB0(LinkedList<Double> dataset1, LinkedList<Double> dataset2, double b1){
        
        BasicOperations basicOperations = new BasicOperations();
        return basicOperations.CalculateAverage(dataset2)  -  (b1 * (basicOperations.CalculateAverage(dataset1)));
    }
    
    
    public double CalculateCorrelationCoefficientRxy(LinkedList<Double> dataset1, LinkedList<Double> dataset2){
        
        BasicOperations basicOperations = new BasicOperations();
        double b1 = 0;
        
        try {
            b1 = (dataset1.size() * basicOperations.SumItemTimesItem(dataset1, dataset2)) - (basicOperations.SumItems(dataset1) * (basicOperations.SumItems(dataset2)));
            
            b1 = b1 / (Math.sqrt(((dataset1.size()*basicOperations.SumItemPow2(dataset1)) - (Math.pow(basicOperations.SumItems(dataset1), 2)))*((dataset2.size()*basicOperations.SumItemPow2(dataset2)) - (Math.pow(basicOperations.SumItems(dataset2), 2)))));
            
        } catch (Exception e) {
        }
        
        return b1;
    }
    
    
    public double CalculateCorrelationCoefficientR2(double r){
        
        return r * r;
    }
    
    
    public double CalculateImprovedPrediction(double x, double b0, double b1){
        return b0 + (b1 * x);
    }
}
