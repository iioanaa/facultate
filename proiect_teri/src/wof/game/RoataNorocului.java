package wof.game;

public class RoataNorocului {

    private static final int intoarceri_initiale = 7; // nr de rotiri in joc
    private int scor, intoarceriRamase;

    public int getScore() {
        return scor;
    }
    public int getTurnsLeft() {
        return intoarceriRamase;
    }
    public void addScore(int score) {
        this.scor += score;
    }
    public void resetScore() {
        scor = 0;
    }

    public void resetValues() {
        intoarceriRamase = intoarceri_initiale;
        scor = 0;
    }

    public void subtractTurn() {
        intoarceriRamase--;
    }
}