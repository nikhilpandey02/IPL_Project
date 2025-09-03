package org.example;

import java.util.*;

public class Season {

    private  long totalmatchPlayed;

    private Map<Long,seasonInfo> yearseasonInfo=new HashMap<>();

    public void setMatchperYear(long year)
    {
        if(!yearseasonInfo.containsKey(year))
            yearseasonInfo.put(year,new seasonInfo());
        else {
            seasonInfo curr=yearseasonInfo.get("year");
            curr.totalMatch+=1;
            yearseasonInfo.put(year,curr);
        }
    }
    public long getTotalmatchPlayed(long year)
    {

          if(yearseasonInfo.containsKey(year))
              return yearseasonInfo.get(year).getTotalMatch();

          return 0L;
    }


}
