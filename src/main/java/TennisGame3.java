
public class TennisGame3 implements TennisGame {
    
    private int scorePlayer2;
    private int scorePlayer1;
    private String p1N;
    private String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        String score;
        if (scorePlayer1 < 4 && scorePlayer2 < 4 && !(scorePlayer1 + scorePlayer2 == 6)) {
            String[] arrayScoreMessages = {"Love", "Fifteen", "Thirty", "Forty"};
            score = arrayScoreMessages[scorePlayer1];
            return (scorePlayer1 == scorePlayer2) ? score + "-All" : score + "-" + arrayScoreMessages[scorePlayer2];
        }
        if (scorePlayer1 == scorePlayer2)
            return "Deuce";
        score = scorePlayer1 > scorePlayer2 ? p1N : p2N;
        return ((scorePlayer1 - scorePlayer2)*(scorePlayer1 - scorePlayer2) == 1) ? "Advantage " + score : "Win for " + score;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            this.scorePlayer1 += 1;
        else
            this.scorePlayer2 += 1;
    }

}
