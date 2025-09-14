package IPL;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class main {
    static ArrayList<String> matchHeader = new ArrayList<>();
    static ArrayList<String> deliveryHeader = new ArrayList<>();
    static HashMap<Long, Matchmodel> matchDataStore = new HashMap<>();
    static ArrayList<Deliverymodel> deliveryModelArrayList = new ArrayList<>();
    public static HashMap<Long, HashMap<String, HashMap<String, Count>>> getEconomicalbyteambyvenuebyYear() {
        HashMap<Long, HashMap<String, HashMap<String, Count>>> resultbyvenuebyYear = new HashMap<>();

        for (Long matchId : matchDataStore.keySet()) {
            String team1 = matchDataStore.get(matchId).getTeam1();
            String team2 = matchDataStore.get(matchId).getTeam2();
            Long year = matchDataStore.get(matchId).getSeason();
            String venue = matchDataStore.get(matchId).getCity();

            if (team1.equals("Mumbai Indians") || team2.equals("Mumbai Indians")) {
               // System.out.println(year+" ");
                for (int i = 0; i < deliveryModelArrayList.size(); i++) {
                    Deliverymodel delivery = deliveryModelArrayList.get(i);
                    //mistake doing == comparsion
                    if (delivery.getMatchId().equals(matchId) && !delivery.getBowlingTeam().equals("Mumbai Indians")) {

                        String bowlerName = delivery.getBowler();
                        Long runs = (long) delivery.getTotalRuns()-delivery.getByeRuns()-delivery.getWideRuns();

                        if (!resultbyvenuebyYear.containsKey(year)) {
                            resultbyvenuebyYear.put(year, new HashMap<>());
                        }
                        HashMap<String, HashMap<String, Count>> venueBowler = resultbyvenuebyYear.get(year);

                        if (!venueBowler.containsKey(venue)) {
                            venueBowler.put(venue, new HashMap<>());
                        }
                        HashMap<String, Count> bowlereconomyList = venueBowler.get(venue);
                        if (!bowlereconomyList.containsKey(bowlerName)) {
                            bowlereconomyList.put(bowlerName, new Count(0L, 0L));
                        }

                        Count bowlerData = bowlereconomyList.get(bowlerName);

                        bowlerData.total_run += runs;
                        if (delivery.getWideRuns() == 0 && delivery.getNoballRuns()==0) {
                            bowlerData.total_bowl += 1;
                        }
                    }
                }
            }
        }
        System.out.println(resultbyvenuebyYear.size());
        return resultbyvenuebyYear;
    }

    public static void loadMatchData(String path) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bf.readLine()) != null) {
                setMatchData(line.split(","));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Match file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading match file: " + e.getMessage());
        }
    }

    public static void loadDeliveryData(String path) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bf.readLine()) != null) {
                setDeliveryData(line.split(","));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Delivery file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading delivery file: " + e.getMessage());
        }
    }
    public static void setMatchData(String[] data) {
        if (matchHeader.isEmpty()) {
            Collections.addAll(matchHeader, data);
        } else {
            Matchmodel match = new Matchmodel();
            for (int i = 0; i < data.length; i++) {
                String columnName = matchHeader.get(i);
                String value = data[i];
                switch (columnName) {
                    case "id": match.setId(Long.parseLong(value)); break;
                    case "season": match.setSeason(Long.parseLong(value)); break;
                    case "city": match.setCity(value); break;
                    case "date": match.setDate(value); break;
                    case "team1": match.setTeam1(value); break;
                    case "team2": match.setTeam2(value); break;
                    case "toss_winner": match.setTossWinner(value); break;
                    case "toss_decision": match.setTossDecision(value); break;
                    case "result": match.setResult(value); break;
                    case "dl_applied": match.setDlApplied(value.isEmpty() ? 0 : Integer.parseInt(value)); break;
                    case "winner": match.setWinner(value); break;
                    case "win_by_runs": match.setWinByRuns(value.isEmpty() ? 0 : Integer.parseInt(value)); break;
                    case "win_by_wickets": match.setWinByWickets(value.isEmpty() ? 0 : Integer.parseInt(value)); break;
                    case "player_of_match": match.setPlayerOfMatch(value); break;
                    case "venue": match.setVenue(value); break;
                    case "umpire1": match.setUmpire1(value); break;
                    case "umpire2": match.setUmpire2(value); break;
                    case "umpire3": match.setUmpire3(value); break;
                    default: break;
                }
            }
            matchDataStore.put(match.getId(), match);
        }
    }

    public static void setDeliveryData(String[] data) {
        if (deliveryHeader.isEmpty()) {
            Collections.addAll(deliveryHeader, data);
        } else {
            Deliverymodel delivery = new Deliverymodel();
            for (int i = 0; i < data.length; i++) {
                String columnName = deliveryHeader.get(i);
                String value = data[i];
                switch (columnName) {
                    case "match_id": delivery.setMatchId(Long.parseLong(value)); break;
                    case "inning": delivery.setInning(Integer.parseInt(value)); break;
                    case "batting_team": delivery.setBattingTeam(value); break;
                    case "bowling_team": delivery.setBowlingTeam(value); break;
                    case "over": delivery.setOver(Integer.parseInt(value)); break;
                    case "ball": delivery.setBall(Integer.parseInt(value)); break;
                    case "batsman": delivery.setBatsman(value); break;
                    case "non_striker": delivery.setNonStriker(value); break;
                    case "bowler": delivery.setBowler(value); break;
                    case "is_super_over": delivery.setIsSuperOver(Integer.parseInt(value)); break;
                    case "wide_runs": delivery.setWideRuns(Integer.parseInt(value)); break;
                    case "bye_runs": delivery.setByeRuns(Integer.parseInt(value)); break;
                    case "legbye_runs": delivery.setLegbyeRuns(Integer.parseInt(value)); break;
                    case "noball_runs": delivery.setNoballRuns(Integer.parseInt(value)); break;
                    case "penalty_runs": delivery.setPenaltyRuns(Integer.parseInt(value)); break;
                    case "batsman_runs": delivery.setBatsmanRuns(Integer.parseInt(value)); break;
                    case "extra_runs": delivery.setExtraRuns(Integer.parseInt(value)); break;
                    case "total_runs": delivery.setTotalRuns(Integer.parseInt(value)); break;
                    case "player_dismissed": delivery.setPlayerDismissed(value); break;
                    case "dismissal_kind": delivery.setDismissalKind(value); break;
                    case "fielder": delivery.setFielder(value); break;
                    default: break;
                }
            }
            deliveryModelArrayList.add(delivery);
        }
    }

    public static HashMap<Long, Long> matchplayerperYear() {
        HashMap<Long, Long> map = new HashMap<>();
        for (Long matchId : matchDataStore.keySet()) {
            Matchmodel m = matchDataStore.get(matchId);
            map.put(m.getSeason(), map.getOrDefault(m.getSeason(), 0L) + 1);
        }
        return map;
    }

    public static HashMap<String, Long> matchwonperYear() {
        HashMap<String, Long> map = new HashMap<>();
        for (Long matchId : matchDataStore.keySet()) {
            Matchmodel m = matchDataStore.get(matchId);
            map.put(m.getWinner(), map.getOrDefault(m.getWinner(), 0L) + 1);
        }
        return map;
    }

    public static HashMap<String, Long> extrarungivenperteamperYear(Long year) {
        HashMap<String, Long> map = new HashMap<>();
        for (Long id : matchDataStore.keySet()) {
            if (matchDataStore.get(id).getSeason().equals(year)) {
                for (Deliverymodel d : deliveryModelArrayList) {
                    if (id.equals(d.getMatchId())) {
                        String teamName = d.getBowlingTeam();
                        Long run = d.getWideRuns() + d.getByeRuns() + d.getLegbyeRuns() + d.getNoballRuns() + (long)d.getPenaltyRuns();
                        map.put(teamName, map.getOrDefault(teamName, 0L) + run);
                    }
                }
            }
        }
        return map;
    }

