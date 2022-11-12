package org.sg.studentquizscores.dto;

public class Score {
    int score;

    public Score(int score) { this.score = score; }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return "Score{" +
                "score=" + score +
                '}';
    }
}
