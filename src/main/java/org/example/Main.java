package org.example;

import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {


    public static void main(Objects[] args) {

        String matchFilePath="D:\\IPL Dataset\\matches.csv";
        String deliveryFilePath="";
        Map<String,Integer> matchPerYear=new HashMap<>();
        Ipl ipl=new Ipl();

        try{
            //InputStreamReader in=new InputStreamReader(new FileInputStream(matchFilePath));
            BufferedReader bf=new BufferedReader(new FileReader(matchFilePath));
            String [] headerLine = bf.readLine().split(",");
            ipl.setData(headerLine);

            String line=null;

            while ((line=bf.readLine())!=null)
            {
                String [] curr=line.split(",");
                ipl.setData(curr);

               // matchPerYear.put(curr[1],matchPerYear.getOrDefault(curr[1],0)+1);

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

        for(String year:matchPerYear.keySet())
            System.out.println(year+" "+matchPerYear.get(year));

        System.out.println("Hello world!");
    }
}