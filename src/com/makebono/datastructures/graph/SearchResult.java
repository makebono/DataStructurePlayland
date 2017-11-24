package com.makebono.datastructures.graph;

import java.util.ArrayList;

/** 
 * @ClassName: DFSResult 
 * @Description: A container of DFS result, includes a boolean value indicates is there cycle and arraylist for the traversal result.
 * @author makebono
 * @date 2017年11月14日 上午10:32:15 
 *  
 */
public class SearchResult<T> {
    private final boolean cycle;
    private final ArrayList<Vertex<T>> result;

    public SearchResult(final boolean cycle, final ArrayList<Vertex<T>> result) {
        this.cycle = cycle;
        this.result = result;
    }

    public boolean cycle() {
        return this.cycle;
    }

    public ArrayList<Vertex<T>> getResult() {
        return this.result;
    }
}
