package ch.fhnw.algd2.ninemanmorris.gui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.AbstractList;
import java.util.Arrays;

/**
 * Created by Claudio on 10.01.2017.
 */
public class Controller {
    private GUI ui;
    private PModel model;

    public Controller(GUI ui, PModel model) {
        this.ui = ui;
        this.ui.setController(this);
        this.model = model;

        this.model.getNodes().addAll(Arrays.asList(GameGraph.init()));
        drawGameGraph();

        model.getPlayer1().addAll(Arrays.asList(initTokenPlayer(9, true, 20)));
        drawTokens(model.getPlayer1());
        model.getPlayer2().addAll(Arrays.asList(initTokenPlayer(9, false, 20)));
        drawTokens(model.getPlayer2());
    }

    public PModel getModel() {
        return model;
    }

    public void drawGameGraph() {
        GraphicsContext gc = ui.getGameBackground().getGraphicsContext2D();
        double border = 30;
        double radius = model.getNodeRadius();
        GameGraph.calculateNodePos(model.getNodes(), border, ui.getGameBackground().getWidth() , ui.getGameBackground().getHeight());

        for (Node n : model.getNodes()) {
            gc.fillOval(n.getX() - radius, n.getY() - radius, 2 * radius, 2 * radius);

            if(n.getRight() != null) {
                gc.strokeLine(n.getX(), n.getY(), n.getRight().getX(), n.getRight().getY());
            }
            if(n.getBottom() != null) {
                gc.strokeLine(n.getX(), n.getY(), n.getBottom().getX(), n.getBottom().getY());
            }
        }
    }

    private Token[] initTokenPlayer(int n, boolean white, double radius) {
        Token[] tokens = new Token[n];
        for (int i = 0; i < n; i++) {
            tokens[i] = new Token(white, 250, 250);
        }
        return tokens;
    }

    private void drawTokens(AbstractList<Token> tokens) {
        for(Token t : tokens) {
            TokenShape tokenShape = new TokenShape(this, t);
            ui.getTokenPane().getChildren().add(tokenShape);
        }
    }

    public Node getNodeInRange(double x, double y) {
        for(Node node : model.getNodes()) {
            if (node.isInRange(x, y)) return node;
        }
        return null;
    }

    public void setMovingTokenColor(Token token) {
        token.setColor(token.isWhite() ? model.getWhiteMove() : model.getBlackMove());
    }

    public void setNormalTokenColor(Token token) {
        token.setColor(token.isWhite() ? model.getWhite() : model.getBlack());
    }
}
