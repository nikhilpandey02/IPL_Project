package org.example;

import java.util.*;

public class Season {

    private  long totalmatchPlayed;

    private Map<Long,seasonInfo> yearseasonInfo=new HashMap<>();

    public void setMatchperYear(long year)
    {
        if(!yearseasonInfo.containsKey(year))
            yearseasonInfo.put(year,new seasonInfo());
<<<<<<< HEAD

            seasonInfo curr=yearseasonInfo.get(year);
            curr.setTotalMatch();
            yearseasonInfo.put(year,curr);

=======
        else {
            seasonInfo curr=yearseasonInfo.get("year");
            curr.totalMatch+=1;
            yearseasonInfo.put(year,curr);
        }
>>>>>>> d372fd1b82a127f213d9eee1d800a151d3f24e30
    }
    public long getTotalmatchPlayed(long year)
    {

          if(yearseasonInfo.containsKey(year))
              return yearseasonInfo.get(year).getTotalMatch();

          return 0L;
    }


}
