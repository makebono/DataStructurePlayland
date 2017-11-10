package com.makebono.datastructures.binarysearchtree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.makebono.datastructures.binarysearchtree.bstinterface.BinarySearchTree;

/** 
 * @ClassName: BinarySearchTree 
 * @Description: BST implementation 
 * @author makebono
 * @param <T>
 * @date 2017年11月7日 上午9:55:56 
 *  
 */
public class BinarySearchBonoTree<T> implements BinarySearchTree<T> {
    protected BSTNode<T> root;
    protected int size;

    // Need a comparator to help ordering the tree. You may need to write your own.
    protected final Comparator<T> sideKick;

    public BinarySearchBonoTree(final Comparator<T> sideKick) {
        this.root = null;
        this.size = 0;
        this.sideKick = sideKick;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public BSTNode<T> getRoot() {
        return this.root;
    }

    @Override
    public void destroy() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void addNode(final BSTNode<T> node) {
        this.addNode(node, this.getRoot());
        this.size++;
    }

    // Follows definition of BST.
    // Well, because I am lazy, from now the data is also force to be unique in tree.
    private void addNode(final BSTNode<T> node, final BSTNode<T> root) {
        if (this.getRoot() == null) {
            this.root = node;
        } else {
            if (this.getByIndex(node.getIndex()) != null) {
                System.out.println("Index should be unique in this tree.");
                this.size--;
            } else {
                if (this.sideKick.compare(node.getData(), root.getData()) < 0) {
                    if (root.getL() == null) {} else {
                        addNode(node, root.getL());
                    }
                } else if (this.sideKick.compare(node.getData(), root.getData()) > 0) {
                    if (root.getR() == null) {
                        root.setR(node);
                    } else {
                        addNode(node, root.getR());
                    }
                } else {
                    System.out.println("Data should be unique in this tree.");
                    this.size--;
                }
            }
        }
    }

    // Breadth first search, return an ordered array list for further manipulation.
    @Override
    public ArrayList<BSTNode<T>> bfs() {
        final ArrayList<BSTNode<T>> bfsResult = new ArrayList<BSTNode<T>>();
        final Queue<BSTNode<T>> queue = new LinkedList<BSTNode<T>>();
        queue.add(this.getRoot());
        BSTNode<T> temp;

        while (!queue.isEmpty()) {
            temp = queue.poll();
            bfsResult.add(temp);
            if (temp.getL() != null) {
                queue.add(temp.getL());
            }

            if (temp.getR() != null) {
                queue.add(temp.getR());
            }
        }

        return bfsResult;
    }

    // Depth first search, return an ordered array list for further manipulation.
    @Override
    public ArrayList<BSTNode<T>> dfs() {
        final ArrayList<BSTNode<T>> dfsResult = new ArrayList<BSTNode<T>>();
        final Stack<BSTNode<T>> stack = new Stack<BSTNode<T>>();
        stack.add(this.getRoot());
        BSTNode<T> temp;

        while (!stack.isEmpty()) {
            temp = stack.pop();
            dfsResult.add(temp);
            if (temp.getR() != null) {
                stack.add(temp.getR());
            }

            if (temp.getL() != null) {
                stack.add(temp.getL());
            }
        }

        return dfsResult;
    }

    // Using BFS here. Rewrite as you want.
    @Override
    public BSTNode<T> getByIndex(final int i) {
        BSTNode<T> result = null;
        final Queue<BSTNode<T>> queue = new LinkedList<BSTNode<T>>();
        queue.add(this.getRoot());
        BSTNode<T> temp;

        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp.getIndex() == i) {
                result = temp;
                return result;
            }

            if (temp.getL() != null) {
                queue.add(temp.getL());
            }

            if (temp.getR() != null) {
                queue.add(temp.getR());
            }
        }
        return result;
    }

    // An interface of get method. So user can provide less parameter.
    @Override
    public BSTNode<T> get(final T data) {
        return this.get(data, this.getRoot());
    }

    // Implemantation of get method, same idea as in add method.
    private BSTNode<T> get(final T data, final BSTNode<T> root) {
        final BSTNode<T> result = null;
        if (root == null) {
            return result;
        } else {
            if (this.sideKick.compare(data, root.getData()) == 0) {
                return root;
            } else {
                if (this.sideKick.compare(data, root.getData()) < 0) {
                    return get(data, root.getL());
                } else {
                    return get(data, root.getR());
                }
            }
        }
    }

    // An interface of finding maximum data in left subtree, only provide such searching for root's subtree. Change the
    // availability of method below this method to public if you really need it.
    @Override
    public BSTNode<T> lMax() {
        return this.lMax(this.getRoot());
    }

    // Implementation of finding maximum data in left subtree.
    protected BSTNode<T> lMax(final BSTNode<T> root) {
        BSTNode<T> result = null;
        if (root.getL() != null) {
            result = root.getL();
            while (result.getR() != null && result.getR().getData() != null) {
                result = result.getR();
            }
            return result;
        } else {
            return result;
        }
    }

    // An interface of finding minimum data in right subtree, only provide such searching for root's subtree. Change
    // the availability of method below this method to public if you really need it.
    @Override
    public BSTNode<T> rMin() {
        return this.rMin(this.getRoot());
    }

    // Implementation of finding minimum data in right subtree.
    protected BSTNode<T> rMin(final BSTNode<T> root) {
        BSTNode<T> result = null;
        if (root.getR() != null) {
            result = root.getR();
            while (result.getL() != null && result.getL().getData() != null) {
                result = result.getL();
            }
            return result;
        } else {
            return result;
        }
    }

    // Delete node by index. Call delete by data inside.
    @Override
    public void delByIndex(final int index) {
        if (this.size() == 0) {
            System.out.println("This is an empty tree.");
        } else {
            final BSTNode<T> target = this.getByIndex(index);
            if (target != null) {
                this.del(target.getData());
            } else {
                System.out.println("Your input isn't in this tree.");
            }
        }
    }

    // Delete by data. Do the decrement of size just one time here. Or there maybe problems during recursion process.
    // This is another critical reason I write a little interface here. It's not only just for convenience.
    @Override
    public void del(final T data) {
        if (this.size() == 0) {
            System.out.println("This is an empty tree.");
        } else {
            this.root = this.del(data, this.getRoot());
            size--;
        }
    }

    // Implementation of delete by data. Several cases to be handled with. This is the most important part of
    // implementing a BST.
    private BSTNode<T> del(final T data, final BSTNode<T> root) {
        // final BSTNode<T> target = this.get(data);
        BSTNode<T> tempRoot = root;

        // What was I thinking... Where is the necessity for searching twice?
        // if (target == null) {
        // System.out.println("Your input isn't in this tree.");
        // size++;
        // return root;
        // }

        // Case 1: Invalid input, search for the input first to decide. Do nothing. But remember to increase the size
        // because once this method is called, the size is decreased.
        if (this.sideKick.compare(data, root.getData()) != 0 && root.isLeaf()) {
            System.out.println("Your input isn't in this tree.");
            size++;
            return root;
        } else {
            // Search for the node by property of BST. Do recursion call.
            if (this.sideKick.compare(data, tempRoot.getData()) < 0) {
                tempRoot.setL(del(data, tempRoot.getL()));
                return tempRoot;
            }
            if (this.sideKick.compare(data, tempRoot.getData()) > 0) {
                tempRoot.setR(del(data, tempRoot.getR()));
                return tempRoot;
            } else {

                // Case 2: Target is a leaf. Just delete it.
                if (tempRoot.isLeaf()) {
                    return null;

                    // Case 3: Target only has left/right child. Just replace it with its left/right child.
                } else if (tempRoot.getL() != null && tempRoot.getR() == null) {
                    return tempRoot.getL();
                } else if (tempRoot.getL() == null && tempRoot.getR() != null) {
                    return tempRoot.getR();

                    // Case 4: Most common(it should be in practical using) and complicated case. Target has both
                    // children. In this case, you need to replace the target node with the maximum node in it's left
                    // subtree, or minimum in the right subtree. And then delete the left maximum(or right minimum).
                    // This could create disasters when in a relatively massive tree. But you can leave the disaster
                    // to recursion deletion call. Just need to understand this idea.
                } else {
                    final BSTNode<T> temp = tempRoot;
                    tempRoot = this.lMax(temp);
                    tempRoot.setL(del(this.lMax(temp).getData(), temp.getL()));
                    tempRoot.setR(temp.getR());
                    return tempRoot;
                }
            }
        }
    }

    @Override
    public String printBFS() {
        final StringBuilder sb = new StringBuilder();
        for (final BSTNode<T> node : this.bfs()) {
            sb.append("Node(" + node.getIndex() + ", " + node.getData() + ") ");
        }
        return sb.toString();
    }

    @Override
    public String printDFS() {
        final StringBuilder sb = new StringBuilder();
        for (final BSTNode<T> node : this.dfs()) {
            sb.append("Node(" + node.getIndex() + ", " + node.getData() + ") ");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        if (this.getRoot() == null) {
            sb.append("This is an empty tree.");
            return sb.toString();
        }

        sb.append("This is a " + this.getClass().getName() + ".\n\nThe BFS traversal for this tree goes like below:\n");
        for (final BSTNode<T> node : this.bfs()) {
            sb.append("Node(" + node.getIndex() + ", " + node.getData() + ") ");
        }

        sb.append("\n\nThe DFS traversal for this tree goes like below:\n");
        for (final BSTNode<T> node : this.dfs()) {
            sb.append("Node(" + node.getIndex() + ", " + node.getData() + ") ");
        }
        sb.append("\n\nIts size is: " + this.size() + ".");
        return sb.toString();
    }
}
