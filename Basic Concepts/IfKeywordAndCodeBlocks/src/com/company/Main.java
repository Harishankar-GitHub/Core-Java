package com.company;

public class Main {

    public static void main(String[] args) {

        int score1 = calculateScore(true, 800, 5, 100);
        System.out.println(score1);
        int score2 = calculateScore(true, 10000, 8, 200);
        System.out.println(score2);

        int highScorePosition = calculateHighScorePosition(1000);
        displayHighScorePosition("Harish", highScorePosition);

        highScorePosition = calculateHighScorePosition(900);
        displayHighScorePosition("Achu", highScorePosition);

        highScorePosition = calculateHighScorePosition(400);
        displayHighScorePosition("Jack", highScorePosition);

        highScorePosition = calculateHighScorePosition(500);
        displayHighScorePosition("Jill", highScorePosition);

    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus)
    {
        if (gameOver)
        {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 2000;
            return finalScore;
        }
        return -1;
    }

    public static void displayHighScorePosition(String name, int position)
    {
        System.out.println(name + " managed to get into position " + position + " on the high score table");
    }

    public static int calculateHighScorePosition(int score)
    {
        int position = 4;
        if (score >= 1000)
            position = 1;
        else if (score >= 500)
            position = 2;
        else if (score >= 100)
            position = 3;

        return position;
    }
}