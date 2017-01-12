package ch.fhnw.algd2.ninemanmorris.gui;

/**
 * Created by Claudio on 12.01.2017.
 */
public abstract class Turn {
    protected Controller controller;

    public Turn(Controller controller) {
        this.controller = controller;
    }

    public abstract Node validateToken(Token token);
    public abstract Node validateMove(double x, double y, Node root);
}
