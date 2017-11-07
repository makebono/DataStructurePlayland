package com.makebono.datastructures.tools.genericnode;

/** 
 * @ClassName: GenericNode 
 * @Description: Generic node class
 * @author makebono
 * @param <T>
 * @date 2017年11月7日 上午9:57:46 
 *  
 */
public abstract class GenericNode<T> {
    private T data;
    private int index;

    public GenericNode() {
        this.index = 0;
        this.data = null;
    }

    public GenericNode(final int index, final T data) {
        this.index = index;
        this.data = data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public void setIndex(final int index) {
        this.index = index;
    }

    public T getData() {
        return this.data;
    }

    public int getIndex() {
        return this.index;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("This is Node" + index);

        return sb.toString();
    }
}
