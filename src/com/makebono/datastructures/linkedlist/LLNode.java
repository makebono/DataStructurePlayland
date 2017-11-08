package com.makebono.datastructures.linkedlist;

import com.makebono.datastructures.tools.genericnode.GenericNode;

/** 
 * @ClassName: LLNode 
 * @Description: Node for linked list. Nothing special. Single linked and not cyclic.
 * @author makebono
 * @date 2017年11月8日 上午9:16:09 
 *  
 */
public class LLNode<T> extends GenericNode<T> {
    private LLNode<T> next;

    public LLNode() {
        super();
        this.next = null;
    }

    public LLNode(final int index, final T data) {
        super(index, data);
        this.next = null;
    }

    public void setNext(final LLNode<T> next) {
        this.next = next;
    }

    public LLNode<T> getNext() {
        return this.next;
    }

    public boolean hasNext() {
        return this.next != null;
    }
}
