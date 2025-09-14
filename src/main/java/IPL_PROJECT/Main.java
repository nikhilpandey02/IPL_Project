package IPL_PROJECT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static final int MATCH_ID = 0;
    public static final int MATCH_SEASON = 1;
    public static final int MATCH_CITY = 2;
    public static final int MATCH_DATE = 3;
    public static final int MATCH_TEAM1 = 4;
    public static final int MATCH_TEAM2 = 5;
    public static final int MATCH_TOSS_WINNER = 6;
    public static final int MATCH_TOSS_DECISION = 7;
    public static final int MATCH_RESULT = 8;
    public static final int MATCH_DL_APPLIED = 9;
    public static final int MATCH_WINNER = 10;
    public static final int MATCH_WIN_BY_RUN = 11;
    public static final int MATCH_WIN_BY_WICKET = 12;
    public static final int MATCH_PLAYER_OF_MATCH = 13;
    public static final int MATCH_VENUE = 14;
    public static final int MATCH_UMPIRE_1 = 15;
    public static final int MATCH_UMPIRE_2 = 16;
    public static final int MATCH_UMPIRE_3 = 17;

    public static final int DELIVERY_ID = 0;
    public static final int DELIVERY_INNING = 1;
    public static final int DELIVERY_BATTING_TEAM = 2;
    public static final int DELIVERY_BOWLING_TEAM = 3;
    public static final int DELIVERY_OVER = 4;
    public static final int DELIVERY_BALL = 5;
    public static final int DELIVERY_BATSMAN = 6;
    public static final int DELIVERY_NON_STRIKER = 7;
    public static final int DELIVERY_BOWLER = 8;
    public static final int DELIVERY_IS_SUPER_OVER = 9;
    public static final int DELIVERY_WIDE_RUNS = 10;
    public static final int DELIVERY_BYE_RUNS = 11;
    public static final int DELIVERY_LEG_BY_RUNS = 12;
    public static final int DELIVERY_NO_BALL_RUNS = 13;
    public static final int DELIVERY_PENALTY_RUNS = 14;
    public static final int DELIVERY_BATSMAN_RUN = 15;
    public static final int DELIVERY_EXTRA_RUN = 16;
    public static final int DELIVERY_TOTAL_RUNS = 17;
    public static final int DELIVERY_PLAYER_DISMISSED = 18;
    public static final int DELIVERY_DISMISSAL_KIND = 19;
    public static final int DELIVERY_FIELDER = 20;

    public static void main(String[] args) {
        final String matchesFilePath = "./Files/matches.csv";
        final String deliveriesFilePath = "./Files/deliveries.csv";

        List<Match> matches = fetchMatches(matchesFilePath);
        List<Delivery> deliveries = fetchDeliveries(deliveriesFilePath);

        findMatchesCountBySeason(matches);
        findNumberOfWinsByTeam(matches);
        findExtraRunsByTeamInSeason(matches, deliveries, 2016);
        findEconomicalBowlerStatsAgainstTeamBySeasonByVenue(matches, deliveries,"Mumbai Indians");
        findTopEconomicalBowlersForSeason(matches, deliveries, 2013);
        findTopFiveBowlerWithBestEconomyInYear(matches,deliveries,2015);
        findNumberOfMatchesWhereTeamTossWinMatchWinAndTotalWicketsTaken(matches,deliveries);
        findMostWicketTakerBowlerInSeason(matches,deliveries,2013);
        findBatsmanStrikeRateForAllSeason(matches,deliveries,"S Dhawan");
    }

    public static List<Match> fetchMatches(String filePath) {
        List<Match> matches = new ArrayList<>();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-M-d");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", -1);

                Match match = new Match();
                match.setMatchId(Integer.parseInt(data[MATCH_ID]));
                match.setSeason(Integer.parseInt(data[MATCH_SEASON]));
                match.setCity(data[MATCH_CITY]);
                match.setDate(date.parse(data[MATCH_DATE]));
                match.setTeam1(data[MATCH_TEAM1]);
                match.setTeam2(data[MATCH_TEAM2]);
                match.setTossWinner(data[MATCH_TOSS_WINNER]);
                match.setTossDecision(data[MATCH_TOSS_DECISION]);
                match.setResult(data[MATCH_RESULT]);
                match.setDlApplied(Integer.parseInt(data[MATCH_DL_APPLIED]));
                match.setWinner(data[MATCH_WINNER].isEmpty() ? null : data[MATCH_WINNER]);
                match.setWinByRun(data[MATCH_WIN_BY_RUN].isEmpty() ? 0 : Integer.parseInt(data[MATCH_WIN_BY_RUN]));
                match.setWinByWicket(data[MATCH_WIN_BY_WICKET].isEmpty() ? 0 : Integer.parseInt(data[MATCH_WIN_BY_WICKET]));
                match.setPlayerOfTheMatch(data[MATCH_PLAYER_OF_MATCH]);
                match.setVenue(data[MATCH_VENUE]);
                match.setUmpire1(data[MATCH_UMPIRE_1]);
                match.setUmpire2(data[MATCH_UMPIRE_2]);
                match.setUmpire3(data.length > MATCH_UMPIRE_3 ? data[MATCH_UMPIRE_3] : null);

                matches.add(match);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            System.out.println("Error loading matches: " + e.getMessage());
        }
        return matches;
    }

    public static List<Delivery> fetchDeliveries(String filePath) {
        List<Delivery> deliveries = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", -1);
                Delivery delivery = new Delivery();

                delivery.setDeliveryId(Integer.parseInt(data[DELIVERY_ID]));
                delivery.setInning(Integer.parseInt(data[DELIVERY_INNING]));
                delivery.setBattingTeam(data[DELIVERY_BATTING_TEAM]);
                delivery.setBowlingTeam(data[DELIVERY_BOWLING_TEAM]);
                delivery.setOver(Integer.parseInt(data[DELIVERY_OVER]));
                delivery.setBall(Integer.parseInt(data[DELIVERY_BALL]));
                delivery.setBatsman(data[DELIVERY_BATSMAN]);
                delivery.setNonStriker(data[DELIVERY_NON_STRIKER]);
                delivery.setBowler(data[DELIVERY_BOWLER]);
                delivery.setSuperOver(data[DELIVERY_IS_SUPER_OVER].equals("1"));
                delivery.setWideRuns(Integer.parseInt(data[DELIVERY_WIDE_RUNS]));
                delivery.setByeRuns(Integer.parseInt(data[DELIVERY_BYE_RUNS]));
                delivery.setLegbyeRuns(Integer.parseInt(data[DELIVERY_LEG_BY_RUNS]));
                delivery.setNoBallRuns(Integer.parseInt(data[DELIVERY_NO_BALL_RUNS]));
                delivery.setPenaltyRuns(Integer.parseInt(data[DELIVERY_PENALTY_RUNS]));
                delivery.setBatsmanRun(Integer.parseInt(data[DELIVERY_BATSMAN_RUN]));
                delivery.setExtraRun(Integer.parseInt(data[DELIVERY_EXTRA_RUN]));
                delivery.setTotalRuns(Integer.parseInt(data[DELIVERY_TOTAL_RUNS]));
                delivery.setPlayerDismissed(data[DELIVERY_PLAYER_DISMISSED]);
                delivery.setDismissalKind(data[DELIVERY_DISMISSAL_KIND]);
                delivery.setFielder(data[DELIVERY_FIELDER]);

                deliveries.add(delivery);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading deliveries: " + e.getMessage());
        }
        return deliveries;
    }


    public static void findBatsmanStrikeRateForAllSeason(List<Match> matches,List<Delivery> deliveries,
                                                         String playerName)
    {
        BatsmanTotalRunsAndMatchPlayed batsmanNameAndStrikeRate=new BatsmanTotalRunsAndMatchPlayed();
        for(Match match:matches)
        {
            int matchCount=0;
            for(Delivery delivery:deliveries)
            {
                if(match.getMatchId()==delivery.getDeliveryId() && delivery.getBatsman().equals(playerName)
                && delivery.getWideRuns()==0 && delivery.getNoBallRuns()==0)
                {
                    matchCount=1;
                    batsmanNameAndStrikeRate.totalRuns+= delivery.getBatsmanRun();
                    batsmanNameAndStrikeRate.totalBallPlayed+=1;
                }
            }
            if(matchCount!=0)
            {
                batsmanNameAndStrikeRate.totalMatches+=1;
            }
        }

        System.out.println("Batsman Strike Rate All over the season");
        if(batsmanNameAndStrikeRate.totalRuns!=0) {
            double batsmanStrikeRate =(batsmanNameAndStrikeRate.totalRuns*100.0) / (batsmanNameAndStrikeRate.totalBallPlayed);
            System.out.println("Player Name " + playerName + " Match Played " + batsmanNameAndStrikeRate.totalMatches +
                    " Strike Rate " + batsmanStrikeRate);
        }else {
            System.out.println("No data found about "+playerName);
        }

    }

    public static void findMostWicketTakerBowlerInSeason(List<Match> matches,List<Delivery> deliveries,int season)
    {
        Map<String,Integer> bowlerWicketCounts=new HashMap<>();
        String bowlerName=null;
        int mostWicket=0;

        for(Match match:matches)
        {
            int year= match.getSeason();
            if(year==season) {
                for (Delivery delivery : deliveries) {
                    String name= delivery.getBowler();
                    if(delivery.getDeliveryId()== match.getMatchId()
                    && !delivery.getPlayerDismissed().isEmpty())
                    {
                        bowlerWicketCounts.put(name,
                                bowlerWicketCounts.getOrDefault(name,0)+1);
                        int wickets=bowlerWicketCounts.get(name);

                        if(mostWicket<wickets)
                        {
                            bowlerName=name;
                            mostWicket=wickets;
                        }
                    }

                }
            }
        }

        System.out.println("Most Wicket Taken by Bowler in Year ");
        if(bowlerName!=null)
            System.out.println("Bowler Name "+bowlerName+" Wickets "+mostWicket);
        else
            System.out.println("No data Available for " + season);
        System.out.println();
    }

    public static void findNumberOfMatchesWhereTeamTossWinMatchWinAndTotalWicketsTaken(List<Match> matches,
                                                                                List<Delivery> deliveries)
    {
        Map<String,CountWinsAndWickets> numberOfTeamWonTossAndWonTheMatchAndTotalWicket=new HashMap<>();

        for(Match match:matches)
        {
            int matchId=match.getMatchId();
            String tossWinner= match.getTossWinner();
            String matchWinner=match.getWinner();
            if(tossWinner.equals(matchWinner)) {
                int matchWin=0;
                for (Delivery delivery : deliveries) {
                    int deliveryId=delivery.getDeliveryId();
                    String bowlingTeamName=delivery.getBowlingTeam();

                    if(deliveryId==matchId && bowlingTeamName.equals(matchWinner))
                    {
                        matchWin=1;
                        if(!numberOfTeamWonTossAndWonTheMatchAndTotalWicket.containsKey(bowlingTeamName))
                        {
                            numberOfTeamWonTossAndWonTheMatchAndTotalWicket.put(bowlingTeamName,
                                    new CountWinsAndWickets(0,0));
                        }
                        int wicketCount=0;
                        if(delivery.getPlayerDismissed()!=null && !delivery.getPlayerDismissed().isEmpty())
                        {
                            wicketCount=1;
                        }
                        var countOfTotalWinAndTotalWicket=
                                numberOfTeamWonTossAndWonTheMatchAndTotalWicket.get(bowlingTeamName);
                        countOfTotalWinAndTotalWicket.totalWickets+=wicketCount;
                    }
                }
                if(matchWin!=0)
                {
                    var countOfTotalWinAndTotalWicket=
                            numberOfTeamWonTossAndWonTheMatchAndTotalWicket.get(tossWinner);
                    countOfTotalWinAndTotalWicket.totalWins+=1;

                }
            }
        }
        System.out.println("Total Match Win and Toss Win With Wickets");
        for(String teamName:numberOfTeamWonTossAndWonTheMatchAndTotalWicket.keySet())
        {
            CountWinsAndWickets countWinsAndWickets=numberOfTeamWonTossAndWonTheMatchAndTotalWicket.get(teamName);
            int totalWins=countWinsAndWickets.totalWins;
            int totalWicketsTaken=countWinsAndWickets.totalWickets;
            System.out.println("Team Name "+teamName +" Total Wins "+totalWins+" totalWicket "+totalWicketsTaken);
        }
        System.out.println();

    }

    public static void findTopFiveBowlerWithBestEconomyInYear(List<Match> matches,
                                                              List<Delivery> deliveries,int season)
    {

        Map<String,Count> bowlerNameAndEconomyPerSeason=new HashMap<>();
        for(Match match:matches)
        {
            int matchId=match.getMatchId();
            int year=match.getSeason();
            for(Delivery delivery:deliveries)
            {
                int deliveryId=delivery.getDeliveryId();
                if(matchId==deliveryId && year==season)
                {
                    String bowlerName=delivery.getBowler();
                    int runs=delivery.getBatsmanRun();
                    if(!bowlerNameAndEconomyPerSeason.containsKey(bowlerName))
                        bowlerNameAndEconomyPerSeason.put(bowlerName,new Count(0,0));
                    Count bowlerEconomy=bowlerNameAndEconomyPerSeason.get(bowlerName);
                    bowlerEconomy.totalRuns+=runs;

                    if(delivery.getWideRuns()==0 && delivery.getNoBallRuns()==0)
                        bowlerEconomy.totalBalls+=1;

                }
            }
        }
        Queue<BowlerNameAndEconomy> EconomicalBowler=new PriorityQueue<>(Comparator.comparingDouble(a->a.economy));
        for(String bowlerName:bowlerNameAndEconomyPerSeason.keySet())
        {
            double totalBallBowled=bowlerNameAndEconomyPerSeason.get(bowlerName).totalBalls/6.0;
            long runs=bowlerNameAndEconomyPerSeason.get(bowlerName).totalRuns;
            if(totalBallBowled>0)
                EconomicalBowler.add(new BowlerNameAndEconomy(bowlerName,runs/totalBallBowled));
        }

        System.out.println("Top 5 Economical Bowler in "+season);
        while(!EconomicalBowler.isEmpty())
        {
            BowlerNameAndEconomy data=EconomicalBowler.poll();
            System.out.println("BowlerName "+data.bowlerName+" bowlerEconomy "+ data.economy);
        }
        System.out.println();

    }

    public static void findMatchesCountBySeason(List<Match> matches) {
        Map<Integer, Integer> matchesBySeason = new HashMap<>();
        for (Match match : matches) {
            matchesBySeason.put(match.getSeason(),
                    matchesBySeason.getOrDefault(match.getSeason(), 0) + 1);
        }
        System.out.println("Matches per Season:");
        for (Map.Entry<Integer, Integer> entry : matchesBySeason.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }

    public static void findNumberOfWinsByTeam(List<Match> matches) {
        Map<String, Integer> winsByTeam = new HashMap<>();
        for (Match match : matches) {
            if (match.getWinner() != null && !match.getWinner().isEmpty()) {
                winsByTeam.put(match.getWinner(),
                        winsByTeam.getOrDefault(match.getWinner(), 0) + 1);
            }
        }
        System.out.println("Matches won by teams:");
        for (Map.Entry<String, Integer> entry : winsByTeam.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }

    public static void findExtraRunsByTeamInSeason(List<Match> matches, List<Delivery> deliveries, int season) {
        Map<String, Integer> extraRunsByTeam = new HashMap<>();
        for (Match match : matches) {
            if (match.getSeason() == season) {
                for (Delivery delivery : deliveries) {
                    if (delivery.getDeliveryId() == match.getMatchId()) {
                        String bowlingTeam = delivery.getBowlingTeam();
                        int extraRuns = delivery.getWideRuns() + delivery.getByeRuns() +
                                delivery.getLegbyeRuns() + delivery.getNoBallRuns() + delivery.getPenaltyRuns();
                        extraRunsByTeam.put(bowlingTeam,
                                extraRunsByTeam.getOrDefault(bowlingTeam, 0) + extraRuns);
                    }
                }
            }
        }
        System.out.println("Extra runs conceded by team in " + season + ":");
        for (Map.Entry<String, Integer> entry : extraRunsByTeam.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }

    public static void findEconomicalBowlerStatsAgainstTeamBySeasonByVenue(List<Match> matches,
                                                                          List<Delivery> deliveries,String teamName) {
        Map<Integer, Map<String, Map<String, Count>>> statsBySeasonVenue = new HashMap<>();
        for (Match match : matches) {
            String team1 = match.getTeam1();
            String team2 = match.getTeam2();
            int season = match.getSeason();
            String venue = match.getCity();

            if (team1.equals(teamName) || team2.equals(teamName)) {
                for (Delivery delivery : deliveries) {
                    if (delivery.getDeliveryId() == match.getMatchId()
                            && !delivery.getBowlingTeam().equals("Mumbai Indians")) {

                        String bowler = delivery.getBowler();
                        long runs = delivery.getTotalRuns() - delivery.getByeRuns() - delivery.getWideRuns();

                        statsBySeasonVenue
                                .computeIfAbsent(season, k -> new HashMap<>())
                                .computeIfAbsent(venue, k -> new HashMap<>())
                                .computeIfAbsent(bowler, k -> new Count(0L, 0L));

                        Count bowlerStats = statsBySeasonVenue.get(season).get(venue).get(bowler);
                        bowlerStats.totalRuns += runs;
                        if (delivery.getWideRuns() == 0 && delivery.getNoBallRuns() == 0) {
                            bowlerStats.totalBalls += 1;
                        }
                    }
                }
            }
        }

        System.out.println("Economical bowlers against Mumbai Indians by Venue/city and Season:");
        for (Map.Entry<Integer, Map<String, Map<String, Count>>> seasonEntry : statsBySeasonVenue.entrySet()) {
            int season = seasonEntry.getKey();
            Map<String, Map<String, Count>> venues = seasonEntry.getValue();

            for (Map.Entry<String, Map<String, Count>> venueEntry : venues.entrySet()) {
                String venue = venueEntry.getKey();
                Map<String, Count> bowlerStats = venueEntry.getValue();
                String bestBowler = "";
                double bestEconomy = Double.MAX_VALUE;

                for (Map.Entry<String, Count> bowlerEntry : bowlerStats.entrySet()) {
                    String bowler = bowlerEntry.getKey();
                    Count stats = bowlerEntry.getValue();
                    double overs = stats.totalBalls / 6.0;
                    double economy = overs > 0 ? (double) stats.totalRuns / overs : Double.MAX_VALUE;

                    if (economy < bestEconomy) {
                        bestEconomy = economy;
                        bestBowler = bowler;
                    }
                }
                System.out.println("Season " + season + ", Venue " + venue
                        + ", Best Bowler: " + bestBowler
                        + " Economy: " + String.format("%.2f", bestEconomy));
            }
        }
        System.out.println();
    }

    public static void findTopEconomicalBowlersForSeason(List<Match> matches, List<Delivery> deliveries, int season) {
        Map<String, Count> bowlerStats = new HashMap<>();
        for (Match match : matches) {
            if (match.getSeason() == season) {
                for (Delivery delivery : deliveries) {
                    if (delivery.getDeliveryId() == match.getMatchId()) {
                        String bowler = delivery.getBowler();
                        long runs = delivery.getTotalRuns() - delivery.getByeRuns() - delivery.getLegbyeRuns();
                        bowlerStats.putIfAbsent(bowler, new Count(0L, 0L));
                        Count count = bowlerStats.get(bowler);
                        count.totalRuns += runs;
                        if (delivery.getWideRuns() == 0 && delivery.getNoBallRuns() == 0) {
                            count.totalBalls += 1;
                        }
                    }
                }
            }
        }

        PriorityQueue<BowlerNameAndEconomy> bowlerNameSortBasedOnEconomy =
                new PriorityQueue<>(Comparator.comparingDouble(a -> a.economy));
        for (Map.Entry<String, Count> entry : bowlerStats.entrySet()) {
            Count stats = entry.getValue();
            if (stats.totalBalls > 0) {
                double overs = stats.totalBalls / 6.0;
                double economy = (double) stats.totalRuns / overs;
                bowlerNameSortBasedOnEconomy.add(new BowlerNameAndEconomy(
                        entry.getKey(), economy));
            }
        }

        System.out.println("Top 10 Economical Bowlers in " + season + ":");
        int count = 0;
        while (!bowlerNameSortBasedOnEconomy.isEmpty() && count < 10) {
            BowlerNameAndEconomy bowlerEco = bowlerNameSortBasedOnEconomy.poll();
            System.out.println(bowlerEco.bowlerName + " : " + String.format("%.2f", bowlerEco.economy));
            count++;
        }
        System.out.println();
    }
}

