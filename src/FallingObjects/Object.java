package FallingObjects;

public abstract class Object {
    private int a;
    private int x;
    private int y;
    private int speed;
    private boolean catched;

    public Object(int x, int y, int a,int speed,boolean catched) {
        this.a=a;
        this.x=x;
        this.y=y;
        this.speed=speed;
        this.catched = false;
    }

    public void falling(){
        y+=speed;
    }

    private void playerCatcheObject(){
        catched=true;
    }

    public int getA() {
        return a;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isCatched() {
        return catched;
    }
}
