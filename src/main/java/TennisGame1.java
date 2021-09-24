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
            this.tennisScore.addPointPlayer1();
        else
            this.tennisScore.addPointPlayer2();
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        if (this.tennisScore.isEvenGame()) {
            this.tennisScore.getMessageScoreEqual(score);
            return score.toString();
        }
        if (this.tennisScore.isScoreEqualOrGreaterThanFour()) {
            this.tennisScore.getMessageScoreGreaterFour(score, this.player1Name,this.player2Name);
            return score.toString();
        }
        this.tennisScore.getDefaultMessage(score);
        return score.toString();
    }
}
