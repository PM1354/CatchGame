package manager;

import FallingObjects.*;
import FallingObjects.FallingObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Wawemanager {
    private final int ticksforwave = 60 * 30;
    private final int spawninterval =50;
    private final float speedbase = 2.5f;
    private final float speedplus = 0.45f;
    private int currentWave;
    private int tickselapsed;
    private int tickssincespawn;
    private final int panelwidth;
    private final Random random;


    public Wawemanager (int panelwidth){
        this.panelwidth = panelwidth;
        this.random = new Random();
        reset();
    }

    /**
     * Resets the wave to the first wave
     */
    public void reset() {
        currentWave    = 1;
        tickselapsed   = 0;
        tickssincespawn = 0;
    }

    /**
     * Moves to the next wave
     */
    public void nextWave() {
        currentWave++;
        tickselapsed    = 0;
        tickssincespawn = 0;
    }
    /**
     * Checks if the wave is complete
     * @return true if wave is complete, false otherwise
     */
    public boolean isWaveComplete()  {
        return tickselapsed >= ticksforwave;
    }

    /**
     * Creates a random falling object based on the current wave
     * @param x x-coordinate
     * @return newly created falling object
     */
    public FallingObject createObject(int x) {
        float speed = speedbase + (currentWave - 1) * speedplus;
        int roll = random.nextInt(100);
        if (roll < 60){
            return new NormalFallingObject(x, -30, speed);
        } else if (roll<80) {
            return new BombFallingObject(x,-30,speed);
        } else if (roll < 90){
            return new NormalBadFallingObject(x, -30, speed);
        } else if (roll < 95){
            return new LargerPlatformFallingObject(x, -30, speed);
        } else{
            return new HeartFallingObject(x, -30, speed);
        }
    }

    /**
     * Creates a list of falling objects to spawn (in higher waves can be 2 at once)
     * @return list of newly created objects
     */
    public List<FallingObject> spawnObjects() {
        List<FallingObject> list = new ArrayList<>();
        int count = (currentWave >= 4 && random.nextInt(3) == 0) ? 2 : 1;
        for (int i = 0; i < count; i++) {
            int x = random.nextInt(panelwidth - 80) + 40;
            list.add(createObject(x));
        }
        return list;
    }

    /**
     * Updates the wave state and generates new falling objects
     * @return list of newly spawned falling objects
     */
    public List<FallingObject> update() {
        List<FallingObject> spawned = new ArrayList<>();
        tickselapsed++;
        tickssincespawn++;
        int spawnInterval = Math.max(15, spawninterval - (currentWave - 1) * 5);
        if (tickssincespawn >= spawnInterval) {
            spawned.addAll(spawnObjects());
            tickssincespawn = 0;
        }
        return spawned;
    }

    public int getCurrentWave() {
        return currentWave;
    }

    public int getTickselapsed() {
        return tickselapsed;
    }

    public int getTickssincespawn() {
        return tickssincespawn;
    }

    public int getTicksforwave() {
        return ticksforwave;
    }
}
