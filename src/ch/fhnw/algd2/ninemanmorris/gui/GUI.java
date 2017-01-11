package ch.fhnw.algd2.ninemanmorris.gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

/**
 * Created by Claudio on 10.01.2017.
 */
public class GUI extends BorderPane{
    private Controller controller;

    private StackPane gameView;
    private Canvas gameBackground;
    private Pane tokenPane;

    private HBox buttons;
    private Button newGame;

    public GUI() {
        initializeControls();
        layoutControls();
        addEventHandlers();
        addListeners();
        addBindings();
    }

    protected void setController(Controller controller) {
        this.controller = controller;
    }

    private void initializeControls() {
        gameView = new StackPane();
        gameBackground = new Canvas();
        tokenPane = new Pane();
        buttons = new HBox();
        newGame = new Button("new game");
    }

    private void layoutControls() {
        setCenter(gameView);
        gameView.getChildren().addAll(gameBackground, tokenPane);

        setTop(buttons);
        buttons.getChildren().add(newGame);
        buttons.setMinHeight(20);
        buttons.setPrefHeight(20);
    }

    private void addEventHandlers() {
    }

    private void addListeners() {
        widthProperty().addListener(event -> {
            gameBackground.setWidth(getWidth());
            tokenPane.setMaxWidth(getWidth());
            controller.drawBackground(getWidth(), getHeight() - 20);
        });
        heightProperty().addListener(event -> {
            gameBackground.setHeight(getHeight());
            tokenPane.setMaxHeight(getHeight());
            controller.drawBackground(getWidth(), getHeight() - 20);
        });
    }

    private void addBindings() {

    }

    public Canvas getGameBackground() {
            return gameBackground;
    }

    public Pane getTokenPane() {
        return tokenPane;
    }
}
