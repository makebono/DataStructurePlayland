package com.makebono.datastructures.queue.queueinterface;

import com.makebono.datastructures.linkedlist.LLNode;

/** 
 * @ClassName: Queue 
 * @Description: Interface for queue
 * @author makebono
 * @date 2017年11月8日 下午3:27:48 
 *  
 */
public interface Queue<T> {
    void add(LLNode<T> node);

    LLNode<T> poll();

    void destroy();

    int size();

    LLNode<T> peek();
}
