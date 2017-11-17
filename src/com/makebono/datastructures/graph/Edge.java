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
    private final double weight;

    public Edge(final Vertex<T> v1, final Vertex<T> v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = v1.dist(v2);
    }

    public Vertex<T> getV1() {
        return v1;
    }

    public Vertex<T> getV2() {
        return v2;
    }

    public double getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return "E(V" + this.getV1().getIndex() + ", V" + this.getV2().getIndex() + ") ";
    }
}
