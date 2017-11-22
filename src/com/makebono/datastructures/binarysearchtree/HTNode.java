package com.makebono.datastructures.binarysearchtree;

/** 
 * @ClassName: HTNode 
 * @Description: Huffman tree nodes.
 * @author makebono
 * @date 2017年11月22日 下午4:11:29 
 *  
 */
public class HTNode extends BSTNode<Integer> {
    private String code;
    private HTNode lChild;
    private HTNode rChild;

    public HTNode(final int index, final Integer data, final char color) {
        super(index, data, color);
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setL(final HTNode l) {
        this.lChild = l;
    }

    public void setR(final HTNode r) {
        this.rChild = r;
    }

    @Override
    public HTNode getL() {
        return this.lChild;
    }

    @Override
    public HTNode getR() {
        return this.rChild;
    }
}
