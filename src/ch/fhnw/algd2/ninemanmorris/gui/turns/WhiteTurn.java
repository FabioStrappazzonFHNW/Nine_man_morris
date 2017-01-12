package ch.fhnw.algd2.ninemanmorris.gui.turns;

import ch.fhnw.algd2.ninemanmorris.gui.Controller;
import ch.fhnw.algd2.ninemanmorris.gui.Node;
import ch.fhnw.algd2.ninemanmorris.gui.Token;

/**
 * Created by Claudio on 12.01.2017.
 */
public class WhiteTurn extends TurnState {
    public WhiteTurn(Controller controller) {
        super(controller);
    }

    @Override
    public Node validateToken(Token token) {
        if (token.isWhite()) {
            for(Node node : controller.getModel().getNodes()) {
                if (node.getToken() == token) return node;
            }
        }
        return null;
    }

    @Override
    public Node validateMove(double x, double y, Node root) {
        for(Node node : controller.getModel().getNodes()) {
            if (node.isInRange(x, y) && node.isNeighbor(root)) return node;
        }
        return null;
    }

    @Override
    public TurnState update() {
        return controller.getTurnManager().blackTurn();
    }
}
