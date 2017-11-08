package com.makebono.datastructures.hashtable;

import java.util.Comparator;

import com.makebono.datastructures.binarysearchtree.BSTNode;
import com.makebono.datastructures.tools.hashfunction.hashfunctioninterface.HashFunction;

/** 
 * @ClassName: HashTable 
 * @Description: Hash table 
 * @author makebono
 * @param <T>
 * @date 2017年11月8日 上午11:49:40 
 *  
 */
@SuppressWarnings("unchecked")
public class HashTable<T> {
    private HTBucket<T>[] table;
    int tables;
    private int size;
    private final HashFunction hashFunction;
    private final Comparator<T> sideKick;

    public HashTable(final int tables, final HashFunction hashFunction, final Comparator<T> sideKick) {
        this.size = 0;
        this.tables = tables;
        this.hashFunction = hashFunction;
        this.sideKick = sideKick;

        this.table = new HTBucket[this.tables];

        // Don't forget to instantiate the trees.
        for (int i = 0; i < this.countTables(); i++) {
            this.table[i] = new HTBucket<T>(this.sideKick);
        }
    }

    public void destroy() {
        this.table = new HTBucket[this.countTables()];
        this.size = 0;
    }

    public HTBucket<T>[] getTable() {
        return this.table;
    }

    public int size() {
        return this.size;
    }

    public int countTables() {
        return this.tables;
    }

    public void add(final BSTNode<T> node) {
        final int hashKey = this.hashFunction.hash(node.getIndex());
        this.getTable()[hashKey].addNode(node);
        this.size++;
    }

    public BSTNode<T> get(final int index) {
        final int hashKey = this.hashFunction.hash(index);
        return this.getTable()[hashKey].getByIndex(index);
    }

    // As in the binary search tree. I don't force the uniqueness on index and data. So it will delete the first item
    // found in table. If you need to add limitation, do it in add method.
    public void del(final int index) {
        final BSTNode<T> temp = this.get(index);
        if (temp != null) {
            final int hashKey = this.hashFunction.hash(index);
            this.getTable()[hashKey].delByIndex(index);
            this.size--;
        } else {
            System.out.println("Your input is not in the table.");
        }

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        if (this.size() == 0) {
            sb.append("This is an empty table.");
        } else {
            sb.append("This is a " + this.getClass().getName() + ".\nIt has tables: \n\n");

            for (int i = 0; i < this.countTables(); i++) {
                sb.append("Table " + i + ":\n    ");
                sb.append(this.getTable()[i].printBFS() + "\n");
            }
            sb.append("\n(Traversal shown in breadth first search order)\n\nIt has " + this.size()
                    + " elements in total.");
        }
        return sb.toString();
    }
}
