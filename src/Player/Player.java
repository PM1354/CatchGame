package Player;

public class Player {
    private int hitboxesX;
    private final int hitboxesY;
    private final int maxhearts;
    private int score;
    private final int speed;
    private int x;
    private int y;
    private int hearts;
    private final int windowWidth;
    private final int windowHeight;

    public int getHitboxesX() {
        return hitboxesX;
    }

    public int getHitboxesY() {
        return hitboxesY;
    }

    public int getMaxhearts() {
        return maxhearts;
    }

    public int getScore() {
        return score;
    }

    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHearts() {
        return hearts;
    }

    public Player(int height, int width) {
        this.hitboxesY = 40;
        this.hitboxesX = 180;
        this.maxhearts = 5;
        this.score = 0;
        this.hearts = 3;
        this.speed = 6;
        this.x = width / 2;
        this.y = height - 70;
        this.windowWidth = width;
        this.windowHeight = height;
    }

    /**
     * Adds score to the player
     * @param i number of points to add
     */
    public void addScore(int i){
        score +=i;
    }

    /**
     * Subtracts score from the player
     * @param i number of points to subtract
     */
    public void loseScore(int i){score-=i;}

    /**
     * Adds a heart to the player, but only if it doesn't exceed the maximum
     * @param i number of hearts to add
     */
    public void addHearts(int i){
        if (hearts<maxhearts){
            hearts +=i;
        }
    }

    /**
     * Removes one heart from the player if it has at least one
     */
    public void loseHeart(){
        if (hearts>0){
            hearts--;
        }
    }

    /**
     * Checks if the player is alive (has at least one heart)
     * @return true if player is alive, false otherwise
     */
    public boolean isAlive(){
        if(hearts==0){
            return false;
        }
        return true;
    }

    /**
     * Moves the player to the right by speed value, with collision check against right window edge
     */
    public void moveRight(){
        x = x + speed;
        int rightEdge = x + hitboxesX / 2;
        if (rightEdge > windowWidth) {
            x = windowWidth - hitboxesX / 2;
        }
    }

    /**
     * Moves the player to the left by speed value, with collision check against left window edge
     */
    public void moveLeft(){
        x = x - speed;
        int leftEdge = x - hitboxesX / 2;
        if (leftEdge < 0) {
            x = hitboxesX / 2;
        }
    }

    /**
     * Enlarges the player's platform by 10 pixels in width
     */
    public void biggerPlatform(){
        hitboxesX+=10;
    }
}
