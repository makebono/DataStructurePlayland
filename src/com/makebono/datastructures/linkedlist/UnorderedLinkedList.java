package com.makebono.datastructures.linkedlist;

import java.util.Comparator;

import com.makebono.datastructures.linkedlist.abstractlist.AbstractLinkedList;

/** 
 * @ClassName: UnorderedLL 
 * @Description: Unordered linked list
 * @author makebono
 * @date 2017年11月8日 上午9:26:31 
 *  
 */
public class UnorderedLinkedList<T> extends AbstractLinkedList<T> {
    public UnorderedLinkedList(final Comparator<T> sideKick) {
        super(sideKick);
    }

    // For unordered list. Add new element to the tail.
    @Override
    public void add(final LLNode<T> node) {
        if (this.size() == 0) {
            this.setHead(node);
            this.setTail(node);
        } else {
            LLNode<T> cursor = this.getHead();
            while (cursor.hasNext()) {
                cursor = cursor.getNext();
            }
            cursor.setNext(node);
            this.setTail(node);
        }
        this.grow();
    }

}
