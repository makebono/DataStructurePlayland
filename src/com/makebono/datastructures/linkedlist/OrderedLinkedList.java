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

    // Add element by order. May need to insert it between current existing elements. There are different cases.
    @Override
    public void add(final LLNode<T> node) {
        // Case 1: No element in the list.
        if (this.size() == 0) {
            this.setHead(node);
            this.setTail(node);
        } else {
            if (this.getByIndex(node.getIndex()) != null) {
                System.out.println("Index should be unique.");
                this.decline();
            } else {
                LLNode<T> cursor = this.getHead();
                // Case 2: New node smaller than the head. Insert it before the head.
                if (this.sideKick.compare(node.getData(), cursor.getData()) <= 0) {
                    node.setNext(cursor);
                    this.setHead(node);
                } else {
                    // Case 3: It's bigger than the head and only 1 element in the list now. Set it as tail.
                    if (!cursor.hasNext()) {
                        cursor.setNext(node);
                        this.setTail(node);
                    } else {
                        boolean added = false;
                        while (cursor.hasNext() && !added) {
                            // Case 4: It's bigger than head and less than tail. Insert it at proper position.
                            if (this.sideKick.compare(node.getData(), cursor.getNext().getData()) <= 0) {
                                node.setNext(cursor.getNext());
                                cursor.setNext(node);
                                added = true;
                            }
                            cursor = cursor.getNext();
                        }
                        // Case 5: Actually sames as case 3. It's larger than anyone else in the list, so becomes the
                        // tail.
                        if (!added) {
                            this.getTail().setNext(node);
                            this.setTail(node);
                        }
                    }
                }
            }
        }
        this.grow();
    }

}
