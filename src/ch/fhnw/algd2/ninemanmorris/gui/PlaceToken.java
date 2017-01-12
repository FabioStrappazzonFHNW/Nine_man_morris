package ch.fhnw.algd2.ninemanmorris.gui;

/**
 * Created by Claudio on 12.01.2017.
 */
public class PlaceToken extends Turn {
    private int turnNumber;

    public PlaceToken (Controller controller, int turnNumber) {
        super(controller);
        this.turnNumber = turnNumber;
    }

    private boolean isWithitsTurn() {
        return (turnNumber & 1) == 0;
    }

    @Override
    public Node validateToken(Token token) {
        if (isWithitsTurn()) {
            return controller.findNodeInWhite(token);
        } else {
            return controller.findNodeInBlack(token);
        }
    }

    @Override
    public Node validateMove(double x, double y, Node root) {
        return controller.getNodeInRange(x, y, null);
    }
}
