package com.makebono.datastructures.binarysearchtree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/** 
 * @ClassName: BinarySearchTree 
 * @Description: BST implementation 
 * @author makebono
 * @param <T>
 * @date 2017年11月7日 上午9:55:56 
 *  
 */
public class BinarySearchTree<T> {
    private BSTNode<T> root;
    private int size;

    // Need a comparator to help ordering the tree. You may need to write your own.
    private Comparator<T> sideKick;

    public BinarySearchTree(final Comparator<T> sideKick) {
        this.root = null;
        this.size = 0;
        this.sideKick = sideKick;
    }

    public BinarySearchTree(final BSTNode<T> root, final Comparator<T> sideKick) {
        this.root = root;
        this.size = 1;
        this.sideKick = sideKick;
    }

    public void initiate(final Comparator<T> sideKick) {
        this.root = null;
        this.size = 0;
        this.sideKick = sideKick;
    }

    public int size() {
        return this.size;
    }

    public BSTNode<T> getRoot() {
        return this.root;
    }

    public void destroy() {
        this.root = null;
        this.size = 0;
    }

    public void addNode(final BSTNode<T> node) {
        this.addNode(node, this.getRoot());
        size++;
    }

    // Follows definition of BST.
    private void addNode(final BSTNode<T> node, final BSTNode<T> root) {
        if (this.getRoot() == null) {
            this.root = node;
        } else {
            if (this.getByIndex(node.getIndex()) != null) {
                System.out.println("Index should be unique in this tree.");
                size--;
            } else {
                if (this.sideKick.compare(node.getData(), root.getData()) <= 0) {
                    if (root.getL() == null) {
                        root.setL(node);
                    } else {
                        addNode(node, root.getL());
                    }
                } else {
                    if (root.getR() == null) {
                        root.setR(node);
                    } else {
                        addNode(node, root.getR());
                    }
                }
            }
        }
    }

    // Breadth first search, return an ordered array list for further manipulation.
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
    public BSTNode<T> lMax() {
        return this.lMax(this.getRoot());
    }

    // Implementation of finding maximum data in left subtree.
    private BSTNode<T> lMax(final BSTNode<T> root) {
        BSTNode<T> result = null;
        if (root.getL() != null) {
            result = root.getL();
            while (result.getR() != null) {
                result = result.getR();
            }
            return result;
        } else {
            return result;
        }
    }

    // An interface of finding minimum data in right subtree, only provide such searching for root's subtree. Change
    // the availability of method below this method to public if you really need it.
    public BSTNode<T> rMin() {
        return this.rMin(this.getRoot());
    }

    // Implementation of finding minimum data in right subtree.
    private BSTNode<T> rMin(final BSTNode<T> root) {
        BSTNode<T> result = null;
        if (root.getR() != null) {
            result = root.getR();
            while (result.getL() != null) {
                result = result.getL();
            }
            return result;
        } else {
            return result;
        }
    }

    // Delete node by index. Call delete by data inside.
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

    public String printBFS() {
        final StringBuilder sb = new StringBuilder();
        for (final BSTNode<T> node : this.bfs()) {
            sb.append("Node(" + node.getIndex() + ", " + node.getData() + ") ");
        }
        return sb.toString();
    }

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

        sb.append("The BFS traversal for this binary search tree goes like below:\n");
        for (final BSTNode<T> node : this.bfs()) {
            sb.append("Node(" + node.getIndex() + ", " + node.getData() + ") ");
        }

        sb.append("\n\nThe DFS traversal for this binary search tree goes like below:\n");
        for (final BSTNode<T> node : this.dfs()) {
            sb.append("Node(" + node.getIndex() + ", " + node.getData() + ") ");
        }
        sb.append("\n\nIts size is: " + this.size() + ".");
        return sb.toString();
    }
}
