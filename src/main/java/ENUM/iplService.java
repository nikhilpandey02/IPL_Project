//package IPL;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.PriorityQueue;
//
//public class iplService {
//
//    static ArrayList<String> matchHeader=new ArrayList<>();
//    static ArrayList<String> deliveryHeader=new ArrayList<>();
//    HashMap<Long, Matchmodel> matchDataStore=new HashMap<>();
//
//    ArrayList<Deliverymodel> deliveryModelArrayList=new ArrayList<>();
//    public void loadMatchData(String path)
//    {
//        try{
//            BufferedReader bf=new BufferedReader(new FileReader(path));
//            //String [] data=bf.readLine().split((","));
//            String line=null;
//            while((line=bf.readLine())!=null)
//            setMatchData(line.split(","));
//
//        }catch (FileNotFoundException e)
//        {
//
//        }
//        catch (IOException e)
//        {
//
//        }
//
//    }
//    public void loadDeliveryData(String path)
//    {
//        try
//        {
//            BufferedReader bf=new BufferedReader(new FileReader(path));
//            String line=null;
//            while((line=bf.readLine())!=null)
//                setDeliveryData(line.split(","));
//        }
//        catch (FileNotFoundException e)
//        {}
//        catch (IOException e)
//        {}
//
//    }
//
//    public void setMatchData(String [] data)
//    {
//        if(matchHeader.size()==0)
//        {
//            for(String s:data)
//                matchHeader.add(s);
//        }
//        else {
//                Matchmodel match = new Matchmodel();
//                for (int i = 0; i < data.length; i++) {
//                    String columnName = matchHeader.get(i);
//                    String value = data[i];
//
//                    switch (columnName) {
//                        case "id":
//                            match.setId(Long.parseLong(value));
//                            break;
//                        case "season":
//                            match.setSeason(Long.parseLong(value));
//                            break;
//                        case "city":
//                            match.setCity(value);
//                            break;
//                        case "date":
//                            match.setDate(value);
//                            break;
//                        case "team1":
//                            match.setTeam1(value);
//                            break;
//                        case "team2":
//                            match.setTeam2(value);
//                            break;
//                        case "toss_winner":
//                            match.setTossWinner(value);
//                            break;
//                        case "toss_decision":
//                            match.setTossDecision(value);
//                            break;
//                        case "result":
//                            match.setResult(value);
//                            break;
//                        case "dl_applied":
//                            match.setDlApplied(value.isEmpty() ? 0 : Integer.parseInt(value));
//                            break;
//                        case "winner":
//                            match.setWinner(value);
//                            break;
//                        case "win_by_runs":
//                            match.setWinByRuns(value.isEmpty() ? 0 : Integer.parseInt(value));
//                            break;
//                        case "win_by_wickets":
//                            match.setWinByWickets(value.isEmpty() ? 0 : Integer.parseInt(value));
//                            break;
//                        case "player_of_match":
//                            match.setPlayerOfMatch(value);
//                            break;
//                        case "venue":
//                            match.setVenue(value);
//                            break;
//                        case "umpire1":
//                            match.setUmpire1(value);
//                            break;
//                        case "umpire2":
//                            match.setUmpire2(value);
//                            break;
//                        case "umpire3":
//                            match.setUmpire3(value);
//                            break;
//                        default:
//                            // Unknown column, ignore or log
//                            break;
//                    }
//                }
//                matchDataStore.put(match.getId(),match);
//
//            }
//        }
//        public void setDeliveryData(String [] data)
//        {
//            if(deliveryHeader.size()==0)
//            {
//                for(String s:data)
//                    deliveryHeader.add(s);
//            }
//            else {
//                Deliverymodel delivery = new Deliverymodel();
//                for (int i = 0; i < data.length; i++) {
//                    String columnName = deliveryHeader.get(i);
//                    String value = data[i];
//
//                    switch (columnName) {
//                        case "match_id":
//                            delivery.setMatchId(Long.parseLong(value));
//                            break;
//                        case "inning":
//                            delivery.setInning(Integer.parseInt(value));
//                            break;
//                        case "batting_team":
//                            delivery.setBattingTeam(value);
//                            break;
//                        case "bowling_team":
//                            delivery.setBowlingTeam(value);
//                            break;
//                        case "over":
//                            delivery.setOver(Integer.parseInt(value));
//                            break;
//                        case "ball":
//                            delivery.setBall(Integer.parseInt(value));
//                            break;
//                        case "batsman":
//                            delivery.setBatsman(value);
//                            break;
//                        case "non_striker":
//                            delivery.setNonStriker(value);
//                            break;
//                        case "bowler":
//                            delivery.setBowler(value);
//                            break;
//                        case "is_super_over":
//                            delivery.setIsSuperOver(Integer.parseInt(value));
//                            break;
//                        case "wide_runs":
//                            delivery.setWideRuns(Integer.parseInt(value));
//                            break;
//                        case "bye_runs":
//                            delivery.setByeRuns(Integer.parseInt(value));
//                            break;
//                        case "legbye_runs":
//                            delivery.setLegbyeRuns(Integer.parseInt(value));
//                            break;
//                        case "noball_runs":
//                            delivery.setNoballRuns(Integer.parseInt(value));
//                            break;
//                        case "penalty_runs":
//                            delivery.setPenaltyRuns(Integer.parseInt(value));
//                            break;
//                        case "batsman_runs":
//                            delivery.setBatsmanRuns(Integer.parseInt(value));
//                            break;
//                        case "extra_runs":
//                            delivery.setExtraRuns(Integer.parseInt(value));
//                            break;
//                        case "total_runs":
//                            delivery.setTotalRuns(Integer.parseInt(value));
//                            break;
//                        case "player_dismissed":
//                            delivery.setPlayerDismissed(value);
//                            break;
//                        case "dismissal_kind":
//                            delivery.setDismissalKind(value);
//                            break;
//                        case "fielder":
//                            delivery.setFielder(value);
//                            break;
//                        default:
//                            // Unknown fields can be ignored or logged
//                            break;
//                    }
//                }
//                deliveryModelArrayList.add(delivery);
//
//            }
//
//
//        }
//
//        public HashMap<Long,Long> matchplayerperYear()
//        {
//            HashMap<Long,Long> map=new HashMap<>();
//
//            for(Long matchId:matchDataStore.keySet())
//            {
//                Matchmodel m=matchDataStore.get(matchId);
//                map.put(m.getSeason(),map.getOrDefault(m.getSeason(),0L)+1);
//
//            }
//            return map;
//        }
//    public HashMap<String,Long> matchwonperYear()
//    {
//        HashMap<String,Long> map=new HashMap<>();
//
//        for(Long matchId:matchDataStore.keySet())
//        {
//            Matchmodel m=matchDataStore.get(matchId);
//            map.put(m.getWinner(),map.getOrDefault(m.getWinner(),0L)+1);
//
//        }
//        return map;
//    }
//
//    public HashMap<String, Long> extrarungivenperteamperYear(Long year)
//    {
//        HashMap<String,Long> map=new HashMap<>();
//        Long match_id=-1L;
//        for(Long id:matchDataStore.keySet()) {
//            if (matchDataStore.get(id).getSeason().equals(year)) {
//
//                for (int i = 0; i < deliveryModelArrayList.size(); i++) {
//                    Deliverymodel d = deliveryModelArrayList.get(i);
//                    Long id1 = d.getMatchId();
//                    String teamName = d.getBowlingTeam();
//                   // System.out.println(id + " " + match_id);
//                    if (id.equals(id1)) {
//                        Long run = d.getByeRuns() + d.getLegbyeRuns() + d.getNoballRuns() + (long) d.getPenaltyRuns();
//                        map.put(teamName, map.getOrDefault(teamName, 0L) + run);
//                    }
//
//                }
//            }
//        }
//       // System.out.println(map.size());
//        return map;
//    }
//
//    //economical bowler
//
//      public PriorityQueue<Pair> geteconomical(Long year)
//      {
//          PriorityQueue<Pair> pq=new PriorityQueue<Pair>((a,b)->Double.compare(a.val,b.val));
//          HashMap<String,Double> map=new HashMap<>();
//
//          for(int i=0;i<deliveryModelArrayList.size();i++)
//          {
//
//          }
//          return pq;
//      }
//
//
//
//    }
////    class Pair{
////    String name;
////    Double val;
////       public Pair(String name,Double val)
////       {
////           this.name=name;
////           this.val=val;
////       }
////    }
//
