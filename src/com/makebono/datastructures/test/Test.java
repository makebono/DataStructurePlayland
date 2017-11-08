package com.makebono.datastructures.test;

import com.makebono.datastructures.linkedlist.LLNode;
import com.makebono.datastructures.queue.BonoQueue;
import com.makebono.datastructures.queue.PriorityBonoQueue;
import com.makebono.datastructures.queue.queueinterface.Queue;
import com.makebono.datastructures.tools.tcomparator.TComparator;

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
        final BSTNode<Integer> n1 = new BSTNode<Integer>(1, 5);
        final BSTNode<Integer> n3 = new BSTNode<Integer>(3, 2);
        final BSTNode<Integer> n4 = new BSTNode<Integer>(4, 10);
        final BSTNode<Integer> n5 = new BSTNode<Integer>(5, 15);
        final BSTNode<Integer> n6 = new BSTNode<Integer>(6, 1);
        final BSTNode<Integer> n7 = new BSTNode<Integer>(7, 3);
        final BSTNode<Integer> n8 = new BSTNode<Integer>(8, 0);
        final BSTNode<Integer> n9 = new BSTNode<Integer>(9, 16);
        final BSTNode<Integer> n10 = new BSTNode<Integer>(10, 9);
        final BSTNode<Integer> n11 = new BSTNode<Integer>(11, 8);
        final BSTNode<Integer> n12 = new BSTNode<Integer>(12, 7);
        final BSTNode<Integer> n13 = new BSTNode<Integer>(13, 12);
        
        final TComparator<Integer> sideKick = new TComparator<Integer>();
        final BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(n1, sideKick);
        
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
        
        final TComparator<Integer> sideKick = new TComparator<Integer>();
        
        final LLNode<Integer> n1 = new LLNode<Integer>(1, 5);
        final LLNode<Integer> n2 = new LLNode<Integer>(2, 2);
        final LLNode<Integer> n3 = new LLNode<Integer>(3, 6);
        final LLNode<Integer> n4 = new LLNode<Integer>(4, 3);
        final LLNode<Integer> n5 = new LLNode<Integer>(5, 4);
        final LLNode<Integer> n6 = new LLNode<Integer>(6, 1);
        final LLNode<Integer> nn1 = new LLNode<Integer>(1, 5);
        final LLNode<Integer> nn2 = new LLNode<Integer>(2, 2);
        final LLNode<Integer> nn3 = new LLNode<Integer>(3, 6);
        final LLNode<Integer> nn4 = new LLNode<Integer>(4, 3);
        final LLNode<Integer> nn5 = new LLNode<Integer>(5, 4);
        final LLNode<Integer> nn6 = new LLNode<Integer>(6, 1);
        
        final LinkedList<Integer> oll = new OrderedLinkedList<Integer>(sideKick);
        final LinkedList<Integer> ull = new UnorderedLinkedList<Integer>(sideKick);
        
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
        
        final TComparator<Integer> sideKick = new TComparator<Integer>();
        final HashFunction hf = new ExampleHashFunction();
        
        final BSTNode<Integer> n1 = new BSTNode<Integer>(1, 5);
        final BSTNode<Integer> n3 = new BSTNode<Integer>(3, 2);
        final BSTNode<Integer> n4 = new BSTNode<Integer>(4, 10);
        final BSTNode<Integer> n5 = new BSTNode<Integer>(5, 15);
        final BSTNode<Integer> n6 = new BSTNode<Integer>(6, 1);
        final BSTNode<Integer> n7 = new BSTNode<Integer>(7, 3);
        final BSTNode<Integer> n8 = new BSTNode<Integer>(8, 0);
        final BSTNode<Integer> n9 = new BSTNode<Integer>(9, 16);
        final BSTNode<Integer> n10 = new BSTNode<Integer>(10, 9);
        final BSTNode<Integer> n11 = new BSTNode<Integer>(11, 8);
        final BSTNode<Integer> n12 = new BSTNode<Integer>(12, 7);
        final BSTNode<Integer> n13 = new BSTNode<Integer>(13, 12);
        
        final HashTable<Integer> ht = new HashTable<Integer>(4, hf, sideKick);
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
        */
        final TComparator<Integer> sideKick = new TComparator<Integer>();

        final LLNode<Integer> n1 = new LLNode<Integer>(1, 5);
        final LLNode<Integer> n2 = new LLNode<Integer>(2, 2);
        final LLNode<Integer> n3 = new LLNode<Integer>(3, 6);
        final LLNode<Integer> n4 = new LLNode<Integer>(4, 3);
        final LLNode<Integer> n5 = new LLNode<Integer>(5, 4);
        final LLNode<Integer> n6 = new LLNode<Integer>(6, 1);
        final LLNode<Integer> nn1 = new LLNode<Integer>(1, 5);
        final LLNode<Integer> nn2 = new LLNode<Integer>(2, 2);
        final LLNode<Integer> nn3 = new LLNode<Integer>(3, 6);
        final LLNode<Integer> nn4 = new LLNode<Integer>(4, 3);
        final LLNode<Integer> nn5 = new LLNode<Integer>(5, 4);
        final LLNode<Integer> nn6 = new LLNode<Integer>(6, 1);

        final Queue<Integer> q = new BonoQueue<Integer>(sideKick);
        final Queue<Integer> q2 = new PriorityBonoQueue<Integer>(sideKick);
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

        System.out.println(q);
        System.out.println(q2);
    }
}
