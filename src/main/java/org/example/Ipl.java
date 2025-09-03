package org.example;

import java.util.ArrayList;
import java.util.Hashtable;

public class Ipl {

    Season s=new Season();
    static ArrayList<String> headName=new ArrayList<>();

    public void setData(String [] data)
    {
        if(headName.size()==0) {
            for (String h : data)
                headName.add(h);

        }
        else
        {
               for(int i=0;i<data.length;i++)
               {
                   if(data[i].equals("season"))
                   {
                       s.setMatchperYear(Long.parseLong(data[i]));
                   }
               }
            System.out.println(s.getTotalmatchPlayed(2017));
        }

    }
}
