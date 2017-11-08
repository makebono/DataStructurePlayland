package com.makebono.datastructures.stack.stackinterface;

import com.makebono.datastructures.linkedlist.LLNode;

/** 
 * @ClassName: Stack 
 * @Description: Interface of stack
 * @author makebono
 * @date 2017年11月8日 下午4:16:57 
 *  
 */
public interface Stack<T> {
    void add(LLNode<T> node);

    LLNode<T> pop();

    void destroy();

    int size();

    LLNode<T> peek();
}
