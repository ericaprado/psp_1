package edu.uniandes.ecos;

import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;


/**
 * Hello world!
 *
 */
public class WebController  extends HttpServlet 
{
    private static final double xk = 386;
    
    public static void main( String[] args )  throws Exception 
    {
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new WebController()),"/*");
        server.start();
        server.join();
    
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            /*
        ResultsPrinter printer = new ResultsPrinter();
        
        String list1 = "130,650,99,150,128,302,95,945,368,961";
        String list2 = "163,765,141,166,137,355,136,1206,433,1130";
        String list3 = "186,699,132,272,291,331,199,1890,788,1601";
        String list4 = "15.0,69.9,6.5,22.4,28.4,65.9,19.4,198.7,38.8,138.2";
        
        String result = "<HTML>";
               
        result += printer.printWebResults(1, setValues(list1, list3));
        result += printer.printWebResults(2, setValues(list1, list4));
        result += printer.printWebResults(3, setValues(list2, list3));
        result += printer.printWebResults(4, setValues(list2, list4));
        
        result += "</HTML>";
        
        resp.getWriter().write(result);          */
        resp.getWriter().write("Hola");
       
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
    
    private static LinkedList<Double> getList(String cad){
        String[] arrayNumbers = cad.split(",");
        LinkedList<Double> list = new LinkedList<Double>();
        
        for (String arrayNumber : arrayNumbers) {
            list.add(Double.parseDouble(arrayNumber));
        }        
        return list;        
    }
}
