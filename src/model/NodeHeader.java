package model;

public interface NodeHeader {

    public NodeType getNodeType();

    public int getHeaderSize();
    
    public byte[] getAsArray();

}
