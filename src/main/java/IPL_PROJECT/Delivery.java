package IPL_PROJECT;
//
public class Delivery {

    private int deliveryId;
    private int inning;
    private int wideRuns;
    private int byeRuns;
    private int legbyeRuns;
    private int noBallRuns;
    private int penaltyRuns;
    private int batsmanRun;
    private int extraRun;
    private int totalRuns;
    private int over;
    private int ball;
    private String battingTeam;
    private String bowlingTeam;
    private String batsman;
    private String nonStriker;
    private String bowler;
    private String playerDismissed;
    private String dismissalKind;
    private String fielder;
    private boolean isSuperOver;
    public Delivery() { }
    public int getDeliveryId() { return deliveryId; }
    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId; }

    public int getInning() { return inning; }
    public void setInning(int inning) { this.inning = inning; }
    public String getBattingTeam() { return battingTeam; }
    public void setBattingTeam(String battingTeam) { this.battingTeam = battingTeam; }
    public String getBowlingTeam() { return bowlingTeam; }
    public void setBowlingTeam(String bowlingTeam) { this.bowlingTeam = bowlingTeam; }
    public int getOver() { return over; }
    public void setOver(int over) { this.over = over; }
    public int getBall() { return ball; }
    public void setBall(int ball) { this.ball = ball; }

    public String getBatsman() { return batsman; }
    public void setBatsman(String batsman) { this.batsman = batsman; }

    public String getNonStriker() { return nonStriker; }
    public void setNonStriker(String nonStriker) { this.nonStriker = nonStriker; }

    public String getBowler() { return bowler; }
    public void setBowler(String bowler) { this.bowler = bowler; }

    public boolean isSuperOver() { return isSuperOver; }
    public void setSuperOver(boolean superOver) { isSuperOver = superOver; }

    public int getWideRuns() { return wideRuns; }
    public void setWideRuns(int wideRuns) { this.wideRuns = wideRuns; }

    public int getByeRuns() { return byeRuns; }
    public void setByeRuns(int byeRuns) { this.byeRuns = byeRuns; }

    public int getLegbyeRuns() { return legbyeRuns; }
    public void setLegbyeRuns(int legbyeRuns) { this.legbyeRuns = legbyeRuns; }

    public int getNoBallRuns() { return noBallRuns; }
    public void setNoBallRuns(int noBallRuns) { this.noBallRuns = noBallRuns; }

    public int getPenaltyRuns() { return penaltyRuns; }
    public void setPenaltyRuns(int penaltyRuns) { this.penaltyRuns = penaltyRuns; }

    public int getBatsmanRun() { return batsmanRun; }
    public void setBatsmanRun(int batsmanRun) { this.batsmanRun = batsmanRun; }

    public int getExtraRun() { return extraRun; }
    public void setExtraRun(int extraRun) { this.extraRun = extraRun; }

    public int getTotalRuns() { return totalRuns; }
    public void setTotalRuns(int totalRuns) { this.totalRuns = totalRuns; }

    public String getPlayerDismissed() { return playerDismissed; }
    public void setPlayerDismissed(String playerDismissed) { this.playerDismissed = playerDismissed; }

    public String getDismissalKind() { return dismissalKind; }
    public void setDismissalKind(String dismissalKind) { this.dismissalKind = dismissalKind; }

    public String getFielder() { return fielder; }
    public void setFielder(String fielder) { this.fielder = fielder; }
}

