package com.makebono.datastructures.graph;

/** 
 * @ClassName: Edge 
 * @Description: Edge
 * @author makebono
 * @date 2017年11月10日 上午11:49:59 
 *  
 */
public class Edge<T> {
    private final Vertex<T> v1;
    private final Vertex<T> v2;
    private double weight;
    private int capacity;
    private int residualCapacity;
    private int flow;

    public Edge(final Vertex<T> v1, final Vertex<T> v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = v1.dist(v2);
        this.capacity = 0;
        this.flow = 0;
    }

    public Edge(final Vertex<T> v1, final Vertex<T> v2, final int capacity) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = v1.dist(v2);
        this.setCapacity(capacity);
        this.flow = 0;
        this.residualCapacity = capacity;
    }

    public Edge(final Vertex<T> v1, final Vertex<T> v2, final int capacity, final int flow) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = v1.dist(v2);
        this.setCapacity(capacity);
        this.flow = flow;
        this.residualCapacity = capacity - flow;
    }

    // Set residual capacity, and return true if it is an inverted edge. For example
    // e(v1,v2) == null && e(v2,v1) != null
    public boolean setResidualCapacity(final Vertex<T> v1, final Vertex<T> v2) {
        if (this.v1.getIndex() == v1.getIndex() && this.v2.getIndex() == v2.getIndex()) {
            this.residualCapacity = this.capacity - this.flow;
            return false;
        } else if (v2.getIndex() == this.v1.getIndex() && v1.getIndex() == this.v2.getIndex()) {
            this.residualCapacity = this.flow;
            return true;
        } else {
            this.residualCapacity = 0;
            return false;
        }
    }

    private void setCapacity(final int capacity) {
        if (capacity >= 0) {
            this.capacity = capacity;
        } else {
            this.capacity = 0;
        }
    }

    public boolean setFlow(final int flow) {
        if (flow <= this.capacity) {
            this.flow = flow;
            this.setResidualCapacity(this.v1, this.v2);
            return true;
        }
        return false;
    }

    public int getResidualCapacity() {
        return this.residualCapacity;
    }

    public int getFlow() {
        return this.flow;
    }

    public Vertex<T> getV1() {
        return v1;
    }

    public Vertex<T> getV2() {
        return v2;
    }

    public void setWeight(final double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public Edge<T> getInvertedEdge() {
        return this.getV2().getEdge(this.getV1());
    }

    @Override
    public String toString() {
        return "E(V" + this.getV1().getIndex() + ", V" + this.getV2().getIndex() + ") ";
    }
}
