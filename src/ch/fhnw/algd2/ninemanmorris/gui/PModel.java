package ch.fhnw.algd2.ninemanmorris.gui;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Created by Claudio on 10.01.2017.
 */
public class PModel {
    private final DoubleProperty border;
    private final DoubleProperty nodeRadius;
    private final DoubleProperty tokenRadius;
    private final ObjectProperty<Color> gameGraphColor;

    private final ArrayList<Node> nodes;
    private final ArrayList<Node> whiteStartTokens;
    private final ArrayList<Node> blackStartTokens;

    private Color white, black;
//    private Color whiteMove, blackMove;

    public PModel() {
        nodes = new ArrayList<>();
        whiteStartTokens = new ArrayList<>();
        blackStartTokens = new ArrayList<>();

        border = new SimpleDoubleProperty(30);
        nodeRadius = new SimpleDoubleProperty(5);
        tokenRadius = new SimpleDoubleProperty(20);
        gameGraphColor = new SimpleObjectProperty(Color.BLACK);

        white = Color.WHITE;
        black = Color.BLACK;
//        whiteMove = Color.LIGHTGRAY;
//        blackMove = Color.DARKGRAY.darker();
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public ArrayList<Node> getWhiteStartTokens() {
        return whiteStartTokens;
    }

    public ArrayList<Node> getBlackStartTokens() {
        return blackStartTokens;
    }

    public double getBorder() {
        return border.get();
    }

    public DoubleProperty borderProperty() {
        return border;
    }

    public void setBorder(double border) {
        this.border.set(border);
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

    public Color getGameGraphColor() {
        return gameGraphColor.get();
    }

    public ObjectProperty<Color> gameGraphColorProperty() {
        return gameGraphColor;
    }

    public void setGameGraphColor(Color gameGraphColor) {
        this.gameGraphColor.set(gameGraphColor);
    }

    public Color getWhite() {
        return white;
    }

    public Color getBlack() {
        return black;
    }
//
//    public Color getWhiteMove() {
//        return whiteMove;
//    }
//
//    public Color getBlackMove() {
//        return blackMove;
//    }
}
