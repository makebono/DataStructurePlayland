package com.makebono.datastructures.queue;

import java.util.Comparator;

import com.makebono.datastructures.linkedlist.LLNode;
import com.makebono.datastructures.linkedlist.OrderedLinkedList;
import com.makebono.datastructures.queue.queueinterface.Queue;

/** 
 * @ClassName: PriorityBonoQueue 
 * @Description: Forget about its name, it's just an priority queue.
 * @author makebono
 * @date 2017年11月8日 下午4:05:08 
 *  
 */
public class PriorityBonoQueue<T> extends OrderedLinkedList<T> implements Queue<T> {
    public PriorityBonoQueue(final Comparator<T> sideKick) {
        super(sideKick);
    }

    @Override
    public LLNode<T> poll() {
        final LLNode<T> temp = this.getHead();
        this.del(this.getHead().getData());
        return temp;
    }

    @Override
    public LLNode<T> peek() {
        return this.getHead();
    }

}
