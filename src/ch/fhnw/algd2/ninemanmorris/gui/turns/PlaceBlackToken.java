package ch.fhnw.algd2.ninemanmorris.gui.turns;

import ch.fhnw.algd2.ninemanmorris.gui.Controller;
import ch.fhnw.algd2.ninemanmorris.gui.Node;
import ch.fhnw.algd2.ninemanmorris.gui.Token;

/**
 * Created by Claudio on 12.01.2017.
 */
public class PlaceBlackToken extends TurnState {
    public PlaceBlackToken(Controller controller) {
        super(controller);
    }

    @Override
    public Node validateToken(Token token) {
        for(Node node : controller.getModel().getBlackStartTokens()) {
            if (node.getToken() == token) return node;
        }
        return null;
    }

    @Override
    public Node validateMove(double x, double y, Node root) {
        for(Node node : controller.getModel().getNodes()) {
            if (node.isInRange(x, y)) return node;
        }
        return null;
    }

    @Override
    public TurnState update() {
        if (controller.getModel().getWhiteStartTokens().stream().filter(node -> node.getToken() != null).count() > 0) {
            return controller.getTurnManager().placeWhiteTokens();
        } else {
            return controller.getTurnManager().whiteTurn();
        }
    }
}
