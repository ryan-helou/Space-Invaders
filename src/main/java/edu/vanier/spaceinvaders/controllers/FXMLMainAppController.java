package edu.vanier.spaceinvaders.controllers;

import edu.vanier.spaceinvaders.models.Sprite;
import java.util.List;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller class of the MainApp's UI. Handles game logic and UI interactions.
 *
 * @author ryan-helou
 */
public class FXMLMainAppController {

    private final static Logger logger = LoggerFactory.getLogger(FXMLMainAppController.class);
    AudioClip death = new AudioClip(getClass().getResource("/sounds/explosiondead.wav").toExternalForm());
    AudioClip shoot2 = new AudioClip(getClass().getResource("/sounds/shoot1.wav").toExternalForm());
    AudioClip shoot3 = new AudioClip(getClass().getResource("/sounds/shoot2.wav").toExternalForm());
    AudioClip shoot1 = new AudioClip(getClass().getResource("/sounds/shoot3.wav").toExternalForm());
    AudioClip hit = new AudioClip(getClass().getResource("/sounds/hit.wav").toExternalForm());
    AudioClip win = new AudioClip(getClass().getResource("/sounds/win.wav").toExternalForm());
    AudioClip lose = new AudioClip(getClass().getResource("/sounds/lose.wav").toExternalForm());

    double shotProbability1 = 0.5;
    double shotProbability2 = 0.8;
    double shotProbability3 = 1.0;

    int enemiesAlive = 0;
    int level = 1;
    int bulletNumber = 1;
    @FXML
    private Pane animationPanel;
    @FXML
    private Label timeLbl;
    @FXML
    private Label pressN;
    @FXML
    private Label levelLbl;
    private Label livesLabel;
    private double elapsedTime = 0;
    private Sprite spaceShip;
    private Scene scene;
    private boolean gameOver = false;
    private int shownDead = 0;
    long startTime = 0;
    AnimationTimer animation;

    /**
     * Initializes the controller. Sets up the initial state of the game.
     */
    @FXML
    public void initialize() {
        logger.info("Initializing MainAppController...");
        startTime = System.nanoTime();

        spaceShip = new Sprite(456, 720, 40, 40, "player", Color.BLUE);
        startLevel(level);
        livesLabel = new Label("Lives " + spaceShip.getLives());
        livesLabel.setTextFill(Color.WHITE);
        livesLabel.setLayoutX(20);
        livesLabel.setLayoutY(10);
        Font customFont = Font.loadFont(getClass().getResourceAsStream("/fonts/arcade.ttf"), 40);
        Font customFont2 = Font.loadFont(getClass().getResourceAsStream("/fonts/dpcomic.ttf"), 15);

        livesLabel.setFont(customFont);
        pressN.setFont(customFont2);
        animationPanel.getChildren().add(livesLabel);

        Image backgroundImage = new Image("/images/spaceback.png");

        animationPanel.setBackground(new Background(new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));

    }

