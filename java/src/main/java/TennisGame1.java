import java.util.Objects;

public class TennisGame1 implements TennisGame {
    
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private final String player1Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, player1Name))
            scorePlayer1 += 1;
        else
            scorePlayer2 += 1;
    }

    public String getScore() {
        if (scorePlayer1 == scorePlayer2)
        {
            return getEqualScoreText();
        }
        else if (scorePlayer1 >=4 || scorePlayer2 >=4)
        {
            return getWinner();
        }
        else
        {
            String score = getTextScore(scorePlayer1);
            score +="-";
            score += getTextScore(scorePlayer2);
            return score;

        }
    }

    private static String getTextScore(int tempScore) {
        return switch(tempScore)
        {
            case 0->"Love";
            case 1-> "Fifteen";
            case 2 -> "Thirty";
            case 3 ->"Forty";
            default -> throw new IllegalStateException("Unexpected value: " + tempScore);
        };
    }

    private String getWinner() {
        String score;
        int minusResult = scorePlayer1 - scorePlayer2;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private String getEqualScoreText() {
        return switch (scorePlayer1) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }
}
