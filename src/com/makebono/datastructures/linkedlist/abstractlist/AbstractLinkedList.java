package com.makebono.datastructures.linkedlist.abstractlist;

import java.util.Comparator;

import com.makebono.datastructures.linkedlist.LLNode;

/** 
 * @ClassName: AbstractLinkedList 
 * @Description: Abstract class of linked list. Will be extended by ordered and unordered linked list.
 * @author makebono
 * @date 2017年11月8日 上午9:13:39 
 *  
 */

public abstract class AbstractLinkedList<T> {
    private LLNode<T> head;
    private LLNode<T> tail;
    private int size;
    protected Comparator<T> sideKick;

    public AbstractLinkedList(final Comparator<T> sideKick) {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.sideKick = sideKick;
    }

    public void destroy() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    protected void setHead(final LLNode<T> head) {
        this.head = head;
    }

    protected void setTail(final LLNode<T> tail) {
        this.tail = tail;
    }

    protected void grow() {
        this.size++;
    }

    protected void decline() {
        this.size--;
    }

    public LLNode<T> getHead() {
        return this.head;
    }

    public LLNode<T> getTail() {
        return this.tail;
    }

    public int size() {
        return this.size;
    }

    public abstract void add(LLNode<T> node);

    public LLNode<T> get(final T data) {
        LLNode<T> cursor = null;
        if (this.size() == 0) {
            System.out.println("This is an empty list.");
        } else {
            cursor = this.getHead();
            if (this.sideKick.compare(data, cursor.getData()) == 0) {
                return cursor;
            } else {
                if (!cursor.hasNext()) {
                    return null;
                } else {
                    while (cursor.hasNext()) {
                        cursor = cursor.getNext();
                        if (this.sideKick.compare(data, cursor.getData()) == 0) {
                            return cursor;
                        }
                    }
                    return null;
                }
            }
        }
        return cursor;
    }

    public LLNode<T> getByIndex(final int index) {
        LLNode<T> cursor = null;
        if (this.size() == 0) {
            System.out.println("This is an empty list.");
        } else {
            cursor = this.getHead();
            if (index == cursor.getIndex()) {
                return cursor;
            } else {
                if (!cursor.hasNext()) {
                    return null;
                } else {
                    while (cursor.hasNext()) {
                        cursor = cursor.getNext();
                        if (index == cursor.getIndex()) {
                            return cursor;
                        }
                    }
                    return null;
                }
            }
        }
        return cursor;
    }

    public boolean del(final T data) {
        return this.delete(data);
    }

    private boolean delete(final T data) {
        LLNode<T> cursor = null;
        if (this.size() == 0) {
            System.out.println("This is an empty list.");
            return false;
        } else {
            cursor = this.getHead();
            if (this.sideKick.compare(data, cursor.getData()) == 0) {
                if (!cursor.hasNext()) {
                    this.destroy();
                } else {
                    this.setHead(cursor.getNext());
                    cursor.setNext(null);
                    this.decline();
                }
                return true;
            } else {
                if (!cursor.hasNext()) {
                    System.out.println("Your input isn't in this list.");
                } else {
                    while (cursor.hasNext()) {
                        if (this.sideKick.compare(data, cursor.getNext().getData()) == 0) {
                            if (cursor.getNext() == this.getTail()) {
                                this.setTail(cursor);
                                cursor.setNext(null);
                                this.decline();
                                return true;
                            } else {
                                final LLNode<T> temp = cursor.getNext();
                                cursor.setNext(cursor.getNext().getNext());
                                temp.setNext(null);
                                this.decline();
                                return true;
                            }
                        }
                        cursor = cursor.getNext();
                    }
                }
            }
        }
        return false;
    }

    public boolean delByIndex(final int index) {
        return this.deleteByIndex(index);
    }

    private boolean deleteByIndex(final int index) {
        LLNode<T> cursor = null;
        if (this.size() == 0) {
            System.out.println("This is an empty list.");
            return false;
        } else {
            cursor = this.getHead();
            if (index == cursor.getIndex()) {
                if (!cursor.hasNext()) {
                    this.destroy();
                } else {
                    this.setHead(cursor.getNext());
                    this.decline();
                }
                return true;
            } else {
                if (!cursor.hasNext()) {
                    System.out.println("Your input isn't in this list.");
                } else {
                    while (cursor.hasNext()) {
                        if (index == cursor.getNext().getIndex()) {
                            if (cursor.getNext() == this.getTail()) {
                                this.setTail(cursor);
                                cursor.setNext(null);
                                this.decline();
                                return true;
                            } else {
                                cursor.setNext(cursor.getNext().getNext());
                                this.decline();
                                return true;
                            }
                        }
                        cursor = cursor.getNext();
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        if (this.size() == 0) {
            sb.append("This is an empty list");
        } else {
            sb.append("This is a " + this.getClass().getName());
            sb.append(". It has nodes: \n");
            LLNode<T> cursor = this.getHead();
            sb.append("Node(" + cursor.getIndex() + ", " + cursor.getData() + ") ");
            while (cursor.hasNext()) {
                cursor = cursor.getNext();
                sb.append("Node(" + cursor.getIndex() + ", " + cursor.getData() + ") ");
            }
            sb.append("\nIts size is: " + this.size() + ".");
        }
        return sb.toString();
    }
}
