package edu.vanier.spaceinvaders.models;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Sprite class representing game entities.
 * Extends JavaFX Rectangle class and serves as the base class for game entities.
 * 
 * @author ryan-helou
 */
public class Sprite extends Rectangle {

    private boolean dead = false;
    private final String type;
    private int lives = 3;

    /**
     * Constructs a Sprite with specified dimensions, type, and color.
     */
    public Sprite(int x, int y, int w, int h, String type, Color color) {
        super(w, h, color);
        this.type = type;
        setTranslateX(x);
        setTranslateY(y);
    }

    public void moveLeft(int amount) {
        setTranslateX(getTranslateX() - amount);
    }

    public void moveRight(int amount) {
        setTranslateX(getTranslateX() + amount);
    }

    public void moveUp(int amount) {
        setTranslateY(getTranslateY() - amount);
    }

    public void moveDown(int amount) {
        setTranslateY(getTranslateY() + amount);
    }
    
    public void moveUpLeft(double amountX, double amountY){
        setTranslateY(getTranslateY() - amountY);
        setTranslateX(getTranslateX() - amountX);
    }
    
    public void moveUpRight(double amountX, double amountY){
        setTranslateY(getTranslateY() - amountY);
        setTranslateX(getTranslateX() + amountX);
    }

    public void setPosition(double x, double y) {
        setTranslateX(x);
        setTranslateY(y);
    }

    public boolean isSpaceShipDead() {
        return lives < 1;
    }

    public boolean isDead() {
        return dead;
    }

    public void gotHit() {
        lives--;
    }

    public void livesAmount(int amount) {
        lives = amount;
    }

    public String getType() {
        return type;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
    
    
}
