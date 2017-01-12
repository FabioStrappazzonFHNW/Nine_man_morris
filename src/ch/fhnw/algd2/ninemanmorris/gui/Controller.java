package ch.fhnw.algd2.ninemanmorris.gui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Created by Claudio on 10.01.2017.
 */
public class Controller {
    private Turn turn;
    private GUI ui;
    private PModel model;

    public Controller(GUI ui, PModel model, Turn turn) {
        this.ui = ui;
        this.ui.setController(this);
        this.model = model;
        this.turn = turn;

        for(Node node : GameGraph.init()) model.getNodes().add(node);
        initPlayer2token(model.getPlayer1(), 9, true);
        initPlayer2token(model.getPlayer2(),9, false);
        drawBackground(880, 700);
        drawTokens(model.getPlayer1());
        drawTokens(model.getPlayer2());
    }

    public PModel getModel() {
        return model;
    }

    private void initPlayer2token(ArrayList<Node> player, int nToken, boolean white) {
        player.add(new Node()); //Label
        for (int i = 0; i < nToken; i++) {
            player.add(new Node(new Token(white)));
        }
    }

    public void drawBackground(double width, double height) {
        double m = height - 2 * model.getBorder();
        double x0 = (width - m) / 2;
        double y0 = model.getBorder();
        double g = m / 10;

        ui.getGameBackground().getGraphicsContext2D().clearRect(0, 0, width, height);

        calculateNodePos(model.getNodes(), x0, y0, m);
        calculatePlayerNode(model.getPlayer1(), model.getBorder(), y0, g);
        calculatePlayerNode(model.getPlayer2(), width - model.getBorder(), y0, g);

        drawGameGraph();
    }

    private void calculateNodePos(ArrayList<Node> nodes, double x0, double y0, double m) {
        //fix calculate as circle
        double[][] p = {{0, 0, 0.5},
                {0.15, 0.15, 0.35},
                {0.3, 0.3, 0.2},
                {0.5, 0, 0.15},
                {0.5, 0.7, 0.15},
                {0.7, 0.3, 0.2},
                {0.85, 0.15, 0.35},
                {1, 0, 0.5}};
        for(int i = 0; i < p.length; i++) {
            for(int j = 0; j < 3; j++) {
                Node node = nodes.get(i * 3 + j);
                double x = x0 + p[i][1] * m + j * p[i][2] * m;
                double y = y0 + p[i][0] * m;
                node.setX(x);
                node.setY(y);

                Token token = node.getToken();
                if (token != null) {
                    token.setX(x);
                    token.setY(y);
                }
            }
        }
    }

    private void calculatePlayerNode(ArrayList<Node> playerNode, double x0, double y0, double g) {
        for (int i = 0; i < playerNode.size(); i++) {
            Node node = playerNode.get(i);
            node.setX(x0);
            node.setY(y0 + i * g);

            Token token = node.getToken();
            if (token != null) {
                token.setX(x0);
                token.setY(y0 + i * g);
            }

        }
    }

    private void drawGameGraph() {
        GraphicsContext gc = ui.getGameBackground().getGraphicsContext2D();
        double radius = model.getNodeRadius();
        gc.setFill(model.getGameGraphColor());
        gc.setStroke(model.getGameGraphColor());

        for (Node n : model.getNodes()) {
            gc.fillOval(n.getX() - radius, n.getY() - radius, 2 * radius, 2 * radius);

            if(n.getRight() != null) {
                gc.strokeLine(n.getX(), n.getY(), n.getRight().getX(), n.getRight().getY());
            }
            if(n.getBottom() != null) {
                gc.strokeLine(n.getX(), n.getY(), n.getBottom().getX(), n.getBottom().getY());
            }
        }
    }

    private void drawTokens(ArrayList<Node> player) {
        player.stream().skip(1).forEach(node -> {
            TokenShape tokenShape = new TokenShape(this, node.getToken());
            ui.getTokenPane().getChildren().add(tokenShape);
        });
    }

    public Node getNodeInRange(double x, double y, Node root) {
        for(Node node : model.getNodes()) {
            if (node.isInRange(x, y, root)) return node;
        }
        return null;
    }

    public Node validateMove(double x, double y, Node root) {
        return turn.validateMove(x, y, root);
    }

//    public void setMovingTokenColor(Token token) {
//        token.setFillColor(token.isWhite() ? model.getWhiteMove() : model.getBlackMove());
//    }
//
    public void setNormalTokenColor(Token token) {
        token.setFillColor(token.isWhite() ? model.getWhite() : model.getBlack());
    }

    public Node validateToken(Token token) {
        return turn.validateToken(token);
    }

    public Node findNodeInGame(Token token) {
        for(Node node : model.getNodes()) {
            if (node.getToken() == token) return node;
        }
        return null;
    }

    public Node findNodeInWhite(Token token) {
        for(Node node : model.getPlayer1()) {
            if (node.getToken() == token) return node;
        }
        return null;
    }

    public Node findNodeInBlack(Token token) {
        for(Node node : model.getPlayer2()) {
            if (node.getToken() == token) return node;
        }
        return null;
    }
}
