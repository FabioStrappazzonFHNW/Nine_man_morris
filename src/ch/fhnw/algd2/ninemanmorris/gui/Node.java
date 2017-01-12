package ch.fhnw.algd2.ninemanmorris.gui;

/**
 * Created by Claudio on 10.01.2017.
 */

public class Node {
    private static final double range = 20;

    private Node right, bottom, left, top;
    private Token token;
    private double x, y;

    public Node() {
        //default ctr
    }

    public Node(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getBottom() {
        return bottom;
    }

    public void setBottom(Node bottom) {
        this.bottom = bottom;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public boolean isInRange(double x, double y, Node root) {
        boolean neighbour = true;
        if (root != null) {
            neighbour = (root.top == this || root.right == this || root.bottom == this || root.left == this);
        }
        return neighbour && (token == null) &&
                ((x  - this.x) * (x  - this.x) + (y - this.y) * (y - this.y) <= range * range);
    }
}
