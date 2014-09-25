package model;

/**
 * @author ThePirateCat
 */
public interface Node {

    public String getName();

    public long getStartAddress();

    public long getEndAddress();
    
    public NodeHeader getNodeHeader();

    public void setName(String newName);
    
}
