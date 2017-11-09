package com.makebono.datastructures.queue;

import com.makebono.datastructures.linkedlist.LLNode;
import com.makebono.datastructures.linkedlist.UnorderedLinkedList;
import com.makebono.datastructures.queue.queueinterface.Queue;
import com.makebono.datastructures.tools.roundrobincomparator.RoundRobinComparator;

/** 
 * @ClassName:  BonoQueue 
 * @Description: Queue for Round Robin scheduling, input format is LLNode(index,data). data is a int array, 
 * data[0] is the data and data[1] is considered the job load(time to finish).
 * @author makebono
 * @date 2017年11月9日 上午8:39:19 
 *  
 */
public class RoundRobinBonoQueue<T> extends UnorderedLinkedList<int[]> implements Queue<int[]> {
    private int quantum;

    public RoundRobinBonoQueue(final RoundRobinComparator<int[]> sideKick, final int quantum) {
        super(sideKick);
        this.quantum = quantum;
    }

    public void setQuantum(final int quantum) {
        this.quantum = quantum;
    }

    public int getQuantum() {
        return this.quantum;
    }

    @Override
    public LLNode<int[]> poll() {
        final LLNode<int[]> temp = this.getHead();
        final int jobLoad = temp.getData()[1];

        this.delByIndex(this.getHead().getIndex());

        if (jobLoad > this.getQuantum()) {
            final int index = temp.getIndex();
            final int[] newData = new int[2];
            newData[0] = temp.getData()[0];
            newData[1] = temp.getData()[1] - this.getQuantum();

            this.add(new LLNode<int[]>(index, newData));
        }

        return temp;
    }

    @Override
    public LLNode<int[]> peek() {
        return this.getHead();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        if (this.size() == 0) {
            sb.append("This is an empty list");
        } else {
            sb.append("This is a " + this.getClass().getName());
            sb.append(". It has nodes: \n");
            LLNode<int[]> cursor = this.getHead();
            sb.append("Node(" + cursor.getIndex() + ", " + cursor.getData()[0] + ", " + cursor.getData()[1] + ") ");
            while (cursor.hasNext()) {
                cursor = cursor.getNext();
                sb.append("Node(" + cursor.getIndex() + ", " + cursor.getData()[0] + ", " + cursor.getData()[1] + ") ");
            }
            sb.append("\nIts size is: " + this.size() + ".");
        }
        return sb.toString();
    }

}
