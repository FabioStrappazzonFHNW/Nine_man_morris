package ch.fhnw.algd2.ninemanmorris.gui;

import java.util.ArrayList;

/**
 * Created by Claudio on 10.01.2017.
 */
public class GameGraph {
    public static Node[] init() {
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

        return nodes;
    }

    private static void linkHorizontal(Node[] nodes, int i) {
        int k = i * 3;
        nodes[k].setLeft(nodes[k + 1]);
        nodes[k + 1].setRight(nodes[k]);
        nodes[k + 1].setLeft(nodes[k + 2]);
        nodes[k + 2].setRight(nodes[k + 1]);
    }

    private static void linkVertical(Node[] nodes, int i, int a, int b) {
        nodes[i].setBottom(nodes[i + a]);
        nodes[i + a].setTop(nodes[i]);
        nodes[i + a].setBottom(nodes[i + a + b]);
        nodes[i + a + b].setTop(nodes[i + a]);
    }

    public static void calculateNodePos(ArrayList<Node> nodes, double border, double a, double b) {
        double x = a - 2 * border;
        double y = b - 2 * border;
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
                int k = i * 3 + j;
                nodes.get(k).setX(border + p[i][1] * x + j * p[i][2] * x);
                nodes.get(k).setY(border + p[i][0] * y);
            }
        }
    }
}
