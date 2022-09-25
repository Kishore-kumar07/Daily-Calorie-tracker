package Project;

import java.net.*;
import java.io.*;
import static java.lang.System.out;
import java.util.*;
import java.util.Scanner;

public class FitnessClient{
    
   public static void main(String[] args)throws IOException {
       Socket s = new Socket("localhost",4999);
       PrintWriter pr = new PrintWriter(s.getOutputStream());
       Scanner sc=new Scanner(System.in);
       System.out.println("INFORMATION OF THE CLIENT: ");
       System.out.print("ENTER YOUR NAME: ");
       String name=sc.nextLine();
       pr.println(name);
       pr.flush();
       System.out.print("ENTER YOUR AGE: ");
       int age = sc.nextInt();
       pr.println(age);
       pr.flush();
       
       System.out.println("\nBMI OF THE CLIENT: ");
       System.out.print("ENTER YOUR WEIGHT: ");
       int weight = sc.nextInt();
       pr.println(weight);
       pr.flush();
       
       System.out.print("ENTER YOUR HEIGHT: ");
       int height= sc.nextInt();
       pr.println(height);
       pr.flush();
       String bmichart = String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",
                "                     BMI CHART" ,
"------------------------------------------------------------" ,
"            Category            BMI Range" ,
"------------------------------------------------------------" ,
"         Underweight               < 18.5" ,
"              Normal            18.5 - 25" ,
"          Overweight              25 - 30" ,
"               Obese                 > 30" ,
"------------------------------------------------------------");
       
       BufferedReader bf1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
       String str1 = bf1.readLine();
       System.out.println(str1);
       
       System.out.print(bmichart);
       System.out.println("\n");
       
       //while((str1 = bf1.readLine())!= null){
         //  out.println(str1);
          // System.out.println(bf1.readLine());

//}

       Scanner S= new Scanner(System.in);
       System.out.println("Collecting food info from the client: ");
       System.out.println("Enter the food item you ate: ");
       //breakfast
       System.out.print("1. For breakfast: ");
       String breakfast = S.nextLine();
       pr.println(breakfast);
       pr.flush();
       //lunch
       
       System.out.print("1. For lunch: ");
       String lunch = S.nextLine();
       pr.println(lunch);
       pr.flush();

       //Dinner
      System.out.print("1. For Dinner: ");
       String Dinner = S.nextLine();
       pr.println(Dinner);
       pr.flush();
       
       BufferedReader bf2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
       String str2 = bf2.readLine();
       System.out.println(str2);

       
       //Calories burned in Exercise
       System.out.println("\nCollecting Exercises info from the client: ");
       String exerciseChart = String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",
"Aerobics: low impact     Aerobics: high impact           Aerobics: water          Boxing: sparring" ,
"         Circuit Training          Rowing: moderate          Rowing: vigorous               Ski Machine" ,
"            Stair Stepper     Weight Lifting: light Weight Lifting: vigourous                Basketball" ,
"   Basketball: wheelchair       Bicycling: mountain                 Bicycling      Bicycling: 12-13.9ph" ,
"     Bicycling: 14-15.9ph                  Football                   Frisbee      Golf: carrying clubs" ,
"               Gymnastics                  Handball          Horseback Riding               Ice Skating" ,
"             Martial Arts             Rock Climbing       Rollerblade Skating              Rope Jumping" ,
"     Running: (8min/mile)    Running: cross-country              Snow Shoeing                  Softball" ,
"                 Swimming                    Tennis                Volleyball         Volleyball: beach" ,
"   Walk: 4ph (15min/mile)                   Jogging              Water Skiing                Water Polo" ,
"                  rafting");
       System.out.println(exerciseChart);
       System.out.print("Enter the exercise you have done from the above list: ");
       String exercise = S.nextLine();
       pr.println(exercise);
       pr.flush();
       
       System.out.print("Enter the time "+"(in minutes)" +" you have done the exercise for: ");
       String extime = S.nextLine();
       pr.println(extime);
       pr.flush();
       
       BufferedReader bf3 = new BufferedReader(new InputStreamReader(s.getInputStream()));
       String str3 = bf3.readLine();
       System.out.println(str3);
       System.out.println();
       
       BufferedReader bf4 = new BufferedReader(new InputStreamReader(s.getInputStream()));
       String str4 = bf4.readLine();
       System.out.println(str4);
       
       
        
   }
}
