package ch.fhnw.algd2.ninemanmorris.gui.turns;

import ch.fhnw.algd2.ninemanmorris.gui.Controller;
import ch.fhnw.algd2.ninemanmorris.gui.Node;
import ch.fhnw.algd2.ninemanmorris.gui.Token;

/**
 * Created by Claudio on 12.01.2017.
 */
public abstract class TurnState {
    protected Controller controller;

    public TurnState(Controller controller) {
        this.controller = controller;
    }

    public abstract TurnState update();
    public abstract Node validateToken(Token token);
    public abstract Node validateMove(double x, double y, Node root);
}
