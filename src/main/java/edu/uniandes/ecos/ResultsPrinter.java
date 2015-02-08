/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos;

/**
 *
 * @author ASUS-PC
 */
public class ResultsPrinter {
    
    public String printWebResults(int testId, DataProbeMethod data){
    
        String result = "";
        
        result += "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";
        result += "</BR><h1>RESULTADOS TEST " + testId + "</h1></BR>";
        result += "<TABLE><TR><TD></B>Lista 1</TD><TD></B>Lista 2</TD></TR>";
        
        for (int i = 0; i < data.dataset1.size(); i++) {
            result += "<TR><TD>"+ data.dataset1.get(i) +"</TD><TD>"+ data.dataset2.get(i) +"</TD></TR>";
        }
        
        result += "</TABLE></BR>";
        result += "B0 = " + data.b0 + "</BR>";
        result += "B1 = " + data.b1 + "</BR>";
        result += "Rxy = " + data.rxy + "</BR>";
        result += "R2 = " + data.r2 + "</BR>";
        result += "Yk = " + data.yk + "</BR></BR>";
                
        return result;    
    }
    
    
    public void printConsoleResults(int testId, DataProbeMethod data){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("RESULTADOS TEST " + testId + "\n");

        System.out.println("L1 \t L2");

            for (int i = 0; i < data.dataset1.size(); i++) {
                System.out.println(data.dataset1.get(i) +"\t"+ data.dataset2.get(i));
            }

        System.out.println("B0 = " + data.b0 );
        System.out.println("B1 = " + data.b1 );
        System.out.println("Rxy = " + data.rxy );
        System.out.println("R2 = " + data.r2 );
        System.out.println("Yk = " + data.yk );
        
    }
    
    
}