//    public static PriorityQueue<Pair> geteconomical(Long year) {
//        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(a.val, b.val));
//        HashMap<String, Count> map = new HashMap<>();
//        for (Long id : matchDataStore.keySet()) {
//            Matchmodel matchData = matchDataStore.get(id);
//            Long session = matchData.getSeason();
//            if (year.equals(session)) {
//                for (int i = 0; i < deliveryModelArrayList.size(); i++) {
//                    Deliverymodel d = deliveryModelArrayList.get(i);
//                    Long matchId = d.getMatchId();
//                    if (id.equals(matchId)) {
//                        long runs = d.getTotalRuns() - d.getByeRuns() - d.getLegbyeRuns();
//                        String bowler = d.getBowler();
//                        if (!map.containsKey(bowler)) {
//                            map.put(bowler, new Count(0L, 0L));
//                        }
//                        Count c = map.get(bowler);
//                        c.total_run += runs;
//                        if (d.getWideRuns() == 0 && d.getNoballRuns() == 0) {
//                            c.total_bowl += 1;
//                        }
//                    }
//                }
//            }
//        }
//        for (String key : map.keySet()) {
//            Count c = map.get(key);
//            Long run = c.total_run;
//            Double bowl = c.total_bowl / 6.0;
//            if (c.total_bowl > 0) {
//                Double economy = run / bowl;
//                pq.add(new Pair(key, economy));
//            }
//        }
//        return pq;
//    }

    public static void main(String[] args) {
        String matchFilePath = "D:\\IPL Dataset\\matches.csv";
        String deliveryFilePath = "D:\\IPL Dataset\\deliveries.csv";

        loadMatchData(matchFilePath);
        loadDeliveryData(deliveryFilePath);

//        Map<String, Long> extrarunperYear = extrarungivenperteamperYear(2016L);
//        for (String team : extrarunperYear.keySet()) {
//            System.out.println(team + " " + extrarunperYear.get(team));
//        }

//       // PriorityQueue<Pair> bowlerEconomy = main.geteconomical(2016L);
//        System.out.println(bowlerEconomy.peek().name + " " + bowlerEconomy.peek().val);


        HashMap<Long,HashMap<String,HashMap<String,Count>>> geteconomicalbowlerbyTeam=main.getEconomicalbyteambyvenuebyYear();

        for(Long year:geteconomicalbowlerbyTeam.keySet())
        {

            HashMap<String,HashMap<String,Count>> venue=geteconomicalbowlerbyTeam.get(year);
            for(String venueList: venue.keySet())
            {
                HashMap<String,Count> bowlerList=venue.get(venueList);
              //  PriorityQueue<Count> economicalBowler=new PriorityQueue<>((a,b)->Double.compare(a.total_bowl,b.total_bowl));
                String bowlerName="";
                Double min=Double.MAX_VALUE;
                for(String bowlers:bowlerList.keySet())
                {
                    Count curr=bowlerList.get(bowlers);
                    Long run=curr.total_run;
                    Double total_Bowl=curr.total_bowl/6.0;
                    Double calEconomy=0.0;
                    Count c=null;
                    if(total_Bowl>0)
                    {
                        calEconomy=run/total_Bowl;
                    }

                    if(calEconomy>0 && min>calEconomy)
                    {
                        min=calEconomy;
                        bowlerName=bowlers;
                    }
                }
                System.out.println("Year "+year+" Venue "+venueList+" Bowler Name "+ bowlerName+" economy "+ min);

            }
            System.out.println();

        }
    }
}

class Pair {
    String name;
    Double val;

    public Pair(String name, Double val) {
        this.name = name;
        this.val = val;
    }
}

class Count {
    Long total_run;
    Long total_bowl;
   // String name;

    public Count( Long total_run, Long total_bowl) {
       //this.name=name;
        this.total_bowl = total_bowl;
        this.total_run = total_run;
    }
}
