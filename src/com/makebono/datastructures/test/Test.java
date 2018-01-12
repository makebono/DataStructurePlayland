package com.makebono.datastructures.test;

import com.makebono.datastructures.twotritree.Bono23Node;
import com.makebono.datastructures.twotritree.Bono23Tree;

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
        final BinarySearchTree<Integer> bst = new BinarySearchBonoTree<Integer>(sideKick);
        
        bst.addNode(n1);
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
        final LLNode<Integer> nnn1 = new LLNode<Integer>(1, 5);
        final LLNode<Integer> nnn2 = new LLNode<Integer>(2, 2);
        final LLNode<Integer> nnn3 = new LLNode<Integer>(3, 6);
        final LLNode<Integer> nnn4 = new LLNode<Integer>(4, 3);
        final LLNode<Integer> nnn5 = new LLNode<Integer>(5, 4);
        final LLNode<Integer> nnn6 = new LLNode<Integer>(6, 1);
        
        final Queue<Integer> q = new BonoQueue<Integer>(sideKick);
        final Queue<Integer> q2 = new PriorityBonoQueue<Integer>(sideKick);
        final Stack<Integer> s = new BonoStack<Integer>(sideKick);
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
        s.add(new LLNode<Integer>(1, 333));
        System.out.println(q);
        System.out.println(q2);
        System.out.println(s);
        
        final int size = s.size();
        for (int i = 0; i < size; i++) {
            System.out.printf("Poping out from stack: %d\n", s.pop().getIndex());
        }
        System.out.println(s);
        
        
        final LLNode<int[]> n1 = new LLNode<int[]>(1, new int[] { 5, 20 });
        final LLNode<int[]> n2 = new LLNode<int[]>(2, new int[] { 6, 15 });
        final LLNode<int[]> n3 = new LLNode<int[]>(3, new int[] { 1, 10 });
        final LLNode<int[]> n4 = new LLNode<int[]>(4, new int[] { 5, 11 });
        final LLNode<int[]> n5 = new LLNode<int[]>(5, new int[] { 9, 20 });
        final LLNode<int[]> n6 = new LLNode<int[]>(6, new int[] { 11, 9 });
        
        final RoundRobinComparator sideKick = new RoundRobinComparator();
        
        final Queue<int[]> rrq = new RoundRobinBonoQueue<int[]>(sideKick, 10);
        
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
        final RedBlackBonoTree<Integer> rbt = new RedBlackBonoTree<Integer>(sideKick);
        
        rbt.addNode(n1);
        rbt.addNode(n3);
        rbt.addNode(n4);
        rbt.addNode(n5);
        rbt.addNode(n6);
        rbt.addNode(n7);
        rbt.addNode(n8);
        rbt.addNode(n9);
        rbt.addNode(n10);
        rbt.addNode(n11);
        rbt.addNode(n12);
        rbt.addNode(n13);
        
        rbt.addNode(new BSTNode<Integer>(111, 5));
        System.out.println(rbt);
        
        rbt.del(5);
        
        System.out.println(rbt);
        
        final Vertex<Integer> v1 = new Vertex<Integer>(1, 5, 0, 0);
        final Vertex<Integer> v2 = new Vertex<Integer>(2, 1, 1, 4);
        final Vertex<Integer> v3 = new Vertex<Integer>(3, 15, 1.2, 3);
        final Vertex<Integer> v4 = new Vertex<Integer>(4, 21, 1, 7);
        final Vertex<Integer> v5 = new Vertex<Integer>(5, 55, 8, 1);
        final Vertex<Integer> v6 = new Vertex<Integer>(6, 1, 11, 44);
        final Vertex<Integer> v7 = new Vertex<Integer>(7, 0, 6, 12);
        final Vertex<Integer> v8 = new Vertex<Integer>(8, 11, 7, 1);
        
        final Graph<Integer> g = new BonoGraph<Integer>();
        g.add(v1, v2);
        g.add(v2, v3);
        g.add(v3, v4);
        g.add(v4, v5);
        g.add(v5, v1);
        g.add(v4, v1);
        g.add(v4, v6);
        g.add(v3, v8);
        g.add(v6, v7);
        
        System.out.println(g);
        System.out.println(g.MST());
        
        
        
        final Comparator<Vertex<Integer>> pc = new CounterClockwisedScan<Integer>();
        
        final Vertex<Integer> v1 = new Vertex<Integer>(1, 0, 1, -0.5);
        final Vertex<Integer> v2 = new Vertex<Integer>(2, 0, -1, 1);
        
        System.out.println(pc.compare(v1, v2));
        */
        final Bono23Tree<Integer> b23t = new Bono23Tree<Integer>();
        final Bono23Node<Integer> n1 = new Bono23Node<Integer>(1, 13);
        final Bono23Node<Integer> n2 = new Bono23Node<Integer>(2, 9);
        final Bono23Node<Integer> n3 = new Bono23Node<Integer>(3, 15);
        final Bono23Node<Integer> n4 = new Bono23Node<Integer>(4, 1);
        final Bono23Node<Integer> n5 = new Bono23Node<Integer>(5, 10);
        final Bono23Node<Integer> n6 = new Bono23Node<Integer>(6, 7);
        final Bono23Node<Integer> n7 = new Bono23Node<Integer>(7, 66);
        final Bono23Node<Integer> n8 = new Bono23Node<Integer>(8, 10);
        final Bono23Node<Integer> n9 = new Bono23Node<Integer>(9, 4);
        final Bono23Node<Integer> n10 = new Bono23Node<Integer>(10, 11);
        final Bono23Node<Integer> n11 = new Bono23Node<Integer>(11, 8);
        final Bono23Node<Integer> n12 = new Bono23Node<Integer>(12, 0);
        final Bono23Node<Integer> n13 = new Bono23Node<Integer>(13, 2);
        final Bono23Node<Integer> n14 = new Bono23Node<Integer>(14, 3);
        final Bono23Node<Integer> n15 = new Bono23Node<Integer>(15, 16);
        final Bono23Node<Integer> n16 = new Bono23Node<Integer>(16, 12);
        final Bono23Node<Integer> n17 = new Bono23Node<Integer>(17, 21);
        final Bono23Node<Integer> n18 = new Bono23Node<Integer>(18, 30);
        final Bono23Node<Integer> n19 = new Bono23Node<Integer>(19, 6);
        final Bono23Node<Integer> n20 = new Bono23Node<Integer>(20, 19);

        b23t.addNode(n1);
        b23t.addNode(n2);
        b23t.addNode(n3);
        b23t.addNode(n4);
        b23t.addNode(n5);
        b23t.addNode(n6);
        b23t.addNode(n7);
        b23t.addNode(n8);
        b23t.addNode(n9);
        b23t.addNode(n10);
        b23t.addNode(n11);
        b23t.addNode(n12);
        b23t.addNode(n13);
        b23t.addNode(n14);
        b23t.addNode(n15);
        b23t.addNode(n16);
        b23t.addNode(n17);
        b23t.addNode(n18);
        b23t.addNode(n19);
        b23t.addNode(n20);

        System.out.println(b23t);
        b23t.del(7);
        System.out.println(b23t);
    }
}
