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
    private final ArrayList<Edge<T>> edges;

    public Vertex(final int index, final T data, final double x, final double y) {
        super(index, data);
        this.x = x;
        this.y = y;
        this.edges = new ArrayList<Edge<T>>();
    }

    public void addEdge(final Vertex<T> vertex) {
        this.edges.add(new Edge<T>(this, vertex));
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public ArrayList<Edge<T>> getEdges() {
        return this.edges;
    }

    public double dist(final Vertex<T> target) {
        double result;
        result = Math.pow(this.getX() - target.getX(), 2) + Math.pow(this.getY() - target.getY(), 2);
        result = Math.sqrt(result);
        return result;
    }
}
