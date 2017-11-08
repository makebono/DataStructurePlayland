package com.makebono.datastructures.linkedlist.linkedlistinterface;

import com.makebono.datastructures.linkedlist.LLNode;

/** 
 * @ClassName: LinkedList 
 * @Description: Interface
 * @author makebono
 * @date 2017年11月8日 上午11:19:37 
 *  
 */
public interface LinkedList<T> {
    void add(LLNode<T> node);

    boolean del(T data);

    boolean delByIndex(int index);

    void destroy();

    LLNode<T> get(T data);

    LLNode<T> getByIndex(int index);

    LLNode<T> getHead();

    LLNode<T> getTail();

    int size();

}