    /**
     * Initializes the game components after the FXML components are injected.
     * Handles keyboard input events.
     */
    public void initGameComponents() {
        createContent();
        this.scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case A:
                    spaceShip.moveLeft(15);
                    break;
                case D:
                    spaceShip.moveRight(15);
                    break;
                case W:
                    spaceShip.moveUp(15);
                    break;
                case S:
                    spaceShip.moveDown(15);
                    break;
                case SPACE:

                switch (level) {
                    case 1:
                        shootPlayer(spaceShip, bulletNumber);
                        shoot1.play();
                        break;
                    case 2:
                        shootPlayerRight(spaceShip, bulletNumber);
                        shootPlayerLeft(spaceShip, bulletNumber);
                        shoot1.play();
                        break;
                    case 3:
                        shootPlayerRight(spaceShip, bulletNumber);
                        shootPlayerLeft(spaceShip, bulletNumber);
                        shootPlayer(spaceShip, bulletNumber);
                        shoot1.play();
                        break;
                    default:
                        break;
                }

                    break;

                case N:
                    nextBullet();
            }
        });
    }

    /**
     * Starts the specified game level.
     *
     */
    private void startLevel(int levelNumber) {
        switch (levelNumber) {
            case 1 -> initializeLevel1();
            case 2 -> initializeLevel2();
            case 3 -> initializeLevel3();
            default -> {
            }
        }

    }

    private void initializeLevel1() {
        levelLbl.setTextFill(Color.RED);
        enemiesAlive = 15;
        spaceShip.setFill(new ImagePattern(new Image("/images/ship1.png")));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                Sprite invader = new Sprite(260 + j * 100, 150 + i * 100, 30, 30, "enemy", Color.RED);
                Image tempImage = new Image("/images/enemy.png");
                invader.setFill(new ImagePattern(tempImage));
                animationPanel.getChildren().add(invader);
            }
        }
    }

    private void initializeLevel2() {
        levelLbl.setTextFill(Color.YELLOW);
        animationPanel.getChildren().addAll(timeLbl, levelLbl);
        enemiesAlive = 21;
        spaceShip.setFill(new ImagePattern(new Image("/images/ship2.png")));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                Sprite invader = new Sprite(175 + j * 100, 150 + i * 100, 30, 30, "enemy", Color.RED);
                Image tempImage = new Image("/images/enemy2.png");
                invader.setFill(new ImagePattern(tempImage));
                animationPanel.getChildren().add(invader);
            }
        }
    }

    private void initializeLevel3() {
        levelLbl.setTextFill(Color.GREEN);
        animationPanel.getChildren().addAll(timeLbl, levelLbl);
        enemiesAlive = 28;
        spaceShip.setFill(new ImagePattern(new Image("/images/ship3.png")));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                Sprite invader = new Sprite(175 + j * 100, 150 + i * 100, 30, 30, "enemy", Color.RED);
                Image tempImage = new Image("/images/enemy3.png");
                invader.setFill(new ImagePattern(tempImage));
                animationPanel.getChildren().add(invader);
            }
        }

    }

    private void createContent() {
        animationPanel.setPrefSize(600, 800);
        animationPanel.getChildren().add(spaceShip);
        animation = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        animation.start();
    }

    private List<Sprite> sprites() {
        return animationPanel.getChildren().stream()
                .filter(node -> node instanceof Sprite)
                .map(node -> (Sprite) node)
                .collect(Collectors.toList());
    }
    
    /**
     * Updates the game state and performs necessary actions.
     * Invoked by the animation timer.
     */

    private void update() {

        double endTime = System.nanoTime();
        double passedTime = (endTime - startTime) / 1000000000.0;
        double roundedPassedTime = Double.parseDouble(String.format("%.3f", passedTime));
        if (spaceShip.isDead() == false && areEnemiesDead() == false && level < 4) {
            levelLbl.setText("Level " + level);
            Font customFont = Font.loadFont(getClass().getResourceAsStream("/fonts/dpcomic.ttf"), 40);
            Font customFont2 = Font.loadFont(getClass().getResourceAsStream("/fonts/dpcomic.ttf"), 70);
            timeLbl.setFont(customFont);
            levelLbl.setFont(customFont2);
            timeLbl.setText(String.valueOf(roundedPassedTime + " SECONDS"));
        }
        elapsedTime += 0.016;
        if (gameOver == false) {
            scene.setFill(new ImagePattern(new Image("/images/spaceback.png")));

        }

        sprites().forEach(sprite -> {
            switch (sprite.getType()) {

                case "enemybullet":
                    sprite.moveDown(5);

                    if (sprite.getBoundsInParent().intersects(spaceShip.getBoundsInParent())) {
                        sprite.setDead(true);
                        spaceShip.gotHit();
                        spaceShip.setDead(spaceShip.isSpaceShipDead());
                        hit.play();

                    }

                    break;

                case "playerbullet":
                    sprite.moveUp(10);

                    sprites().stream().filter(e -> e.getType().equals("enemy")).forEach(enemy -> {
                        if (sprite.getBoundsInParent().intersects(enemy.getBoundsInParent())) {
                            death.play();
                            enemy.setDead(true);
                            sprite.setDead(true);
                            enemiesAlive--;
                            Sprite explosion = new Sprite((int) enemy.getTranslateX(), (int) enemy.getTranslateY(), 40, 40, "explosion", Color.TRANSPARENT);
                            Image explosionImage = new Image("/images/explosionred.gif");

                            if (level == 1) {
                                explosionImage = new Image("/images/explosionred.gif");
                            } else {
                                explosionImage = new Image("/images/explosiongreen.gif");
                            }
                            explosion.setFill(new ImagePattern(explosionImage));
                            animationPanel.getChildren().add(explosion);

                            removeAfterDuration(explosion, 1.0);
                        }
                    });

                    break;

                case "playerbulletright":
                    sprite.moveUpRight(0.5, 10);

                    sprites().stream().filter(e -> e.getType().equals("enemy")).forEach(enemy -> {
                        if (sprite.getBoundsInParent().intersects(enemy.getBoundsInParent())) {
                            death.play();

                            enemy.setDead(true);
                            sprite.setDead(true);
                            enemiesAlive--;
                            Sprite explosion = new Sprite((int) enemy.getTranslateX(), (int) enemy.getTranslateY(), 40, 40, "explosion", Color.TRANSPARENT);
                            Image explosionImage = new Image("/images/explosionyellow.gif");

                            if (level == 2) {
                                explosionImage = new Image("/images/explosionyellow.gif");
                            } else {
                                explosionImage = new Image("/images/explosiongreen.gif");
                            }
                            explosion.setFill(new ImagePattern(explosionImage));
                            animationPanel.getChildren().add(explosion);

                            removeAfterDuration(explosion, 1.0);
                        }
                    });

                    break;

                case "playerbulletleft":
                    sprite.moveUpLeft(0.5, 10);

                    sprites().stream().filter(e -> e.getType().equals("enemy")).forEach(enemy -> {
                        if (sprite.getBoundsInParent().intersects(enemy.getBoundsInParent())) {
                            death.play();
                            enemy.setDead(true);
                            sprite.setDead(true);
                            enemiesAlive--;
                            Sprite explosion = new Sprite((int) enemy.getTranslateX(), (int) enemy.getTranslateY(), 40, 40, "explosion", Color.TRANSPARENT);
                            Image explosionImage = new Image("/images/explosionyellow.gif");
                            if (level == 2) {
                                explosionImage = new Image("/images/explosionyellow.gif");
                            } else {
                                explosionImage = new Image("/images/explosiongreen.gif");
                            }
                            explosion.setFill(new ImagePattern(explosionImage));
                            animationPanel.getChildren().add(explosion);
                            removeAfterDuration(explosion, 1.0);

                        }
                    });

                    break;

                case "enemy":

                    if (elapsedTime > 2) {
                        if (Math.random() < findShotProbability(level)) {
                            shootEnemy(sprite);
                        }
                    }
                    break;
            }
        });

        animationPanel.getChildren().removeIf(n -> {
            try {
                Sprite sprite = (Sprite) n;
                return sprite.isDead();
            } catch (Exception e) {
                return false;
            }
        });
        livesLabel.setText("Lives " + spaceShip.getLives());
        if (!animationPanel.getChildren().contains(livesLabel)) {
            animationPanel.getChildren().add(livesLabel);
        }

        if (spaceShip.getLives() < 1) {
            spaceShip.setDead(true);
        }

        if (spaceShip.isSpaceShipDead() == true && shownDead < 4) {
            shownDead++;
            gameOver = true;
            for (int i = 0; i < 4; i++) {
                animationPanel.getChildren().clear();
            }
            animationPanel.getChildren().clear();
            Label gameOverLabel = new Label("GAME OVER");
            levelLbl.setText(" ");
            lose.play();
            gameOverLabel.setFont(new Font(70));
            gameOverLabel.setTextFill(Color.RED);
            Font customFont = Font.loadFont(getClass().getResourceAsStream("/fonts/arcade.ttf"), 150);
            gameOverLabel.setFont(customFont);
            gameOverLabel.setLayoutX(((animationPanel.getWidth() - gameOverLabel.getWidth()) / 2) - 330);
            gameOverLabel.setLayoutY(((animationPanel.getHeight() - gameOverLabel.getHeight()) / 2) - 180);
            animationPanel.getChildren().add(timeLbl);
            animationPanel.getChildren().add(gameOverLabel);
        }

        if (areEnemiesDead() == true && level < 4) {
            animationPanel.getChildren().clear();
            level++;
            animationPanel.getChildren().add(spaceShip);
            startLevel(level);
        }
        if (areEnemiesDead() == true && level > 2 && gameOver == false) {
            livesLabel.setText(" ");

            animationPanel.getChildren().clear();
            Label winLabel = new Label("YOU WIN!");
            levelLbl.setText(" ");
            win.play();
            winLabel.setFont(new Font(70));
            Font customFont = Font.loadFont(getClass().getResourceAsStream("/fonts/arcade.ttf"), 150);
            winLabel.setFont(customFont);
            winLabel.setTextFill(Color.GREEN);
            winLabel.setLayoutX(((animationPanel.getWidth() - winLabel.getWidth()) / 2) - 280);
            winLabel.setLayoutY(((animationPanel.getHeight() - winLabel.getHeight()) / 2) - 190);
            animationPanel.getChildren().add(timeLbl);
            animationPanel.getChildren().add(winLabel);
            gameOver = true;
        }

        if (elapsedTime > 2) {
            elapsedTime = 0;
        }
    }

    private void shootPlayer(Sprite who, int bullet) {
        Sprite s = new Sprite((int) who.getTranslateX() + 10, (int) who.getTranslateY(), 25, 35, who.getType() + "bullet", Color.WHITE);
        switch (bullet) {
            case 1:
                s.setFill(new ImagePattern(new Image("/images/missile1.png")));
                break;
            case 2:
                s.setFill(new ImagePattern(new Image("/images/missile2.png")));
                break;
            case 3:
                s.setFill(new ImagePattern(new Image("/images/missile3.png")));
                break;
            default:
                break;
        }
        animationPanel.getChildren().add(s);
    }

    private void shootPlayerRight(Sprite who, int bullet) {
        Sprite s = new Sprite((int) who.getTranslateX() + 10, (int) who.getTranslateY(), 25, 35, who.getType() + "bulletright", Color.WHITE);
        switch (bullet) {
            case 1:
                s.setFill(new ImagePattern(new Image("/images/missile1.png")));
                break;
            case 2:
                s.setFill(new ImagePattern(new Image("/images/missile2.png")));
                break;
            case 3:
                s.setFill(new ImagePattern(new Image("/images/missile3.png")));
                break;
            default:
                break;
        }
        animationPanel.getChildren().add(s);
    }

    private void shootPlayerLeft(Sprite who, int bullet) {
        Sprite s = new Sprite((int) who.getTranslateX() + 10, (int) who.getTranslateY(), 25, 35, who.getType() + "bulletleft", Color.WHITE);
        switch (bullet) {
            case 1:
                s.setFill(new ImagePattern(new Image("/images/missile1.png")));
                break;
            case 2:
                s.setFill(new ImagePattern(new Image("/images/missile2.png")));
                break;
            case 3:
                s.setFill(new ImagePattern(new Image("/images/missile3.png")));
                break;
            default:
                break;
        }
        animationPanel.getChildren().add(s);
    }

    private void shootEnemy(Sprite who) {
        Sprite s = new Sprite((int) who.getTranslateX() + 12, (int) who.getTranslateY(), 5, 20, who.getType() + "bullet", Color.RED);
        animationPanel.getChildren().add(s);
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    private boolean areEnemiesDead() {
        return sprites().stream().filter(e -> e.getType().equals("enemy")).allMatch(Sprite::isDead);
    }

    public void nextBullet() {
        if (bulletNumber == 3) {
            bulletNumber = 1;
        } else {
            bulletNumber++;
        }

    }

    public double findShotProbability(int level) {
        switch (level) {
            case 1:
                return shotProbability1;
            case 2:
                return shotProbability2;
            case 3:
                return shotProbability3;
            default:
                return 0.0;
        }
    }

    public void stopAnimation() {
        if (animation != null) {
            animation.stop();
        }
    }

    private void removeAfterDuration(Sprite sprite, double duration) {
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    animationPanel.getChildren().remove(sprite);
                });
            }
        },
                (long) (duration * 1000)
        );
    }
}
