package org.example;

import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

   static Ipl ipl=new Ipl();
    public static void main(String[] args) {

        String matchFilePath="D:\\IPL Dataset\\matches.csv";
        String deliveryFilePath="D:\\IPL Dataset\\deliveries.csv";
        Map<String,Integer> matchPerYear=new HashMap<>();


        try{
            //InputStreamReader in=new InputStreamReader(new FileInputStream(matchFilePath));
            BufferedReader bf=new BufferedReader(new FileReader(matchFilePath));
            String [] headerLine = bf.readLine().split(",");
            ipl.setData(headerLine,"match");

            String line=null;

            while ((line=bf.readLine())!=null)
            {
                String [] curr=line.split(",");
                ipl.setData(curr,"match");

               // matchPerYear.put(curr[1],matchPerYear.getOrDefault(curr[1],0)+1);

            }
            bf=new BufferedReader(new FileReader(deliveryFilePath));
            headerLine = bf.readLine().split(",");
            ipl.setData(headerLine,"delivery");
            while((line=bf.readLine())!=null)
            {
                String [] curr=line.split(",");
                ipl.setData(curr,"delivery");
            }
            bf.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.fillInStackTrace());
        }
        catch(IOException e)
        {
            System.out.println(e.fillInStackTrace());

        }

        ipl.getextraRun(2017L);

//        for(String year:matchPerYear.keySet())
//            System.out.println(year+" "+matchPerYear.get(year));
//
//        System.out.println("Hello world!");
    }
}