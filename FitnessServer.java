package fitness;

import com.mysql.cj.xdevapi.Statement;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import java.net.*;
import java.io.*;


public class FitnessServer{
    public class BMI {
        public static float height;
        public static float weight,bmi;
        public static double lbs;
        public static int age;
        public static String bmichart;
        
    }
    public static void calculateBMI() throws Exception{
        
        BMI.lbs =BMI.weight;
        BMI.lbs = BMI.lbs*2.20462;
        // multiplication by 100*100 for cm to m conversion
        BMI.bmi = (100*100*BMI.weight)/(BMI.height*BMI.height);
        BMI.bmichart = String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",
                "                     BMI CHART" ,
"------------------------------------------------------------" ,
"            Category            BMI Range" ,
"------------------------------------------------------------" ,
"         Underweight               < 18.5" ,
"              Normal            18.5 - 25" ,
"          Overweight              25 - 30" ,
"               Obese                 > 30" ,
"------------------------------------------------------------");
        
        
        
    }
    public static void main(String[] args)throws IOException, Exception{
          // Step 1: Establish the socket connection.
        
        ServerSocket ss = new ServerSocket(4999);
        Socket s= ss.accept();
        System.out.println("client connected");
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        String food1,food2,food3, extime;
        int foodcal1=0,foodcal2=0,foodcal3=0,totfoodcal=0;
        //name
        
        BufferedReader bf1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String name = bf1.readLine();
        
        //age
        BufferedReader bf2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BMI.age = Integer.parseInt(bf2.readLine());
        
        System.out.println("Client information received.");
        
        //weight
        BufferedReader bf3 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BMI.weight = Integer.parseInt(bf3.readLine());
        
        BufferedReader bf4 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BMI.height = Integer.parseInt(bf4.readLine());
        
        calculateBMI();
        //pr.print(BMI.bmichart);
        //pr.flush();
        
        pr.println("YOUR BMI IS:  " + BMI.bmi);
        pr.flush();
        
        //food calories consumed
        BufferedReader bf5 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        food1 = bf5.readLine();
        
        BufferedReader bf6 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        food2 = bf6.readLine();
        
        BufferedReader bf7 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        food3 = bf7.readLine();
        
        int time = 0,timedone=0;
        
        try{
        String  user = "root";
        String password = "Kishore1912@?";
        String url = "jdbc:mysql://localhost:3306/fitness";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c= DriverManager.getConnection(url, user,password);
        
        
        
        java.sql.Statement stmt1=c.createStatement();
        java.sql.ResultSet rs1=stmt1.executeQuery("select Calories from calories Where FoodItem= '" +food1+"'");
        while(rs1.next()){  
            foodcal1 =rs1.getInt(1);
            
        }
        
        java.sql.Statement stmt2=c.createStatement();
        java.sql.ResultSet rs2=stmt2.executeQuery("select Calories from calories Where FoodItem= '" +food2+"'");
        while(rs2.next()){  
            foodcal2 =rs2.getInt(1);
            
        }
        java.sql.Statement stmt3=c.createStatement();
        java.sql.ResultSet rs3=stmt3.executeQuery("select Calories from calories Where FoodItem= '" +food3+"'");
        while(rs3.next()){  
            foodcal3 =rs3.getInt(1);
            
        }
        totfoodcal = foodcal1+foodcal2+foodcal3;
        pr.println("Total calories of food you consumed: " + Integer.toString(totfoodcal));
        pr.flush();
        
        BufferedReader bf8 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        extime = bf7.readLine();
        
        java.sql.Statement stmt4=c.createStatement();
        
        if(BMI.lbs<=100){
            
            java.sql.ResultSet rs4=stmt4.executeQuery("select 100lbs from exercises Where Exercise= '" +extime+"'");
        
            while(rs4.next()){
                time = rs4.getInt(1);
            }
        
            c.close();
        }
        else if(BMI.lbs>100 && BMI.lbs<=125){
            
            java.sql.ResultSet rs4=stmt4.executeQuery("select 125lbs from exercises Where Exercise= '" +extime+"'");
        
            while(rs4.next()){
                time = rs4.getInt(1);
            }
        
            c.close();
        }
        else if(BMI.lbs>137.5 && BMI.lbs<=162.5){
            
            java.sql.ResultSet rs4=stmt4.executeQuery("select 150lbs from exercises Where Exercise= '" +extime+"'");
        
            while(rs4.next()){
                time = rs4.getInt(1);
            }
        
            c.close();
        }
        else if(BMI.lbs>162.5 && BMI.lbs<=187.5){
            
            java.sql.ResultSet rs4=stmt4.executeQuery("select 175lbs from exercises Where Exercise= '" +extime+"'");
        
            while(rs4.next()){
                time = rs4.getInt(1);
            }
        
            c.close();
        }
        else if(BMI.lbs>187.5 && BMI.lbs<=225){
            
            java.sql.ResultSet rs4=stmt4.executeQuery("select 200lbs from exercises Where Exercise= '" +extime+"'");
        
            while(rs4.next()){
                time = rs4.getInt(1);
            }
        
            c.close();
        }
        else if(BMI.lbs>225 && BMI.lbs<=275){
            System.out.print("Enter the exercise you have done: ");
            
            java.sql.ResultSet rs4=stmt4.executeQuery("select 250lbs from exercises Where Exercise= '" +extime+"'");
        
            while(rs4.next()){
                time = rs4.getInt(1);
            }
        
            c.close();
        }
        else {
            
            java.sql.ResultSet rs4=stmt4.executeQuery("select 300lbs from exercises Where Exercise= '" +extime+"'");
        
            while(rs4.next()){
                time = rs4.getInt(1);
                
            }
            
        }
            c.close();
        
        
        }
        
        
        catch(ClassNotFoundException ex){
            Logger.getLogger(FitnessServer.class.getName()).log(Level.SEVERE,null,ex);
        } catch (SQLException ex) {
            Logger.getLogger(FitnessServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        BufferedReader bf8 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        timedone = Integer.parseInt(bf8.readLine());
        
        double timefloat, timedonefloat;
        timefloat = (double)time;
        timedonefloat = (double)timedone;
        double burn;
        burn = (timedonefloat/timefloat)*500;
        
        pr.println("The total calories you have burned out in exercise is: " + burn);
        pr.flush();
        
        if(burn<totfoodcal){
            pr.println("Time to focus on your body!!!!!!!! You need to do some extra exercise or else you will get obese!!!!!!!!");
            pr.flush();
        }else{
            pr.println("You are rocking... Make this routine consistent, Soon you can get an amazing physique");
            pr.flush();
        }
        
        
}
}
