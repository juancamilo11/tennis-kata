import score.TennisScore;

public class TennisGame1 implements TennisGame {
    
   private TennisScore tennisScore;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.tennisScore = new TennisScore();
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            scorePlayer1 += 1;
        else
            scorePlayer2 += 1;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        if (scorePlayer1 == scorePlayer2) {
            getMessageScoreEqual(score);
            return score.toString();
        }
        if (scorePlayer1 >=4 || scorePlayer2 >=4) {
            getMessageScoreGreaterFour(score);
            return score.toString();
        }
        getDefaultMessage(score);
        return score.toString();
    }

    private void getDefaultMessage(StringBuilder score) {
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

    private void getMessageScoreGreaterFour(StringBuilder score) {
        int minusResult = scorePlayer1 - scorePlayer2;
        if (minusResult==1) {
            score.append("Advantage " + player1Name);
            return;
        }
        if (minusResult ==-1) {
            score.append("Advantage " + player2Name);
            return;
        }
        if (minusResult>=2) {
            score.append("Win for " + player1Name);
            return;
        }
        score.append("Win for " + player2Name);
    }

    private void getMessageScoreEqual(StringBuilder score) {
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
}
