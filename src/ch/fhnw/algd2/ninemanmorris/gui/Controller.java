package ch.fhnw.algd2.ninemanmorris.gui;

import javafx.scene.canvas.GraphicsContext;

/**
 * Created by Claudio on 10.01.2017.
 */
public class Controller {
    private GUI ui;
    private PModel model;

    public Controller(GUI ui, PModel model) {
        this.ui = ui;
        this.ui.setController(this);
        this.model = model;

        initGameGraph();
        drawGameGraph();
    }

    private void initGameGraph() {
        Node[] nodes = new Node[24];

        for(int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node();
        }

        for(int i = 0; i < 8; i++) {
            linkHorizontal(nodes, i);
        }

        int[] k = {0, 3, 6, 1, 16, 8, 5, 2};
        int[] ab = {9, 7, 5, 3, 3, 4, 8, 12};
        for(int i = 0; i < 8; i++) {
            linkVertical(nodes, k[i], ab[i], ab[7 - i]);
        }

        model.setNodes(nodes);
    }

    private void linkHorizontal(Node[] nodes, int i) {
            int k = i * 3;
            nodes[k].setLeft(nodes[k + 1]);
            nodes[k + 1].setRight(nodes[k]);
            nodes[k + 1].setLeft(nodes[k + 2]);
            nodes[k + 2].setRight(nodes[k + 1]);
    }

    private void linkVertical(Node[] nodes, int i, int a, int b) {
        nodes[i].setBottom(nodes[i + a]);
        nodes[i + a].setTop(nodes[i]);
        nodes[i + a].setBottom(nodes[i + a + b]);
        nodes[i + a + b].setTop(nodes[i + a]);
    }

    private void calculateNodePos(double a, double b) {
        //fix calculate as circle
        double[][] p = {{0, 0, 0.5},
                {0.15, 0.15, 0.35},
                {0.3, 0.3, 0.2},
                {0.5, 0, 0.15},
                {0.5, 0.7, 0.15},
                {0.7, 0.3, 0.2},
                {0.85, 0.15, 0.35},
                {1, 0, 0.5}};
        Node[] nodes = model.getNodes();
        for(int i = 0; i < p.length; i++) {
            for(int j = 0; j < p[i].length; j++) {
                int k = i * 3 + j;
                nodes[k].setX(p[i][1] * a + j * p[i][2] * a);
                nodes[k].setY(p[i][0] * b);
            }
        }
    }

    public void drawGameGraph() {
        GraphicsContext gc = ui.getGameArea().getGraphicsContext2D();
        double radius = 5;
        calculateNodePos(ui.getGameArea().getWidth() - 2 * radius , ui.getGameArea().getHeight() - 2 * radius);

        for (Node n : model.getNodes()) {
            gc.fillOval(n.getX(), n.getY(), 2 * radius, 2 * radius);

            if(n.getRight() != null) {
                gc.strokeLine(radius + n.getX(), radius + n.getY(), radius + n.getRight().getX(), radius + n.getRight().getY());
            }
            if(n.getBottom() != null) {
                gc.strokeLine(radius + n.getX(), radius + n.getY(), radius + n.getBottom().getX(), radius + n.getBottom().getY());
            }
        }
    }
}
