package IPL_PROJECT;

import java.util.Date;

public class Match {

    private int matchId;
    private int season;
    private int dlApplied;
    private int winByRun;
    private int winByWicket;
    private String playerOfTheMatch;
    private String venue;
    private String umpire1;
    private String umpire2;
    private String umpire3;
    private String city;
    private String team1;
    private String team2;
    private String tossWinner;
    private String tossDecision;
    private String result;
    private String winner;
    private Date date;

    public Match() { }
    public int getMatchId() { return matchId; }
    public void setMatchId(int matchId) { this.matchId = matchId; }
    public int getSeason() { return season; }
    public void setSeason(int season) { this.season = season; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public String getTeam1() { return team1; }
    public void setTeam1(String team1) { this.team1 = team1; }
    public String getTeam2() { return team2; }
    public void setTeam2(String team2) { this.team2 = team2; }
    public String getTossWinner() { return tossWinner; }
    public void setTossWinner(String tossWinner) { this.tossWinner = tossWinner; }
    public String getTossDecision() { return tossDecision; }
    public void setTossDecision(String tossDecision) { this.tossDecision = tossDecision; }
    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
    public int getDlApplied() { return dlApplied; }
    public void setDlApplied(int dlApplied) { this.dlApplied = dlApplied; }
    public String getWinner() { return winner; }
    public void setWinner(String winner) { this.winner = winner; }
    public int getWinByRun() { return winByRun; }
    public void setWinByRun(int winByRun) { this.winByRun = winByRun; }
    public int getWinByWicket() { return winByWicket; }
    public void setWinByWicket(int winByWicket) { this.winByWicket = winByWicket; }
    public String getPlayerOfTheMatch() { return playerOfTheMatch; }
    public void setPlayerOfTheMatch(String playerOfTheMatch) { this.playerOfTheMatch = playerOfTheMatch; }
    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }
    public String getUmpire1() { return umpire1; }
    public void setUmpire1(String umpire1) { this.umpire1 = umpire1; }
    public String getUmpire2() { return umpire2; }
    public void setUmpire2(String umpire2) { this.umpire2 = umpire2; }
    public String getUmpire3() { return umpire3; }
    public void setUmpire3(String umpire3) { this.umpire3 = umpire3; }
}

