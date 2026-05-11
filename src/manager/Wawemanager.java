package manager;

import FallingObjects.*;
import FallingObjects.FallingObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Wawemanager {
    private final int ticksforwave = 60 * 20;
    private final int spawninterval =50;
    private final float speedbase = 2.5f;
    private final float speedplus = 0.5f;
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

    public void reset() {
        currentWave    = 1;
        tickselapsed   = 0;
        tickssincespawn = 0;
    }

    public void nextWave() {
        currentWave++;
        tickselapsed    = 0;
        tickssincespawn = 0;
    }
    public boolean isWaveComplete()  {
        return tickselapsed >= ticksforwave;
    }

    public FallingObject createObject(int x) {
        float speed = speedbase + (currentWave - 1) * speedplus;
        int   roll  = random.nextInt(100);
        if (roll < 50){
            return new NormalFallingObject(x, -30, speed);
        } else if (roll<80) {
            return new BombFallingObject(x,-30,speed);
        } else if (roll < 85){
            return new NormalBadFallingObject(x, -30, speed);
        } else if (roll < 95){
            return new LargerPlatformFallingObject(x, -30, speed);
        } else{
            return new HeartFallingObject(x, -30, speed);
        }
    }

    public List<FallingObject> spawnObjects() {
        List<FallingObject> list = new ArrayList<>();
        int count = (currentWave >= 4 && random.nextInt(3) == 0) ? 2 : 1;
        for (int i = 0; i < count; i++) {
            int x = random.nextInt(panelwidth - 80) + 40;
            list.add(createObject(x));
        }
        return list;
    }

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
