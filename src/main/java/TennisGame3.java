
public class TennisGame3 implements TennisGame {
    
    private int scorePlayer2;
    private int scorePlayer1;
    private final String player1Name;
    private final String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score;
        String score1 = validateScorePlayersFirstCase();
        String score11 = validateScorePlayersSecondCase(score1);
        if (score11 != null) return score11;
        score = scorePlayer1 > scorePlayer2 ? player1Name : player2Name;
        return getFinalMessageScoresEqual(score);
    }

    private String validateScorePlayersSecondCase(String score1) {
        if (score1 != null) return score1;
        if (scorePlayer1 == scorePlayer2)
            return "Deuce";
        return null;
    }

    private String validateScorePlayersFirstCase() {
        String score;
        if (validateScoreLessFourAndSumSix()) {
            String[] arrayScoreMessages = {"Love", "Fifteen", "Thirty", "Forty"};
            score = arrayScoreMessages[scorePlayer1];
            return getFinalMessage(score, arrayScoreMessages);
        }
        return null;
    }

    private String getFinalMessageScoresEqual(String score) {
        if(Math.pow((scorePlayer1 - scorePlayer2),2) == 1) {
            return "Advantage " + score;
        }
        return  "Win for " + score;
    }

    private String getFinalMessage(String score, String[] arrayScoreMessages) {
        if(scorePlayer1 == scorePlayer2){
            return score + "-All";
        }
        return score + "-" + arrayScoreMessages[scorePlayer2];
    }

    private boolean validateScoreLessFourAndSumSix() {
        return scorePlayer1 < 4 && scorePlayer2 < 4 && !(scorePlayer1 + scorePlayer2 == 6);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            this.scorePlayer1 += 1;
        else
            this.scorePlayer2 += 1;
    }

}
