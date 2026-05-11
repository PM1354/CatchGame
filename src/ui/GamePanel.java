package ui;

import FallingObjects.CatchingItem;
import FallingObjects.FallingObject;
import Player.Player;
import Player.Texts.GameTexts;
import manager.Wawemanager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    public static final int width  = 800;
    public static final int height = 1000;
    private static final int ticks = 16;
    private Player player;
    private Wawemanager manager;
    private final List<FallingObject> fallingObjects = new ArrayList<>();
    private final List<GameTexts> floatingLabels = new ArrayList<>();
    private final Timer gameTimer;
    private boolean leftPressed;
    private boolean rightPressed;

    public GamePanel() {
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        addKeyListener(this);
        gameTimer = new Timer(ticks, this);
    }

    public void startGame() {
        player = new Player(1000,800);
        manager= new Wawemanager(width);
        fallingObjects.clear();
        floatingLabels.clear();
        leftPressed= false;
        rightPressed= false;
        requestFocusInWindow();
        gameTimer.start();
    }

    public void stopGame()   {
        gameTimer.stop();
    }

    public void resumeGame() {
        requestFocusInWindow(); gameTimer.start();
    }

    public int  getScore()   {
        return player != null ? player.getScore() : 0;
    }

    private boolean isColliding(FallingObject obj) {
        int left  = player.getX() - player.getHitboxesX() / 2;
        int right = player.getX() + player.getHitboxesY()/ 2;
        int top   = player.getY();
        int bot   = player.getY() + player.getHitboxesY();
        return obj.getX() >= left - 8 && obj.getX() <= right + 8 && obj.getY() >= top - 5 && obj.getY() <= bot;
    }

    private void Collision(FallingObject obj) {
        if (obj instanceof CatchingItem c) {
            c.catched(player);
        }
        floatingLabels.add(new GameTexts(obj.playerCatcheObjectString(),Color.BLACK,obj.getY(), obj.getX()));
        obj.playerCatcheObject();
    }

    private void update() {
        System.out.println(player.getScore());
        System.out.println(manager.getCurrentWave());
        if (leftPressed) {
            player.moveLeft();
        }
        if (rightPressed) {
            player.moveRight();
        }
        fallingObjects.addAll(manager.update());
        Iterator<FallingObject> it = fallingObjects.iterator();
        while (it.hasNext()) {
            FallingObject obj = it.next();
            obj.update();
            if (obj.isCatched() || obj.getY() > height + 40) {
                it.remove();
                continue;
            }
            if (isColliding(obj)) {
                Collision(obj);
                it.remove();
            }
        }
        Iterator<GameTexts> li = floatingLabels.iterator();
        while (li.hasNext()) {
            GameTexts txt = li.next();
            txt.timerplus();
            if (txt.notActive()) {
                li.remove();
            }
        }
        if (manager.isWaveComplete()) {
            stopGame();
            manager.nextWave();
            fallingObjects.clear();
            resumeGame();
        }
    }

    private void drawFallingObjects(Graphics2D g2d) {
        for (FallingObject obj : fallingObjects) {
            obj.drawCircle(g2d, obj.getColor());
        }
    }

    private void drawBasket(Graphics2D g2d) {
        int x = player.getX() - player.getHitboxesX()/2;
        int y = player.getY();
        int w = player.getHitboxesX();
        int h = player.getHitboxesY();
        g2d.setColor(new Color(235, 175, 255));
        g2d.fillRoundRect(x,y,w,h, 10, 10);
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(2.5f));
        g2d.drawRoundRect(x,y,w,h,10,10);
    }

    private void drawFloatingLabels(Graphics2D g2d) {
        for (GameTexts txt : floatingLabels) {
            txt.draw(g2d);
        }
    }


    private void drawHUD(Graphics2D g2d) {
        g2d.setColor(new Color(0, 0, 0, 100));
        g2d.fillRect(0, 0, width, 48);
        g2d.setFont(new Font("Arial", Font.BOLD, 18));
        g2d.setColor(new Color(220, 60, 90));
        StringBuilder hearts = new StringBuilder();
        for (int i = 0; i < player.getHearts(); i++) hearts.append("♥ ");
        g2d.drawString(hearts.toString().trim(), 10, 30);
        g2d.setColor(Color.WHITE);
        String score = "Score: " + getScore();
        int sw = g2d.getFontMetrics().stringWidth(score);
        g2d.drawString(score, width - sw - 10, 30);
        g2d.setFont(new Font("Arial", Font.BOLD, 13));
        g2d.setColor(new Color(200, 200, 255));
        String waveStr = "Wave " + manager.getCurrentWave();
        int ww = g2d.getFontMetrics().stringWidth(waveStr);
        g2d.drawString(waveStr, (width - ww) / 2, height - 8);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (player == null || manager == null) return;
        drawFallingObjects(g2d);
        drawBasket(g2d);
        drawFloatingLabels(g2d);
        drawHUD(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();
        if (k == KeyEvent.VK_LEFT  || k == KeyEvent.VK_A) leftPressed  = true;
        if (k == KeyEvent.VK_RIGHT || k == KeyEvent.VK_D) rightPressed = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int k = e.getKeyCode();
        if (k == KeyEvent.VK_LEFT  || k == KeyEvent.VK_A) leftPressed  = false;
        if (k == KeyEvent.VK_RIGHT || k == KeyEvent.VK_D) rightPressed = false;
    }
}
