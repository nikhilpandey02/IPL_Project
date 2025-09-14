//package org.example;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Team {
//
//<<<<<<< HEAD
//    private   String teamName;
//    private String ownerName;
//    private HashMap<String,Long> matchwonperYear=new HashMap<>();
//
//    private HashMap<String,Long> totalmatchwonbyaTeam=new HashMap<>();
//    private HashMap<Long,HashMap<String,Long>> extrarunperYear=new HashMap<>();
//
//    public void setMatchwonperYear(String teamName,Long year) {
//        matchwonperYear.put(teamName,matchwonperYear.getOrDefault(teamName,0L)+1);
//        totalmatchwonbyaTeam.put(teamName,totalmatchwonbyaTeam.getOrDefault(teamName,0L)+1);
//
//    }
//    public long gettotalmatchwonbyaTeam(String team)
//    {
//        if(!totalmatchwonbyaTeam.containsKey(team))return 0;
//        return totalmatchwonbyaTeam.get(team);
//    }
//
//    public void setExtrarunperYear(Long year,String teamName,Long extraRun) {
//        if(!extrarunperYear.containsKey(year))
//         extrarunperYear.put(year,new HashMap<>());
//
//        HashMap<String,Long> teamNameExtraRun=extrarunperYear.get(year);
//        teamNameExtraRun.put(teamName,teamNameExtraRun.getOrDefault(teamName,0L)+extraRun);
//       // System.out.println(extrarunperYear.size());
//        //extrarunperYear.put(year,extrarunperYear.getOrDefault(extraRun,0L)+1);
//=======
//
//    private   String teamName;
//   private String ownerName;
//    private HashMap<Long,Long> matchwonperYear=new HashMap<>();
//    private HashMap<Long,Long> extrarunperYear=new HashMap<>();
//
//
//
//    public void setMatchwonperYear(long year) {
//        matchwonperYear.put(year,matchwonperYear.getOrDefault(year,0L)+1);
//        for( Map.Entry<Long, Long> e : matchwonperYear.entrySet())
//        {}
//    }
//
//    public void setExtrarunperYear(long year,long extraRun) {
//        extrarunperYear.put(year,extrarunperYear.getOrDefault(extraRun,0L)+1);
//>>>>>>> d372fd1b82a127f213d9eee1d800a151d3f24e30
//    }
//
//    public String getTeamName() {
//        return teamName;
//    }
//
//    public void setTeamName(String teamName) {
//        this.teamName = teamName;
//    }
//
//    public String getOwnerName() {
//        return ownerName;
//    }
//
//    public void setOwnerName(String ownerName) {
//        this.ownerName = ownerName;
//    }
//
//
//<<<<<<< HEAD
//    public Long getmatchwonperyear(String teamName,long year) {
//        if(!matchwonperYear.containsKey(teamName))return Long.valueOf(-1);
//        return matchwonperYear.get(teamName);
//    }
//    public HashMap<String,Long> getextrarunperyear(Long year) {
//        //if map is null then check
//        if(extrarunperYear.size()==0) System.out.println("no data");
//        System.out.println(extrarunperYear.get(2017L).size());
//
//        return extrarunperYear.get(year);
//    }
//}
//
//=======
//    public Long getmatchwonperyear(long year) {
//        return matchwonperYear.get(year);
//    }
//    public Long getextrarunperyear(long year) {
//        return extrarunperYear.get(year);
//    }
//}
//>>>>>>> d372fd1b82a127f213d9eee1d800a151d3f24e30
