package score;

public class TennisScore {
    private int scorePlayer2;
    private int scorePlayer1;


    public TennisScore() {
        this.scorePlayer1 = 0;
        this.scorePlayer2 = 0;
    }

    public void addPointPlayer1() {
        this.scorePlayer1++;
    }

    public void addPointPlayer2() {
        this.scorePlayer2++;
    }

    public boolean isEvenGame() {
        return scorePlayer1 == scorePlayer2;
    }

    public void getMessageScoreEqual(StringBuilder score) {
        switch (scorePlayer1)
        {
            case 0:
                score.append("Love-All");
                break;
            case 1:
                score.append("Fifteen-All");
                break;
            case 2:
                score.append("Thirty-All");
                break;
            default:
                score.append("Deuce");
                break;
        }
    }

    public boolean isScoreEqualOrGreaterThanFour() {
        return this.scorePlayer1 >=4 || this.scorePlayer2 >=4;
    }

    public void getMessageScoreGreaterFour(StringBuilder score, String player1Name, String player2Name) {
        int minusResult = scorePlayer1 - scorePlayer2;
        if (scoreDiffEqual1(score, player1Name, minusResult)) return;
        if (scoreDiffEqualM1(score, player2Name, minusResult)) return;
        if (scoreDiffEqualOrHigger2(score, player1Name, minusResult)) return;
        score.append("Win for " + player2Name);
    }

    private boolean scoreDiffEqualOrHigger2(StringBuilder score, String player1Name, int minusResult) {
        if (minusResult>=2) {
            score.append("Win for " + player1Name);
            return true;
        }
        return false;
    }

    private boolean scoreDiffEqualM1(StringBuilder score, String player2Name, int minusResult) {
        if (minusResult ==-1) {
            score.append("Advantage " + player2Name);
            return true;
        }
        return false;
    }

    private boolean scoreDiffEqual1(StringBuilder score, String player1Name, int minusResult) {
        if (minusResult==1) {
            score.append("Advantage " + player1Name);
            return true;
        }
        return false;
    }

    public void getDefaultMessage(StringBuilder score) {
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = scorePlayer1;
            else {
                score.append("-");
                tempScore = scorePlayer2;}
            getDefaultMessage(score, tempScore);
        }
    }

    private void getDefaultMessage(StringBuilder score, int tempScore) {
        switch(tempScore)
        {
            case 0:
                score.append("Love");
                break;
            case 1:
                score.append("Fifteen");
                break;
            case 2:
                score.append("Thirty");
                break;
            default:
                score.append("Forty");
                break;
        }
    }
}
