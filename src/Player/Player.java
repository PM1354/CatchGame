package Player;

public class Player {
    private int hitboxesX;
    private int hitboxesY;
    private int hearts;
    private int score;


    public int getHitboxesX() {
        return hitboxesX;
    }

    public void setHitboxesX(int hitboxesX) {
        this.hitboxesX = hitboxesX;
    }

    public int getHitboxesY() {
        return hitboxesY;
    }

    public void setHitboxesY(int hitboxesY) {
        this.hitboxesY = hitboxesY;
    }

    public int getHearts() {
        return hearts;
    }

    public void setHearts(int hearts) {
        this.hearts = hearts;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Player(int hitboxesY, int hitboxesX) {
        this.hitboxesY = hitboxesY;
        this.hitboxesX = hitboxesX;
        this.hearts = 3;
        this.score = 0;
    }
}
