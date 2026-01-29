public class DisplayScore {

    // Method 1: displays the player's name and thier position
    public static void displayHighScorePosition(String playerName, int position) {
        System.out.println(playerName + " managed to get into position " + position + " on the high score list");
    }

    // Method 2: calculates the high score for position
    public static int calculateHighScorePosition(int playerScore) {

        if (playerScore >= 1000) {
            return 1;
        } else if (playerScore >= 500) {
            return 2;
        } else if (playerScore >= 100) {
            return 3;
        } else {
            return 4;
        }
    }

    public static void main(String[] args) {

        displayHighScorePosition("Paul", calculateHighScorePosition(1500));
        displayHighScorePosition("Adam", calculateHighScorePosition(1000));
        displayHighScorePosition("Mayah", calculateHighScorePosition(500));
        displayHighScorePosition("Sam", calculateHighScorePosition(100));
        displayHighScorePosition("Ezekiel", calculateHighScorePosition(25));
    }
}
