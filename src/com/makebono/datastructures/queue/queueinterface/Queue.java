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
    public void add(LLNode<T> node);

    public LLNode<T> poll();

    public void destroy();

    public int size();

    public LLNode<T> peek();
}
