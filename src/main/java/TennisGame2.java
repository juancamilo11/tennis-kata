
public class TennisGame2 implements TennisGame {
    private int player1Score = 0;
    private int player2Score = 0;
    
    private String player1Response = "";
    private String player2Response = "";
    private final String player1Name;
    private final String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        score = getMessageLowerFourEqual(score);
        if (player1Score == player2Score && player1Score >=3) {
            score = "Deuce";
        }

        score = getMessageByScore(score);
        return score;
    }

    private String getMessageByScore(String score) {
        score = getMessagePlayer2EqualCero(score);
        score = getMessagePlayer1EqualCero(score);
        score = getMessagePlayer1GreaterPlayer2LowerFour(score);
        score = getMessagePlayer2GreaterPlayer1LowerFour(score);
        score = getMessagePlayerOtherConditions(score);
        return score;
    }

    private String getMessagePlayerOtherConditions(String score) {
        score = getMessageAdventageOrWinPlayer1(score);
        score = getMessageAdventageOrWinPlayer2(score);
        return score;
    }

    private String getMessageAdventageOrWinPlayer2(String score) {
        if (player2Score > player1Score && player1Score >= 3) {
            score = "Advantage player2";
        }
        if (player2Score >=4 && player1Score >=0 && (player2Score - player1Score)>=2) {
            score = "Win for player2";
        }
        return score;
    }

    private String getMessageAdventageOrWinPlayer1(String score) {
        if (player1Score > player2Score && player2Score >= 3) {
            score = "Advantage player1";
        }
        if (player1Score >=4 && player2Score >=0 && (player1Score - player2Score)>=2) {
            score = "Win for player1";
        }
        return score;
    }

    private String getMessagePlayer2GreaterPlayer1LowerFour(String score) {
        if (player2Score > player1Score && player2Score < 4) {
            score = pickMessagePlayer2GreaterPlayer1LowerFour();
        }
        return score;
    }

    private String pickMessagePlayer2GreaterPlayer1LowerFour() {
        String score;
        if (player2Score ==2)
            player2Response ="Thirty";
        if (player2Score ==3)
            player2Response ="Forty";
        if (player1Score ==1)
            player1Response ="Fifteen";
        if (player1Score ==2)
            player1Response ="Thirty";
        score = player1Response + "-" + player2Response;
        return score;
    }

    private String getMessagePlayer1GreaterPlayer2LowerFour(String score) {
        if (player1Score > player2Score && player1Score < 4) {
            score = pickMessagePlayer1GreaterPlayer2LowerFour();
        }
        return score;
    }

    private String pickMessagePlayer1GreaterPlayer2LowerFour() {
        String score;
        if (player1Score ==2)
            player1Response ="Thirty";
        if (player1Score ==3)
            player1Response ="Forty";
        if (player2Score ==1)
            player2Response ="Fifteen";
        if (player2Score ==2)
            player2Response ="Thirty";
        score = player1Response + "-" + player2Response;
        return score;
    }

    private String getMessagePlayer1EqualCero(String score) {
        if (player2Score > 0 && player1Score ==0) {
            score = pickMessagePlayer1EqualCero();
        }
        return score;
    }

    private String pickMessagePlayer1EqualCero() {
        String score;
        if (player2Score ==1)
            player2Response = "Fifteen";
        if (player2Score ==2)
            player2Response = "Thirty";
        if (player2Score ==3)
            player2Response = "Forty";
        player1Response = "Love";
        score = player1Response + "-" + player2Response;
        return score;
    }

    private String getMessagePlayer2EqualCero(String score) {
        if (player1Score > 0 && player2Score ==0) {
            score = pickMessagePlayer2EqualCero();
        }
        return score;
    }

    private String pickMessagePlayer2EqualCero() {
        String score;
        if (player1Score ==1)
            player1Response = "Fifteen";
        if (player1Score ==2)
            player1Response = "Thirty";
        if (player1Score ==3)
            player1Response = "Forty";

        player2Response = "Love";
        score = player1Response + "-" + player2Response;
        return score;
    }

    private String getMessageLowerFourEqual(String score) {
        if (player1Score == player2Score && player1Score < 4) {
            score = pickMessageLowerFourEqual(score);
        }
        return score;
    }

    private String pickMessageLowerFourEqual(String score) {
        if (player1Score ==0)
            score = "Love";
        if (player1Score ==1)
            score = "Fifteen";
        if (player1Score ==2)
            score = "Thirty";
        score += "-All";
        return score;
    }
    
    public void addAPointToPlayer1(){
        player1Score++;
    }
    
    public void addAPointToPlayer2(){
        player2Score++;
    }

    public void wonPoint(String player) {
        if (player.equals(player1Name))
            addAPointToPlayer1();
        if(player.equals(player2Name))
            addAPointToPlayer2();
    }
}