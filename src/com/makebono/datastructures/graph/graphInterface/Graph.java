package com.makebono.datastructures.graph.graphInterface;

import java.util.ArrayList;
import java.util.Queue;

import com.makebono.datastructures.graph.DFSResult;
import com.makebono.datastructures.graph.Edge;
import com.makebono.datastructures.graph.Vertex;

/** 
 * @ClassName: Graph 
 * @Description: Graph interface
 * @author makebono
 * @date 2017年11月9日 下午6:03:08 
 *  
 */
public interface Graph<T> {

    ArrayList<Vertex<T>> getVertices();

    Queue<Edge<T>> getEdges();

    void add(Vertex<T> v1, Vertex<T> v2);

    void add(Vertex<T> vertex);

    int size();

    DFSResult<T> dfs();

    Graph<T> MST();

    void del(Vertex<T> v1, Vertex<T> v2);

    boolean cycleDetection();
}
