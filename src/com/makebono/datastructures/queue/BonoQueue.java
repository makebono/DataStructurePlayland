/**   
 * @Title: BonoQueue.java 
 * @Package com.makebono.datastructures.queue 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangxj
 * @date 2017年11月8日 下午3:31:00  
 */
package com.makebono.datastructures.queue;

import java.util.Comparator;

import com.makebono.datastructures.linkedlist.LLNode;
import com.makebono.datastructures.linkedlist.UnorderedLinkedList;
import com.makebono.datastructures.queue.queueinterface.Queue;

/** 
 * @ClassName: BonoQueue 
 * @Description: Forget about the name, it's just a queue.
 * @author makebono
 * @date 2017年11月8日 下午3:31:00 
 *  
 */
public class BonoQueue<T> extends UnorderedLinkedList<T> implements Queue<T> {
    public BonoQueue(final Comparator<T> sideKick) {
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
