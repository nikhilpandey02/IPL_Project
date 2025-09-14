//package org.example;
//
//import java.util.ArrayList;
//
//import java.util.HashMap;
//
//import java.util.Hashtable;
//
//public class Ipl {
//
//  static   Season s=new Season();
//  static  Team team=new Team();
//    static ArrayList<String> headNameMatches=new ArrayList<>();
//    static ArrayList<String> headNameDelivery=new ArrayList<>();
//    HashMap<Long,Long> matchidName=new HashMap<>();
//
//    public void setData(String [] data,String type)
//    {
//        if(headNameMatches.size()==0 && type.equals("match")) {
//            for (String h : data)
//                headNameMatches.add(h);
//            return;
//        }
//        if(headNameDelivery.size()==0 && type.equals("delivery"))
//        {
//            for (String h : data)
//                headNameDelivery.add(h);
//            return;
//
//        }
//
//               for(int i=0;i<data.length;i++) {
//                   if(type.equals("delivery"))break;
//
//                   long year = Long.valueOf(0);
//                   String curr_team = null;
//                   String bowlerTeam = null;
//                   // String team=null;
//                   if (headNameMatches.get(i).equals("season")) {
//                       year = Long.parseLong(data[i]);
//                       s.setMatchperYear(Long.parseLong(data[i]));
//                   }
//                   if (headNameMatches.get(i).equals("winner")) {
//                       curr_team = data[i];
//                       team.setMatchwonperYear(data[i], year);
//
//                   }
//                   if(year!=0)
//                   matchidName.put(Long.parseLong(data[0]),year);
//
//               }
//               long year=0;
//               for(int i=0;i< data.length;i++) {
//                   if(type.equals("match"))break;
//
//                    year=matchidName.get(Long.parseLong(data[0]));
//
//
//                   String bowlerteamName=null;
//                   long extra_run=0;
//                   if(headNameDelivery.get(i).equals("bowling_team"))
//                       bowlerteamName=data[i];
//
//                   if (headNameDelivery.get(i).equals("wide_runs") || headNameDelivery.get(i).equals("bye_runs") ||
//                           headNameDelivery.get(i).equals("bye_runs") || headNameDelivery.get(i).equals("legbye_runs")
//                           || headNameDelivery.get(i).equals("noball_runs") || headNameDelivery.get(i).equals("penalty_runs")
//                           || headNameDelivery.get(i).equals("noball_runs")) {
//                       long extra=Long.parseLong(data[i]);
//                         team.setExtrarunperYear(year,bowlerteamName,extra);
//
//                   }
//               }
////               if(type.equals("delivery"))
////                   System.out.println(year+" "+data[0]);
//
//
//
//               //printing totalmatch played in a ayear
//              // System.out.println(s.getTotalmatchPlayed(2017));
//
//              //printing match won peryear
//             //  System.out.println(team.gettotalmatchwonbyaTeam("Delhi Daredevils"));
//
//        //fetch extra run per year
//
//    }
//    public void getextraRun(Long year)
//    {
//        HashMap<String,Long> teamExtraRun=team.getextrarunperyear(year);
//        System.out.println(teamExtraRun.size());
//        for(String ex:teamExtraRun.keySet())
//            System.out.println(ex+"  "+ teamExtraRun.get(ex));
//=======
//    Season s=new Season();
//    static ArrayList<String> headName=new ArrayList<>();
//
//    public void setData(String [] data)
//    {
//        if(headName.size()==0) {
//            for (String h : data)
//                headName.add(h);
//
//        }
//        else
//        {
//               for(int i=0;i<data.length;i++)
//               {
//                   if(data[i].equals("season"))
//                   {
//                       s.setMatchperYear(Long.parseLong(data[i]));
//                   }
//               }
//            System.out.println(s.getTotalmatchPlayed(2017));
//        }
//
//>>>>>>> d372fd1b82a127f213d9eee1d800a151d3f24e30
//    }
//}
