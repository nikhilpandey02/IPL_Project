package org.example;

public class Player {

   private String name;
    private int totalRun;
    private int totalWicket;

    public void setName(String name)
    {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public int getTotalRun() {
        return totalRun;
    }

    public int getTotalWicket() {
        return totalWicket;
    }

    public void setTotalRun(int totalRun) {
        this.totalRun+= totalRun;
    }

    public void setTotalWicket(int totalWicket) {
        this.totalWicket += totalWicket;
    }
}
