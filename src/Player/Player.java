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
        this.hitboxesY = 16;
        this.hitboxesX = 80;
        this.maxhearts = 5;
        this.score = 0;
        this.hearts = 3;
        this.speed =6;
        this.x =width/2;
        this.y= height-40;
    }

    public void addScore(int i){
        score +=i;
    }

    public void looseScore(int i){score+=i;}

    public void addHears(int i){
        if (hearts<maxhearts){
            hearts +=i;
        }
    }

    public void looseHeart(){
        if (hearts>0){
            hearts--;
        }
    }

    public boolean isAlive(){
        if(hearts==0){
            return false;
        }
        return true;
    }

    public void moveRight(){
        x = x+speed;
    }

    public void moveLeft(){
        x = x-speed;
    }

    public void biggerPlatform(){
        hitboxesX+=10;
    }
}
