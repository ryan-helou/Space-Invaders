package edu.vanier.spaceinvaders;

import edu.vanier.spaceinvaders.controllers.FXMLMainAppController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The main class of the Space Invaders application. Responsible for launching
 * and initializing the game. Extends JavaFX Application class.
 *
 * @author ryanheolu
 */
public class SpaceInvadersApp extends Application {

    private final static Logger logger = LoggerFactory.getLogger(SpaceInvadersApp.class);
    FXMLMainAppController controller;

    /**
     * The main entry point for the Space Invaders application. Initializes the
     * application and launches the primary stage.
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            logger.info("Bootstrapping the application...");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainApp_layout.fxml"));
            controller = new FXMLMainAppController();
            loader.setController(controller);
            Pane root = loader.load();
            Scene scene = new Scene(root, 1000, 1000);
            controller.setScene(scene);
            controller.initGameComponents();
            primaryStage.setScene(scene);
            primaryStage.setTitle("Space Invaders!");
            primaryStage.sizeToScene();
            primaryStage.setAlwaysOnTop(true);
            primaryStage.show();
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    /**
     * Stops the application. Called when the JavaFX application is shut down.
     *
     * @throws Exception If an error occurs during application shutdown.
     */
    @Override
    public void stop() throws Exception {
        controller.stopAnimation();
    }

    /**
     * The main method that launches the JavaFX application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
