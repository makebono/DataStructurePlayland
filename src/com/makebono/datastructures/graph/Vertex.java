package com.makebono.datastructures.graph;

import java.util.ArrayList;

import com.makebono.datastructures.tools.genericnode.GenericNode;

/** 
 * @ClassName: Vertex 
 * @Description: Vertex class
 * @author makebono
 * @date 2017年11月9日 下午6:04:12 
 *  
 */
public class Vertex<T> extends GenericNode<T> {
    private final double x;
    private final double y;
    private int degree;
    private final ArrayList<Edge<T>> edges;
    // For backtracking in dfs.
    private Vertex<T> parent;

    public Vertex(final int index, final T data) {
        this.index = index;
        this.data = data;
        this.x = 0;
        this.y = 0;
        this.degree = 0;
        this.edges = new ArrayList<Edge<T>>();
        this.parent = null;
    }

    public Vertex(final int index, final T data, final double x, final double y) {
        super(index, data);
        this.x = x;
        this.y = y;
        this.degree = 0;
        this.edges = new ArrayList<Edge<T>>();
        this.parent = null;
    }

    // Clone a 'clean'(without edges attached) vertex.
    public Vertex(final Vertex<T> vertex) {
        this.index = vertex.getIndex();
        this.data = vertex.getData();
        this.x = vertex.getX();
        this.y = vertex.getY();
        this.degree = vertex.getDegree();
        this.edges = new ArrayList<Edge<T>>();
    }

    public void setParent(final Vertex<T> parent) {
        this.parent = parent;
    }

    public Vertex<T> getParent() {
        return this.parent;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public int getDegree() {
        return this.degree;
    }

    public void setDegree(final int degree) {
        this.degree = degree;
    }

    public void increaseDegree() {
        this.degree++;
    }

    // See if there's an edge connecting this and target vertex. If not, return null, if there is, don't care about the
    // direction, just return it.
    public Edge<T> getEdge(final Vertex<T> v2) {
        for (final Edge<T> cursor : this.getEdges()) {
            if (cursor.getV2().getIndex() == v2.getIndex()) {
                return cursor;
            }
        }

        for (final Edge<T> cursor : v2.getEdges()) {
            if (cursor.getV2().getIndex() == this.getIndex()) {
                return cursor;
            }
        }

        return null;
    }

    public ArrayList<Edge<T>> getEdges() {
        return edges;
    }

    public double dist(final Vertex<T> target) {
        double result;
        result = Math.pow(this.getX() - target.getX(), 2) + Math.pow(this.getY() - target.getY(), 2);
        result = Math.sqrt(result);
        return result;
    }

    public void addEdge(final Edge<T> edge) {
        this.edges.add(edge);
    }

    @Override
    public String toString() {
        return "V" + this.getIndex() + "(" + this.getX() + ", " + this.getY() + ") ";
    }
}
