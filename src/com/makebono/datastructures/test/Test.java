package com.makebono.datastructures.test;

import com.makebono.datastructures.binarysearchtree.BSTNode;
import com.makebono.datastructures.binarysearchtree.BinarySearchTree;
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
        bst.del(5);
        bst.delByIndex(3);
        System.out.println(bst);
        bst.destroy();
        System.out.println(bst);
    }
}
