package ch.fhnw.algd2.ninemanmorris.gui;

import javafx.beans.property.*;
import javafx.scene.paint.Color;

/**
 * Created by Claudio on 10.01.2017.
 */

public class Token {
    private final boolean white;
    private final DoubleProperty x, y;
    private final ObjectProperty<Color> fillColor;
    private final ObjectProperty<Color> strokeColor;
    private final ObjectProperty<State> state;

    public enum State {
        FIXED(Color.BLACK),
        INRANGE(Color.GREEN),
        LOST(Color.RED);

        private Color color;

        State(Color color) {
            this.color = color;
        }
    }

    public Token(boolean white) {
        this.white = white;
        this.x = new SimpleDoubleProperty();
        this.y = new SimpleDoubleProperty();
        this.fillColor = new SimpleObjectProperty<>();
        this.strokeColor = new SimpleObjectProperty<>(Color.BLACK);
        this.state = new SimpleObjectProperty<>(State.FIXED);

        addListener();
    }

    private void addListener() {
        state.addListener((observable, oldValue, newValue) -> {
            setStrokeColor(newValue.color);
        });
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

    public Color getFillColor() {
        return fillColor.get();
    }

    public Property<Color> fillColorProperty() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor.set(fillColor);
    }

    public Color getStrokeColor() {
        return strokeColor.get();
    }

    public Property<Color> strokeColorProperty() {
        return strokeColor;
    }

    public State getState() {
        return state.get();
    }

    public ObjectProperty<State> stateProperty() {
        return state;
    }

    public void setState(State state) {
        this.state.set(state);
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor.set(strokeColor);
    }

    public boolean isWhite() {
        return white;
    }
}
