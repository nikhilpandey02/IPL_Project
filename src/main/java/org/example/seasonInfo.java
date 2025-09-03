package org.example;

public class seasonInfo {

    Long totalMatch=0L;
    String winner;
    String manoftheMatch;
    //here mostruninyear should have player name too so thinking of make pair or letsee.
    String mostruninYear;
    String mosteconomicalbowler;

    Long numberofmatchperYear;


    public Long getTotalMatch() {
        return totalMatch;
    }

    public void setTotalMatch() {

        this.totalMatch += 1;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getManoftheMatch() {
        return manoftheMatch;
    }

    public void setManoftheMatch(String manoftheMatch) {
        this.manoftheMatch = manoftheMatch;
    }

    public String getMostruninYear() {
        return mostruninYear;
    }

    public void setMostruninYear(String mostruninYear) {
        this.mostruninYear = mostruninYear;
    }

    public String getMosteconomicalbowler() {
        return mosteconomicalbowler;
    }

    public void setMosteconomicalbowler(String mosteconomicalbowler) {
        this.mosteconomicalbowler = mosteconomicalbowler;
    }

    public Long getNumberofmatchperYear() {
        return numberofmatchperYear;
    }

}
