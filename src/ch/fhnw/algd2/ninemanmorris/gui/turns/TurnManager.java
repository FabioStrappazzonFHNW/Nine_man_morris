package ch.fhnw.algd2.ninemanmorris.gui.turns;

import ch.fhnw.algd2.ninemanmorris.gui.Controller;

/**
 * Created by Claudio on 12.01.2017.
 */
public class TurnManager {
    private TurnState currentTurnState;
    private TurnState[] states;

    public void initTurnManager(Controller controller) {
        this.states = new TurnState[] {
                new PlaceWhiteToken(controller),
                new PlaceBlackToken(controller),
                new WhiteTurn(controller),
                new BlackTurn(controller)
        };
        currentTurnState = states[0];
    }

    public void update() {
        currentTurnState = currentTurnState.update();
    }

    public TurnState placeWhiteTokens() {
        return states[0];
    }

    public TurnState placeBlackTokens() {
        return states[1];
    }

    public TurnState whiteTurn() {
        return states[2];
    }

    public TurnState blackTurn() {
        return states[3];
    }

    public TurnState getCurrentTurnState() {
        return currentTurnState;
    }

    public void setRemoveState() {

    }

}
