package com.makebono.datastructures.twotritree.twotritreeinterface;

import java.util.ArrayList;

import com.makebono.datastructures.twotritree.Bono23Node;

/** 
 * @ClassName: TwoTriTree 
 * @Description: 2-3 tree interface
 * @author makebono
 * @date 2017年12月22日 上午9:36:25 
 *  
 */
public interface TwoTriTree<T> {
    int size();

    ArrayList<Bono23Node<T>> bfs23();

    void addNode(Bono23Node<T> node);

    void del(T key);

    Bono23Node<T> search(T key);
}
