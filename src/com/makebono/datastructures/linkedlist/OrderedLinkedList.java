package com.makebono.datastructures.linkedlist;

import java.util.Comparator;

import com.makebono.datastructures.linkedlist.abstractlist.AbstractLinkedList;

/** 
 * @ClassName: OrderedLinkedList 
 * @Description: Ordered linked list. Ordered by the data contains in nodes. 
 * @author makebono
 * @date 2017年11月8日 上午10:56:03 
 *  
 */
public class OrderedLinkedList<T> extends AbstractLinkedList<T> {
    public OrderedLinkedList(final Comparator<T> sideKick) {
        super(sideKick);
    }

    @Override
    public void add(final LLNode<T> node) {
        if (this.size() == 0) {
            this.setHead(node);
            this.setTail(node);
        } else {
            LLNode<T> cursor = this.getHead();
            if (this.sideKick.compare(node.getData(), cursor.getData()) <= 0) {
                node.setNext(cursor);
                this.setHead(node);
            } else {
                if (!cursor.hasNext()) {
                    cursor.setNext(node);
                    this.setTail(node);
                } else {
                    boolean added = false;
                    while (cursor.hasNext() && !added) {
                        if (this.sideKick.compare(node.getData(), cursor.getNext().getData()) <= 0) {
                            node.setNext(cursor.getNext());
                            cursor.setNext(node);
                            added = true;
                        }
                        cursor = cursor.getNext();
                    }
                    if (!added) {
                        this.getTail().setNext(node);
                        this.setTail(node);
                    }
                }
            }
        }
        this.grow();
    }

}
