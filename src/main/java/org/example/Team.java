package org.example;

import java.util.HashMap;
import java.util.Map;

public class Team {


    private   String teamName;
   private String ownerName;
    private HashMap<Long,Long> matchwonperYear=new HashMap<>();
    private HashMap<Long,Long> extrarunperYear=new HashMap<>();



    public void setMatchwonperYear(long year) {
        matchwonperYear.put(year,matchwonperYear.getOrDefault(year,0L)+1);
        for( Map.Entry<Long, Long> e : matchwonperYear.entrySet())
        {}
    }

    public void setExtrarunperYear(long year,long extraRun) {
        extrarunperYear.put(year,extrarunperYear.getOrDefault(extraRun,0L)+1);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }


    public Long getmatchwonperyear(long year) {
        return matchwonperYear.get(year);
    }
    public Long getextrarunperyear(long year) {
        return extrarunperYear.get(year);
    }
}
