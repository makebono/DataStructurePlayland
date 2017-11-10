package com.makebono.datastructures.graph;

import java.util.LinkedHashSet;

import com.makebono.datastructures.graph.graphInterface.Graph;

/** 
 * @ClassName: BonoGraph 
 * @Description: Graph implementation. For easy manipulation, this would be a undirected graph. 
 * @author makebono
 * @date 2017年11月10日 上午11:34:29 
 *  
 */
public class BonoGraph<T> implements Graph<T> {
    private final Vertex<T> origin;
    private int size;

    public BonoGraph() {
        this.origin = null;
        this.size = 0;
    }

    public BonoGraph(final Vertex<T> origin) {
        this.origin = origin;
        if (origin != null) {
            this.size = 1;
        }
    }

    public int getSize() {
        return size;
    }

    public Vertex<T> getOrigin() {
        return this.origin;
    }

    public void add(final Vertex<T> v1, final Vertex<T> v2) {
        v1.addEdge(v2);
        size++;
    }

    public LinkedHashSet<T> bfs() {
        //
        return null;
    }
}
