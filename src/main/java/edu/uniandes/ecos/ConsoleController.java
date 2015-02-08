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
public class ConsoleController {
    
    private static final double xk = 386;
    
    public static void main (String[] args){
                
        ResultsPrinter printer = new ResultsPrinter();
        
        String list1 = "130,650,99,150,128,302,95,945,368,961";
        String list2 = "163,765,141,166,137,355,136,1206,433,1130";
        String list3 = "186,699,132,272,291,331,199,1890,788,1601";
        String list4 = "15.0,69.9,6.5,22.4,28.4,65.9,19.4,198.7,38.8,138.2";
        
        printer.printConsoleResults(1, setValues(list1, list3));
        printer.printConsoleResults(2, setValues(list1, list4));
        printer.printConsoleResults(3, setValues(list2, list3));
        printer.printConsoleResults(4, setValues(list2, list4));        
    }
    
    private static LinkedList<Double> getList(String cad){
        String[] arrayNumbers = cad.split(",");
        LinkedList<Double> list = new LinkedList<Double>();
        
        for (String arrayNumber : arrayNumbers) {
            list.add(Double.parseDouble(arrayNumber));
        }        
        return list;        
    }
    
    private static DataProbeMethod setValues(String list1, String list2){
    
        LinearRegression linearRegression = new LinearRegression();
        
        DataProbeMethod data = new DataProbeMethod();
        data.setDataset1(getList(list1));
        data.setDataset2(getList(list2));
        data.setB1(linearRegression.CalculateB1(data.getDataset1(), data.getDataset2()));
        data.setB0(linearRegression.CalculateB0(data.getDataset1(), data.getDataset2(), data.getB1()));
        data.setRxy(linearRegression.CalculateCorrelationCoefficientRxy(data.getDataset1(), data.getDataset2()));
        data.setR2(linearRegression.CalculateCorrelationCoefficientR2(data.getRxy()));
        data.setYk(linearRegression.CalculateImprovedPrediction(xk, data.getB0(), data.getB1()));
        
        return data;
    }
    
}
