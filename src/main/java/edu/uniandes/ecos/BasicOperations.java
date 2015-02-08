/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author ASUS-PC
 */
public class BasicOperations {
    
    public Double SumItems(LinkedList<Double> numbersList){
        
        double accum = 0;
        
        for (Iterator iterator = numbersList.iterator(); iterator.hasNext();) {
            accum += (Double)iterator.next();        
        }       
        return accum;
    }
    
    
    public Double SumItemPow2(LinkedList<Double> numbersList){
        double accum = 0;
        
        for (Iterator iterator = numbersList.iterator(); iterator.hasNext();) {
            accum += Math.pow((Double)iterator.next(),2);        
        }       
        return accum;
    }
    
    
    public Double SumItemTimesItem(LinkedList<Double> dataset1, LinkedList<Double> dataset2){
        double accum = 0;
        
        for (int i = 0; i < dataset1.size(); i++) {                
            accum += dataset1.get(i)*dataset2.get(i);       
        }       
        return accum;
    }
    
        
    
    public double CalculateAverage (LinkedList numeros){
    
        Iterator it = numeros.iterator();
        
        double sumatoria = 0;
        
        while(it.hasNext()){            
            sumatoria += Double.parseDouble(it.next().toString());
        }
        
        return sumatoria/(numeros.size());
        
    }
    
    
}
