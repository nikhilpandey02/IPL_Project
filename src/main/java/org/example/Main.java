package org.example;

import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

<<<<<<< HEAD
   static Ipl ipl=new Ipl();
    public static void main(String[] args) {

        String matchFilePath="D:\\IPL Dataset\\matches.csv";
        String deliveryFilePath="D:\\IPL Dataset\\deliveries.csv";
        Map<String,Integer> matchPerYear=new HashMap<>();

=======

    public static void main(Objects[] args) {

        String matchFilePath="D:\\IPL Dataset\\matches.csv";
        String deliveryFilePath="";
        Map<String,Integer> matchPerYear=new HashMap<>();
        Ipl ipl=new Ipl();
>>>>>>> d372fd1b82a127f213d9eee1d800a151d3f24e30

        try{
            //InputStreamReader in=new InputStreamReader(new FileInputStream(matchFilePath));
            BufferedReader bf=new BufferedReader(new FileReader(matchFilePath));
            String [] headerLine = bf.readLine().split(",");
<<<<<<< HEAD
            ipl.setData(headerLine,"match");
=======
            ipl.setData(headerLine);
>>>>>>> d372fd1b82a127f213d9eee1d800a151d3f24e30

            String line=null;

            while ((line=bf.readLine())!=null)
            {
                String [] curr=line.split(",");
<<<<<<< HEAD
                ipl.setData(curr,"match");
=======
                ipl.setData(curr);
>>>>>>> d372fd1b82a127f213d9eee1d800a151d3f24e30

               // matchPerYear.put(curr[1],matchPerYear.getOrDefault(curr[1],0)+1);

            }
<<<<<<< HEAD
            bf=new BufferedReader(new FileReader(deliveryFilePath));
            headerLine = bf.readLine().split(",");
            ipl.setData(headerLine,"delivery");
            while((line=bf.readLine())!=null)
            {
                String [] curr=line.split(",");
                ipl.setData(curr,"delivery");
            }
=======
>>>>>>> d372fd1b82a127f213d9eee1d800a151d3f24e30
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

<<<<<<< HEAD
        ipl.getextraRun(2017L);

//        for(String year:matchPerYear.keySet())
//            System.out.println(year+" "+matchPerYear.get(year));
//
//        System.out.println("Hello world!");
=======
        for(String year:matchPerYear.keySet())
            System.out.println(year+" "+matchPerYear.get(year));

        System.out.println("Hello world!");
>>>>>>> d372fd1b82a127f213d9eee1d800a151d3f24e30
    }
}