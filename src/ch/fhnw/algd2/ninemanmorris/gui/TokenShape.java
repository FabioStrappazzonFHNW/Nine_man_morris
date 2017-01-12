package ch.fhnw.algd2.ninemanmorris.gui;

import javafx.scene.shape.Circle;

/**
 * Created by Claudio on 10.01.2017.
 */
public class TokenShape extends Circle {
    private Controller controller;
    private Token token;
    private Node root, node;

    public TokenShape(Controller controller, Token token) {
        this.controller = controller;
        this.token = token;
        this.root = null;
        this.node = null;

        addEventHandler();
        addBindings();

        controller.setNormalTokenColor(token);
        setStrokeWidth(2);
    }

    private void addEventHandler() {
        setOnMousePressed(event -> {
            root = controller.validateToken(token);
            if (root != null) token.setState(Token.State.LOST);
//            controller.setMovingTokenColor(token);
        });
        setOnMouseDragged(event -> {
            if (root != null) {
                double x = event.getX();
                double y = event.getY();
                node = controller.validateMove(x, y, root);
                if (node != null) {
                    token.setState(Token.State.INRANGE);
                    x = node.getX();
                    y = node.getY();
                } else {
                    token.setState(Token.State.LOST);
                }
                token.setX(x);
                token.setY(y);
            }
        });
        setOnMouseReleased(event -> {
            if (root != null) {
                if (node != null) {
                    root.setToken(null);
                    node.setToken(token);
                    controller.updateTurn();
                } else {
                    token.setX(root.getX());
                    token.setY(root.getY());
                }
                token.setState(Token.State.FIXED);
                controller.setNormalTokenColor(token);
            }
        });
    }

    private void addBindings() {
        radiusProperty().bind(controller.getModel().tokenRadiusProperty());
        centerXProperty().bind(token.xProperty());
        centerYProperty().bind(token.yProperty());
        fillProperty().bind(token.fillColorProperty());
        strokeProperty().bind(token.strokeColorProperty());
    }


}
