package manager;

import FallingObjects.*;
import FallingObjects.Object;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Wawemanager {
    private static final int ticksforwave = 60 * 20;
    private static final int spawninterval =50;
    private static final float speedbase = 2.5f;
    private static final float speedplus = 0.5f;
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

    private Object createObject(int x) {
        float speed = speedbase + (currentWave - 1) * speedplus;
        int   roll  = random.nextInt(100);

        if (roll < 65){
            return new NormalObject(x, -30, speed);
        } else if (roll < 80){
            return new NormalBadObject(x, -30, speed);
        }
        else if (roll < 94){
            return new LargerPlatformObject(x, -30, speed);}
        else{
            return new HeartObject(x, -30, speed);
        }
    }

    private List<Object> spawnObjects() {
        List<Object> list = new ArrayList<>();
        int count = (currentWave >= 4 && random.nextInt(3) == 0) ? 2 : 1;
        for (int i = 0; i < count; i++) {
            int x = random.nextInt(panelwidth - 80) + 40;
            list.add(createObject(x));
        }
        return list;
    }

    public List<Object> update() {
        List<Object> spawned = new ArrayList<>();
        tickselapsed++;
        tickssincespawn++;
        int spawnInterval = Math.max(15, spawninterval - (currentWave - 1) * 5);
        if (tickssincespawn >= spawnInterval) {
            spawned.addAll(spawnObjects());
            tickssincespawn = 0;
        }
        return spawned;
    }
}
