package ch.fhnw.algd2.ninemanmorris.gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

/**
 * Created by Claudio on 10.01.2017.
 */
public class GUI extends GridPane{
    private Controller controller;

    private Canvas gameArea;
    private Label player1, player2;
    private VBox tokens1, tokens2;

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
        gameArea = new Canvas();
        player1 = new Label("player 1");
        player2 = new Label("player 2");
        tokens1 = new VBox();
        tokens2 = new VBox();

        buttons = new HBox();
        newGame = new Button("new game");
    }

    private void layoutControls() {
        ColumnConstraints side = new ColumnConstraints();
        side.setHgrow(Priority.ALWAYS);
        side.setPercentWidth(0.2);
        side.setMinWidth(60);

        ColumnConstraints middle = new ColumnConstraints();
        middle.setHgrow(Priority.ALWAYS);
        middle.setPercentWidth(0.6);
        middle.setMinWidth(200);

        RowConstraints top = new RowConstraints();
        top.setVgrow(Priority.ALWAYS);
        top.setPercentHeight(0.1);
        top.setMinHeight(15);

        RowConstraints labelRow = new RowConstraints();
        labelRow.setVgrow(Priority.ALWAYS);
        labelRow.setPercentHeight(0.2);
        labelRow.setMinHeight(30);

        RowConstraints gameRow = new RowConstraints();
        gameRow.setVgrow(Priority.ALWAYS);
        gameRow.setPercentHeight(0.7);
        gameRow.setMinHeight(200);

        add(buttons, 0, 0, 3, 1);
        add(player1, 0, 1);
        add(player2, 2, 1);
        add(tokens1, 0, 2);
        add(tokens2, 2, 2);
        add(gameArea, 1, 2);

        buttons.getChildren().add(newGame);

//        getColumnConstraints().addAll(side, middle, side);
//        getRowConstraints().addAll(top, labelRow, gameRow);

//        player1.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
//        player2.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        gameArea.setWidth(500);
        gameArea.setHeight(500);
//        newGame.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    private void addEventHandlers() {

    }

    private void addListeners() {

    }

    private void addBindings() {

    }

    public Canvas getGameArea() {
            return gameArea;
    }
}
