package ch.fhnw.algd2.ninemanmorris.gui;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Claudio on 10.01.2017.
 */
public class PModel {
    private DoubleProperty nodeRadius;
    private DoubleProperty tokenRadius;
    private ArrayList<Node> nodes;

    private ArrayList<Token> player1;
    private ArrayList<Token> player2;
    private Color white, black, whiteMove, blackMove;

    public PModel() {
        nodes = new ArrayList<>();
        player1 = new ArrayList<>();
        player2 = new ArrayList<>();

        nodeRadius = new SimpleDoubleProperty(5);
        tokenRadius = new SimpleDoubleProperty(20);

        white = Color.WHITE;
        black = Color.BLACK;
        whiteMove = Color.LIGHTGRAY;
        blackMove = Color.DARKGRAY.darker();

    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public ArrayList<Token> getPlayer1() {
        return player1;
    }

    public ArrayList<Token> getPlayer2() {
        return player2;
    }

    public double getNodeRadius() {
        return nodeRadius.get();
    }

    public DoubleProperty nodeRadiusProperty() {
        return nodeRadius;
    }

    public void setNodeRadius(double nodeRadius) {
        this.nodeRadius.set(nodeRadius);
    }

    public double getTokenRadius() {
        return tokenRadius.get();
    }

    public DoubleProperty tokenRadiusProperty() {
        return tokenRadius;
    }

    public void setTokenRadius(double tokenRadius) {
        this.tokenRadius.set(tokenRadius);
    }

    public Color getWhite() {
        return white;
    }

    public Color getBlack() {
        return black;
    }

    public Color getWhiteMove() {
        return whiteMove;
    }

    public Color getBlackMove() {
        return blackMove;
    }
}
