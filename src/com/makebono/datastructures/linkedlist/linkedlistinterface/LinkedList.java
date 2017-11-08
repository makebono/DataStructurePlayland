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
    public void add(LLNode<T> node);

    public boolean del(T data);

    public boolean delByIndex(int index);

    public void destroy();

    public LLNode<T> get(T data);

    public LLNode<T> getByIndex(int index);

    public LLNode<T> getHead();

    public LLNode<T> getTail();

    public int size();

}
