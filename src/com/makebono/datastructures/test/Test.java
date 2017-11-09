package com.makebono.datastructures.test;

import com.makebono.datastructures.linkedlist.LLNode;
import com.makebono.datastructures.queue.RoundRobinBonoQueue;
import com.makebono.datastructures.tools.roundrobincomparator.RoundRobinComparator;

/** 
 * @ClassName: Test 
 * @Description: Test class for data structures
 * @author makebono
 * @date 2017年11月7日 上午10:03:04 
 *  
 */
public class Test {
    public static <T> void main(final String[] args) {
        /*
        final BSTNode<int[]> n1 = new BSTNode<int[]>(1, 5);
        final BSTNode<int[]> n3 = new BSTNode<int[]>(3, 2);
        final BSTNode<int[]> n4 = new BSTNode<int[]>(4, 10);
        final BSTNode<int[]> n5 = new BSTNode<int[]>(5, 15);
        final BSTNode<int[]> n6 = new BSTNode<int[]>(6, 1);
        final BSTNode<int[]> n7 = new BSTNode<int[]>(7, 3);
        final BSTNode<int[]> n8 = new BSTNode<int[]>(8, 0);
        final BSTNode<int[]> n9 = new BSTNode<int[]>(9, 16);
        final BSTNode<int[]> n10 = new BSTNode<int[]>(10, 9);
        final BSTNode<int[]> n11 = new BSTNode<int[]>(11, 8);
        final BSTNode<int[]> n12 = new BSTNode<int[]>(12, 7);
        final BSTNode<int[]> n13 = new BSTNode<int[]>(13, 12);
        
        final TComparator<int[]> sideKick = new TComparator<int[]>();
        final BinarySearchTree<int[]> bst = new BinarySearchTree<int[]>(n1, sideKick);
        
        bst.addNode(n3);
        bst.addNode(n4);
        bst.addNode(n5);
        bst.addNode(n6);
        bst.addNode(n7);
        bst.addNode(n8);
        bst.addNode(n9);
        bst.addNode(n10);
        bst.addNode(n11);
        bst.addNode(n12);
        bst.addNode(n13);
        
        bst.del(33);
        bst.del(5);
        bst.delByIndex(99);
        bst.delByIndex(9);
        System.out.println(bst);
        bst.destroy();
        System.out.println(bst);
        bst.del(3);
        bst.delByIndex(1);
        
        final TComparator<int[]> sideKick = new TComparator<int[]>();
        
        final LLNode<int[]> n1 = new LLNode<int[]>(1, 5);
        final LLNode<int[]> n2 = new LLNode<int[]>(2, 2);
        final LLNode<int[]> n3 = new LLNode<int[]>(3, 6);
        final LLNode<int[]> n4 = new LLNode<int[]>(4, 3);
        final LLNode<int[]> n5 = new LLNode<int[]>(5, 4);
        final LLNode<int[]> n6 = new LLNode<int[]>(6, 1);
        final LLNode<int[]> nn1 = new LLNode<int[]>(1, 5);
        final LLNode<int[]> nn2 = new LLNode<int[]>(2, 2);
        final LLNode<int[]> nn3 = new LLNode<int[]>(3, 6);
        final LLNode<int[]> nn4 = new LLNode<int[]>(4, 3);
        final LLNode<int[]> nn5 = new LLNode<int[]>(5, 4);
        final LLNode<int[]> nn6 = new LLNode<int[]>(6, 1);
        
        final LinkedList<int[]> oll = new OrderedLinkedList<int[]>(sideKick);
        final LinkedList<int[]> ull = new UnorderedLinkedList<int[]>(sideKick);
        
        oll.add(n1);
        oll.add(n2);
        oll.add(n3);
        oll.add(n4);
        oll.add(n5);
        oll.add(n6);
        System.out.println(oll);
        
        ull.add(nn1);
        ull.add(nn2);
        ull.add(nn3);
        ull.add(nn4);
        ull.add(nn5);
        ull.add(nn6);
        System.out.println(ull);
        
        oll.del(5);
        oll.delByIndex(5);
        oll.del(333);
        oll.delByIndex(123);
        System.out.println(oll);
        
        ull.del(5);
        ull.delByIndex(5);
        ull.del(333);
        ull.delByIndex(123);
        System.out.println(ull);
        
        oll.destroy();
        System.out.println(oll);
        
        final TComparator<int[]> sideKick = new TComparator<int[]>();
        final HashFunction hf = new ExampleHashFunction();
        
        final BSTNode<int[]> n1 = new BSTNode<int[]>(1, 5);
        final BSTNode<int[]> n3 = new BSTNode<int[]>(3, 2);
        final BSTNode<int[]> n4 = new BSTNode<int[]>(4, 10);
        final BSTNode<int[]> n5 = new BSTNode<int[]>(5, 15);
        final BSTNode<int[]> n6 = new BSTNode<int[]>(6, 1);
        final BSTNode<int[]> n7 = new BSTNode<int[]>(7, 3);
        final BSTNode<int[]> n8 = new BSTNode<int[]>(8, 0);
        final BSTNode<int[]> n9 = new BSTNode<int[]>(9, 16);
        final BSTNode<int[]> n10 = new BSTNode<int[]>(10, 9);
        final BSTNode<int[]> n11 = new BSTNode<int[]>(11, 8);
        final BSTNode<int[]> n12 = new BSTNode<int[]>(12, 7);
        final BSTNode<int[]> n13 = new BSTNode<int[]>(13, 12);
        
        final HashTable<int[]> ht = new HashTable<int[]>(4, hf, sideKick);
        ht.add(n1);
        ht.add(n3);
        ht.add(n4);
        ht.add(n5);
        ht.add(n6);
        ht.add(n7);
        ht.add(n8);
        ht.add(n9);
        ht.add(n10);
        ht.add(n11);
        ht.add(n12);
        ht.add(n13);
        
        System.out.println(ht);
        System.out.println(ht.get(1));
        
        ht.del(1);
        ht.del(111);
        System.out.println(ht);
        
        ht.destroy();
        System.out.println(ht);
        
        final TComparator<int[]> sideKick = new TComparator<int[]>();
        
        final LLNode<int[]> n1 = new LLNode<int[]>(1, 5);
        final LLNode<int[]> n2 = new LLNode<int[]>(2, 2);
        final LLNode<int[]> n3 = new LLNode<int[]>(3, 6);
        final LLNode<int[]> n4 = new LLNode<int[]>(4, 3);
        final LLNode<int[]> n5 = new LLNode<int[]>(5, 4);
        final LLNode<int[]> n6 = new LLNode<int[]>(6, 1);
        final LLNode<int[]> nn1 = new LLNode<int[]>(1, 5);
        final LLNode<int[]> nn2 = new LLNode<int[]>(2, 2);
        final LLNode<int[]> nn3 = new LLNode<int[]>(3, 6);
        final LLNode<int[]> nn4 = new LLNode<int[]>(4, 3);
        final LLNode<int[]> nn5 = new LLNode<int[]>(5, 4);
        final LLNode<int[]> nn6 = new LLNode<int[]>(6, 1);
        final LLNode<int[]> nnn1 = new LLNode<int[]>(1, 5);
        final LLNode<int[]> nnn2 = new LLNode<int[]>(2, 2);
        final LLNode<int[]> nnn3 = new LLNode<int[]>(3, 6);
        final LLNode<int[]> nnn4 = new LLNode<int[]>(4, 3);
        final LLNode<int[]> nnn5 = new LLNode<int[]>(5, 4);
        final LLNode<int[]> nnn6 = new LLNode<int[]>(6, 1);
        
        final Queue<int[]> q = new BonoQueue<int[]>(sideKick);
        final Queue<int[]> q2 = new PriorityBonoQueue<int[]>(sideKick);
        final Stack<int[]> s = new BonoStack<int[]>(sideKick);
        q.add(n1);
        q.add(n2);
        q.add(n3);
        q.add(n4);
        q.add(n5);
        q.add(n6);
        q2.add(nn1);
        q2.add(nn2);
        q2.add(nn3);
        q2.add(nn4);
        q2.add(nn5);
        q2.add(nn6);
        s.add(nnn1);
        s.add(nnn2);
        s.add(nnn3);
        s.add(nnn4);
        s.add(nnn5);
        s.add(nnn6);
        s.add(new LLNode<int[]>(1, 333));
        System.out.println(q);
        System.out.println(q2);
        System.out.println(s);
        
        final int size = s.size();
        for (int i = 0; i < size; i++) {
            System.out.printf("Poping out from stack: %d\n", s.pop().getIndex());
        }
        System.out.println(s);
        */

        final LLNode<int[]> n1 = new LLNode<int[]>(1, new int[] { 5, 20 });
        final LLNode<int[]> n2 = new LLNode<int[]>(2, new int[] { 6, 15 });
        final LLNode<int[]> n3 = new LLNode<int[]>(3, new int[] { 1, 10 });
        final LLNode<int[]> n4 = new LLNode<int[]>(4, new int[] { 5, 11 });
        final LLNode<int[]> n5 = new LLNode<int[]>(5, new int[] { 9, 20 });
        final LLNode<int[]> n6 = new LLNode<int[]>(6, new int[] { 11, 9 });

        final RoundRobinComparator<int[]> sideKick = new RoundRobinComparator<int[]>();

        final RoundRobinBonoQueue<int[]> rrq = new RoundRobinBonoQueue<int[]>(sideKick, 10);

        rrq.add(n1);
        rrq.add(n2);
        rrq.add(n3);
        rrq.add(n4);
        rrq.add(n5);
        rrq.add(n6);

        System.out.println(rrq);

        rrq.poll();
        rrq.poll();
        rrq.poll();
        rrq.poll();
        rrq.poll();
        rrq.poll();
        System.out.println(rrq);

    }
}
