package FallingObjects;

public abstract class Object {
    private int hitboxesX;
    private int hitboxesY;

    public Object(int hitboxesX, int hitboxesY) {
        this.hitboxesX = hitboxesX;
        this.hitboxesY = hitboxesY;
    }
}
