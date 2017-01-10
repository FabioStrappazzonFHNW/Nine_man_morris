package ch.fhnw.algd2.ninemanmorris.gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by Claudio on 10.01.2017.
 */
public class TokenShape extends Circle {
    private Token token;
    private Node root, node;
    private Controller controller;

    public TokenShape(Controller controller, Token token) {
        this.controller = controller;
        this.token = token;
        this.root = null;
        this.node = null;

        addEventHandler();
        addBindings();

        controller.setNormalTokenColor(token);
        setStroke(Color.BLACK);
    }

    private void addEventHandler() {
        setOnMousePressed(event -> {
            controller.setMovingTokenColor(token);
        });
        setOnMouseDragged(event -> {
            double x = event.getX();
            double y = event.getY();
            node = controller.getNodeInRange(x, y);
            if (node != null) {
                x = node.getX();
                y = node.getY();
            }

            token.setX(x);
            token.setY(y);
        });
        setOnMouseReleased(event -> {
            controller.setNormalTokenColor(token);
        });
    }

    private void addBindings() {
        radiusProperty().bind(controller.getModel().tokenRadiusProperty());
        centerXProperty().bind(token.xProperty());
        centerYProperty().bind(token.yProperty());
        fillProperty().bind(token.colorProperty());
    }
}
