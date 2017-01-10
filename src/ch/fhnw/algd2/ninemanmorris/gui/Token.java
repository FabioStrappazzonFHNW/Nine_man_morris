package ch.fhnw.algd2.ninemanmorris.gui;

import javafx.beans.property.*;
import javafx.scene.paint.Color;

/**
 * Created by Claudio on 10.01.2017.
 */

public class Token {
    private final boolean white;

    private final DoubleProperty x, y;
    private final ObjectProperty<Color> color;

    public Token(boolean white, double x, double y) {
        this.white = white;
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.color = new SimpleObjectProperty<>();
    }

    public double getX() {
        return x.get();
    }

    public DoubleProperty xProperty() {
        return x;
    }

    public void setX(double x) {
        this.x.set(x);
    }

    public double getY() {
        return y.get();
    }

    public DoubleProperty yProperty() {
        return y;
    }

    public void setY(double y) {
        this.y.set(y);
    }

    public Color getColor() {
        return color.get();
    }

    public Property<Color> colorProperty() {
        return color;
    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    public boolean isWhite() {
        return white;
    }
}
