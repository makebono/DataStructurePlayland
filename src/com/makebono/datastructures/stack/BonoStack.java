package com.makebono.datastructures.stack;

import java.util.Comparator;

import com.makebono.datastructures.linkedlist.LLNode;
import com.makebono.datastructures.linkedlist.UnorderedLinkedList;
import com.makebono.datastructures.stack.stackinterface.Stack;

/** 
 * @ClassName: BonoStack 
 * @Description: Stack implementation, stack this up to build a Tower of Babel with Bono
 * @author makebono
 * @date 2017年11月8日 下午4:21:10 
 *  
 */
public class BonoStack<T> extends UnorderedLinkedList<T> implements Stack<T> {
    public BonoStack(final Comparator<T> sideKick) {
        super(sideKick);
    }

    @Override
    public LLNode<T> pop() {
        final LLNode<T> temp = this.getTail();
        this.delByIndex(this.getTail().getIndex());
        return temp;
    }

    @Override
    public LLNode<T> peek() {
        return this.getTail();
    }

}
